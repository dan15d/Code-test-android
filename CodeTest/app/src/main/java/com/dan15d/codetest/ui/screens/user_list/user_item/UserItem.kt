package com.dan15d.codetest.ui.screens.user_list.user_item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dan15d.codetest.domain.model.User
import com.dan15d.codetest.ui.components.atoms.images.CardAvatar
import com.dan15d.codetest.ui.components.atoms.text.EmailText
import com.dan15d.codetest.ui.components.atoms.text.NameText

@Composable
fun UserItem(user: User, onClickItem :(user: User) -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClickItem(user) },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CardAvatar(url = user.avatar)

            Spacer(modifier = Modifier.width(16.dp))

            // User information
            Column {
                NameText("${user.name} ${user.lastName}")
                EmailText(user.email)
            }
        }
    }
}
