package com.natiqhaciyef.wordlearningapp.view.screens.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.natiqhaciyef.wordlearningapp.R
import com.natiqhaciyef.wordlearningapp.data.util.FontList
import com.natiqhaciyef.wordlearningapp.ui.theme.AppDarkCadetBlue
import com.natiqhaciyef.wordlearningapp.ui.theme.AppGreenBlue
import com.natiqhaciyef.wordlearningapp.ui.theme.AppDarkGreenBlue
import com.natiqhaciyef.wordlearningapp.ui.theme.AppTeal
import com.natiqhaciyef.wordlearningapp.view.components.BottomShadow
import com.natiqhaciyef.wordlearningapp.view.navigation.ScreenID

@Composable
fun LoginScreen(
    navController: NavController
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LoginTopView()
        LoginBodyView(email, password, navController)
    }
}

@Preview
@Composable
fun LoginTopView() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.login_animation)
    )

    Spacer(modifier = Modifier.height(10.dp))

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Login",
        fontSize = 25.sp,
        color = Color.Black,
        fontFamily = FontList.fontFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(25.dp))

}

//@Preview
@Composable
fun LoginBodyView(
    email: MutableState<String> = mutableStateOf(""),
    password: MutableState<String> = mutableStateOf(""),
    navController: NavController
) {
    var passwordVisible by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(),
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        backgroundColor = AppDarkGreenBlue
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                placeholder = {
                    Text(text = "Email")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedBorderColor = AppGreenBlue,
                    cursorColor = AppDarkCadetBlue
                ),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle.Default.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            BottomShadow(padding = 23.dp)

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                singleLine = true,
                placeholder = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password"
                    )
                },
                visualTransformation =
                if (passwordVisible)
                    VisualTransformation.None
                else PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    trailingIconColor = Color.Black,
                    focusedBorderColor = AppGreenBlue,
                    cursorColor = AppDarkCadetBlue
                ),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle.Default.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(
                        modifier = Modifier.padding(end = 15.dp),
                        onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                }
            )

            BottomShadow(padding = 23.dp)

            Spacer(modifier = Modifier.height(3.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
                    .clickable {
                        navController.navigate(ScreenID.ResetPasswordScreen.name)
                    },
                text = "Forgot password ?",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.End
            )
            Spacer(modifier = Modifier.height(20.dp))

            LoginBottomView(navController)
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}

@Composable
fun LoginBottomView(
    navController: NavController
) {
    val context = LocalContext.current
    Button(
        modifier = Modifier
            .height(50.dp)
            .width(180.dp),
        onClick = {
            // sign up panel
        },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppTeal
        )
    ) {
        Text(
            text = "Login",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }

    BottomShadow(
        modifier = Modifier
            .width(165.dp)
            .height(8.dp)
            .padding(horizontal = 0.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.1f),
                        Color.Transparent,
                    )
                )
            )
    )

    Spacer(modifier = Modifier.height(12.dp))

    Text(
        text = "Or sign in via",
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.White
    )

    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.google_icon),
            contentDescription = "Google icon",
            modifier = Modifier
                .size(45.dp)
                .padding(top = 5.dp)
        )

        Spacer(modifier = Modifier.width(30.dp))

        Image(
            painter = painterResource(id = R.drawable.apple_icon),
            contentDescription = "Apple icon",
            modifier = Modifier.size(45.dp)
        )
    }

    Spacer(modifier = Modifier.height(10.dp))

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "You don't have an account?",
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            modifier = Modifier
                .clickable {
                    // go to login
                    navController.navigate(ScreenID.RegisterScreen.name)
                },
            text = "Sign up",
            color = AppGreenBlue,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}