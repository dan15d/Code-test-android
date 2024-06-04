package com.dan15d.codetest.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User (
    var id: Int,
    var email: String,
    var name: String,
    var lastName: String,
    var avatar: String
)

