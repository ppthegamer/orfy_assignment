package com.example.orufyassignment.customComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun CustomTextComposable (text:String,maxLine:Int,textColor: Color,textStyle:TextStyle){
    Text(
        text = text, color = textColor,
        style = textStyle,
        maxLines = maxLine,
        overflow = TextOverflow.Ellipsis
    )
}