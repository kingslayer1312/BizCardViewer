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

    val buttonClickedState = remember {
        mutableStateOf(false)
    }


    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = SpaceCadet

    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(5.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = SpaceCadet,
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

                Button(onClick = {
                        buttonClickedState.value = !buttonClickedState.value

                    }) {
                    Text(text = "PORTFOLIO",
                        style = MaterialTheme.typography.button)

                }
                if (buttonClickedState.value) {
                    Content()
                }
                else {
                    Box() {

                    }
                }

            }
        }
    }
}

@Composable
fun Content() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
            

        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(modifier = Modifier.background(BlizzardBlue)) {
        items(data) { item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp,
                backgroundColor = BlizzardBlue) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(BlizzardBlue)
                    .padding(7.dp)
                    ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "The first project", style = MaterialTheme.typography.body2)
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
            color = ChampagnePink
        )

        Text(
            text = "Sophomore at VIT Chennai",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1,
            color = Color.White
        )

        Text(
            text = "GitHub: kingslayer1312",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(3.dp),
            color = Color.White
        )

        Text(
            text = "Linkedin: Hrishikesh Naramparambath",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(3.dp),
            color = Color.White
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
        border = BorderStroke(0.5.dp, Color.LightGray),
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

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardViewerTheme {

    }
}