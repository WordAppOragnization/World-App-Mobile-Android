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
import com.natiqhaciyef.wordlearningapp.ui.theme.AppDarkTeal
import com.natiqhaciyef.wordlearningapp.ui.theme.AppLightTeal
import com.natiqhaciyef.wordlearningapp.ui.theme.AppOrange
import com.natiqhaciyef.wordlearningapp.ui.theme.AppTeal
import com.natiqhaciyef.wordlearningapp.view.components.BottomShadow
import com.natiqhaciyef.wordlearningapp.view.navigation.ScreenID

@Preview
@Composable
fun ResetPasswordScreen(){
    val email = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ResetPasswordTopView()
        ResetPasswordBodyView(email)
    }
}

@Preview
@Composable
fun ResetPasswordTopView() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.reset_password_animation)
    )

    Spacer(modifier = Modifier.height(40.dp))

    LottieAnimation(
        composition = composition,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(start = 30.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Reset Password",
        fontSize = 25.sp,
        color = Color.Black,
        fontFamily = FontList.fontFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(25.dp))

}


@Preview
@Composable
fun ResetPasswordBodyView(
    email: MutableState<String> = mutableStateOf("")
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(),
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        backgroundColor = AppOrange
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(50.dp))

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
                    focusedBorderColor = AppLightTeal,
                    cursorColor = AppDarkTeal
                ),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle.Default.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            BottomShadow(padding = 23.dp)

            Spacer(modifier = Modifier.height(10.dp))

            ResetPasswordBottomView()
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}

@Composable
fun ResetPasswordBottomView() {
    val context = LocalContext.current
    Spacer(modifier = Modifier.height(10.dp))

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
            .clickable {

            },
        text = "Please check your email, we will send the reset password link. If it is not show, check spam messages box.",
        color = Color.White,
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold,
    )

    Spacer(modifier = Modifier.height(30.dp))

    Button(
        modifier = Modifier
            .height(50.dp)
            .width(180.dp),
        onClick = {
            // reset password notification
        },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppTeal
        )
    ) {
        Text(
            text = "Send",
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

    Spacer(modifier = Modifier.height(10.dp))
}