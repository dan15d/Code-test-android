package com.dan15d.codetest.datasource.remote.model

import com.dan15d.codetest.domain.model.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserServerResponse (
    @SerialName(value = "page") var page: Int,
    @SerialName(value = "per_page") var perPage: Int,
    @SerialName(value = "total") var total: Int,
    @SerialName(value = "total_pages") var totalPages: Int,
    @SerialName(value = "data") var data: ArrayList<Data>


){
    fun toUserList(): ArrayList<User>{
        val userList = ArrayList<User>()

        data.forEach {
            val user = User(
                id = it.id,
                email = it.email,
                name = it.firstName,
                lastName = it.lastName,
                avatar = it.avatar
            )

            userList.add(user)
        }

        return userList
    }
}

@Serializable
data class Data (
    @SerialName(value = "id") var id: Int,
    @SerialName(value = "email") var email: String,
    @SerialName(value = "first_name") var firstName: String,
    @SerialName(value = "last_name") var lastName: String,
    @SerialName(value = "avatar") var avatar: String


)