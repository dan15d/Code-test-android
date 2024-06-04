package com.dan15d.codetest.ui.screens.user_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dan15d.codetest.domain.model.User
import com.dan15d.codetest.ui.components.atoms.images.AsyncDetailAvatar
import com.dan15d.codetest.ui.components.atoms.text.EmailText
import com.dan15d.codetest.ui.components.atoms.text.NameText
import io.ktor.websocket.Frame

@ExperimentalMaterial3Api
@Composable
fun UserDetail(user: User, navController: NavHostController){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Frame.Text(text = user.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Avatar
            AsyncDetailAvatar(url = user.avatar)

            Spacer(modifier = Modifier.height(16.dp))

            // User information
            Column {
                NameText(
                    text = "${user.name} ${user.lastName}",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                EmailText(user.email)
            }
        }
    }

}