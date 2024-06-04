package com.dan15d.codetest.ui.screens.user_list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dan15d.codetest.domain.model.User
import com.dan15d.codetest.ui.screens.user_list.shimmer.ListShimmer
import com.dan15d.codetest.ui.screens.user_list.user_item.UserItem
import com.dan15d.codetest.utils.StringUtils
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserList(modifier: Modifier = Modifier, navController: NavHostController) {

    val vm = koinViewModel<UserListViewModel>()
    val uiState by vm.state.collectAsState()

    @SuppressLint("NewApi")
    fun onClickItem(user: User, navController: NavHostController){
        val bytesUTF8 = StringUtils.toUTF8Base64(Json.encodeToString(user))

        navController.navigate(
            "detail/{user}"
                .replace(
                    oldValue = "{user}",
                    newValue = bytesUTF8
                )
        )
    }

    Column (modifier){
        when (uiState.isLoading) {
            true -> ListShimmer()
            false -> LazyListUsers(uiState.users) { user ->
                onClickItem(
                    user = user,
                    navController = navController
                )
            }
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        vm.getUsers()
    })
}

@Composable
fun LazyListUsers(users: ArrayList<User>, onClickItem:(user: User) -> Unit){
    LazyColumn (modifier = Modifier.padding(horizontal = 16.dp)) {
        items(users){ user ->
            UserItem(user = user, onClickItem = onClickItem)
        }
    }
}



