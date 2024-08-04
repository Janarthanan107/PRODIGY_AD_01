package com.example.calculator

import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            i()
        }
    }
}

@Composable
fun i(){
    var result by remember{ mutableStateOf(0) }
    var input by remember{ mutableStateOf("") }
    Column( ) {
        Text(text="Basic calculator", fontSize = 40.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(start=60.dp))
        Column {
            Text(text = "$result", fontSize = 40.sp,modifier = Modifier.padding(start = 60.dp, top = 20.dp, bottom = 40.dp))
            TextField(value = input, onValueChange ={ i -> input=i}, modifier = Modifier.padding(start=60.dp).clip(
            RoundedCornerShape(20.dp)), keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),)


            Row(modifier = Modifier.padding(top=40.dp, start = 40.dp)){
                Button(onClick = {if(input==""||input.contains(".")){}
                   else{ result=result+input.toInt()
                                    input=""}

                                 }, colors = ButtonDefaults.buttonColors(Color.DarkGray), modifier = Modifier.padding(end=20.dp).width(40.dp)) {
                    Text(text = "+", color = Color.White, fontSize = 20.sp)
                }
                Button(onClick = {if(input==""||input.contains(".")){}
                else{ result=result-input.toInt()
                    input=""}

                }, colors = ButtonDefaults.buttonColors(Color.DarkGray), modifier = Modifier.padding(end=20.dp).width(40.dp)) {
                    Text(text = "-", color = Color.White,fontSize = 20.sp)
                }
                Button(onClick = {if(input==""||input.contains(".")){}
                else{ result=result/input.toInt()
                    input=""}

                }, colors = ButtonDefaults.buttonColors(Color.DarkGray), modifier = Modifier.padding(end=20.dp).width(40.dp)) {
                    Text(text = "/", color = Color.White,fontSize = 20.sp)
                }
                Button(onClick = {if(input==""||input.contains(".")){}
                else{ result=result*input.toInt()
                    input=""}

                }, colors = ButtonDefaults.buttonColors(Color.DarkGray), modifier = Modifier.padding(end=20.dp).width(40.dp)) {
                    Text(text = "*", color = Color.White,fontSize = 20.sp)
                }
                Button(onClick = { result=0
                    input="" }, colors = ButtonDefaults.buttonColors(Color.DarkGray), modifier = Modifier.padding(end=20.dp).width(80.dp)) {
                    Text(text = "Reset", color = Color.White)
                }
            }
        }
    }

}




