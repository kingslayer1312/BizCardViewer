package com.hrishi.businesscardviewer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrishi.businesscardviewer.ui.theme.BusinessCardViewerTheme

val ChampagnePink = Color(0xFFEFD9CE)
val Plum = Color(0xFF8F3985)
val SpaceCadet = Color(0xFF25283D)
val BlizzardBlue = Color(0xFF98DFEA)
val IndigoDye = Color(0xFF284B63)
val Gainsboro = Color(0xFFD9D9D9)
val Ming = Color(0xFF3C6E71)

val titles = listOf("Mobile", "Email", "LinkedIn")
val content = listOf("+91 9940316676", "hrishabari@gmail.com", "Hrishikesh Naramparambath")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {

    val buttonClickedState1 = remember {
        mutableStateOf(false)
    }

    val buttonClickedState2 = remember {
        mutableStateOf(false)
    }


    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Gainsboro

    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(5.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Gainsboro,
            elevation = 4.dp
        ) {

            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                CreateImageProfile()
                Divider()
                CreateInfo()

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {

                    Button(colors = ButtonDefaults.buttonColors(
                        backgroundColor = IndigoDye,
                        contentColor = Color.LightGray
                    ),
                        shape = RoundedCornerShape(50),
                        onClick = {
                            buttonClickedState1.value = !buttonClickedState1.value

                        }) {
                        Text(
                            text = "EDIT DETAILS",
                            style = MaterialTheme.typography.button
                        )

                    }

                    Button(colors = ButtonDefaults.buttonColors(
                        backgroundColor = IndigoDye,
                        contentColor = Color.LightGray
                    ),
                        shape = RoundedCornerShape(50),
                        onClick = {
                        buttonClickedState2.value = !buttonClickedState2.value

                    }) {
                        Text(
                            text = "PORTFOLIO",
                            style = MaterialTheme.typography.button
                        )

                    }
                }

                if (buttonClickedState1.value) {
                    EditContent()
                } else {
                    if (buttonClickedState2.value) {
                        Content()
                    } else {
                        Box() {

                        }
                    }
                }

                if (buttonClickedState2.value) {
                    Content()
                } else {
                    Box() {

                    }
                }

            }
        }
    }
}

@Composable
fun EditContent() {
    /*TODO*/
}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(10),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = titles)


        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(modifier = Modifier.background(Ming)) {
        item {
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(50),
                elevation = 4.dp,
                backgroundColor = Gainsboro
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Gainsboro)
                        .padding(7.dp)
                ) {
                    CreatePhoneImage(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = titles[0], color = Color.Black, fontWeight = FontWeight.Bold)
                        Text(text = content[0], color = Color.Black, style = MaterialTheme.typography.body2)
                    }

                }
            }
        }

        item {
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(50),
                elevation = 4.dp,
                backgroundColor = Gainsboro
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Gainsboro)
                        .padding(7.dp)
                ) {
                    CreateMailImage(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = titles[1], color = Color.Black, fontWeight = FontWeight.Bold)
                        Text(text = content[1], color = Color.Black, style = MaterialTheme.typography.body2)
                    }

                }
            }
        }

        item {
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(50),
                elevation = 4.dp,
                backgroundColor = Gainsboro
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Gainsboro)
                        .padding(7.dp)
                ) {
                    CreateLinkedInImage(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = titles[2], color = Color.Black, fontWeight = FontWeight.Bold)
                        Text(text = content[2], color = Color.Black, style = MaterialTheme.typography.body2)
                    }

                }
            }
        }
    }


}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            textAlign = TextAlign.Center,
            text = "Hrishikesh Naramparambath",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h4,
            color = Color.Black
        )

        Text(
            text = "GitHub: kingslayer1312",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(3.dp),
            color = IndigoDye
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(15.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.DarkGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Profile Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun CreatePhoneImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(15.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.DarkGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.phoneicon),
            contentDescription = "Phone Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun CreateMailImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(15.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.DarkGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.mailicon),
            contentDescription = "Mail Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
private fun CreateLinkedInImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(15.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.DarkGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.link),
            contentDescription = "Mail Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardViewerTheme {

    }
}

