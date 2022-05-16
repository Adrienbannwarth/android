package com.example.myapplication.views.login
import com.example.myapplication.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MainOrange
import com.example.myapplication.ui.theme.OpacityOrange

@Composable
fun SignIn() {
    val configuration = LocalConfiguration.current

    var name = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }

    val screenWidth = configuration.screenWidthDp.dp


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.White)
    ) {

        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Bonsoir",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(screenWidth / 2)
        )
        Text(
            "LOGIN",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(vertical = 10.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Field(name.value, onValueChange = { name.value = it }, label="Username")
            Field(password.value, onValueChange = { password.value = it }, label="Password", isPassword = true)
        }
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End, modifier=Modifier.padding(20.dp)) {
            SignInButton(onClick= { })
        }
        Spacer(modifier= Modifier.weight(1f))
    }
}

@Composable
fun Field(
    value: String,
    isPassword: Boolean = false,
    label: String = "",
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        shape = RoundedCornerShape(30.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor= OpacityOrange,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
    )
}

@Composable
fun SignInButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            backgroundColor = MainOrange,
        ),
        shape = RoundedCornerShape(30.dp),
    ) {
        Text(text = "Login", modifier = Modifier.padding(10.dp).fillMaxWidth(), textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun SignInPreview() {
    SignIn()
}