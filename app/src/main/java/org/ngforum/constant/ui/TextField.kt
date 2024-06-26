package org.ngforum.constant.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ngforum.R
import org.ngforum.ui.theme.dTextBg

@Preview(showBackground = true)
@Composable
fun LoginTextField() {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.height(45.dp),
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        singleLine = true,
        label = { Text(text = "Логін") },
        shape = RoundedCornerShape(2.dp),
        textStyle = TextStyle(color = dTextBg),
        colors = TextFieldDefaults.colors(

        )
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        modifier = Modifier.height(45.dp),
        value = password,
        onValueChange = { newPassword ->
            password = newPassword
        },
        singleLine = true,
        label = { Text(text = "Пароль") },
        shape = RoundedCornerShape(2.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(
                        id = if (passwordVisible) R.drawable.eye_on
                        else R.drawable.eye_off
                    ), contentDescription = "eye"
                )
            }
        },
        textStyle = TextStyle(color = dTextBg),
    )
}