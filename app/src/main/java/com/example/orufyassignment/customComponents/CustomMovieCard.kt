package com.example.orufyassignment.customComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@Composable
fun CustomMovieCard(title: String, description: String, imageLink: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(color = Color.White), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w500/$imageLink",),
            contentDescription = "Movie Poster",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(15.dp))

        Column {
            CustomTextComposable(
                text = title, textColor = Color.Black,
                textStyle =   TextStyle(fontWeight = FontWeight.W600, fontSize = 20.sp),
                maxLine = 1,
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextComposable(
                text = description, textColor = Color.Gray,
                textStyle =  TextStyle(fontWeight = FontWeight.W400, fontSize = 16.sp),
                maxLine = 2,
            )


        }
    }


}