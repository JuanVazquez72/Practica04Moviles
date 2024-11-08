package com.example.practica04.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.colorTextSecondary
import com.example.compose.onPrimaryLight
import com.example.compose.primaryLight
import com.example.practica04.R
import com.example.practica04.navigation.Home

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PresentacionView(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryLight,
                    titleContentColor = primaryLight
                ),
                title = {
                    Text(
                        text = "Presentación",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = onPrimaryLight
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Home)
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )

                    }
                },
            )
        },
        content = { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .background(primaryLight)
                    .padding(paddingValues)
            ) {
                // Imagen de presentación
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "Juan Luis Vazquez",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(top = 30.dp)
                        .graphicsLayer(rotationZ = 0f),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center
                )

                // Texto de presentación
                Text(
                    text = "Vazquez German Juan Luis \n\nSoporte Técnico",
                    fontSize = 20.sp,  // Ajustado para hacer el texto más pequeño
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = onPrimaryLight,
                    modifier = Modifier.padding(top = 30.dp)
                )

                Spacer(modifier = Modifier.height(70.dp))

                // Filas de contacto
                ContactRow(iconId = R.drawable.llamada, text = "+52 662 106 1284")
                ContactRow(iconId = R.drawable.linkedin, text = "vazquezgermanjuanluis72")
                ContactRow(iconId = R.drawable.mail, text = "a22022308@unison.mx")
            }
        }
    )
}

@Composable
fun ContactRow(iconId: Int, text: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 18.sp, color = colorTextSecondary)
    }
}
