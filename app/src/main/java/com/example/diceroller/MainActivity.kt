package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
                }
            }
        }
    }

@Preview
@Composable
fun DiceRollerApp(){
    /* fillMaxSize() al objeto Modifier para que el diseño ocupe toda la pantalla.
    El método wrapContentSize() especifica que el espacio disponible
    debe ser al menos tan grande como los componentes que contiene.
    se puede pasar un objeto Alignment al método wrapContentSize() que
    especifica el modo en que se deben alinear los componentes dentro del espacio disponible.*/
     DiceWithButtonAndImage(modifier = Modifier
         .fillMaxSize()
         .wrapContentSize(Alignment.Center))
}


@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
        /* Column() es un diseño componible
        que ubica sus elementos secundarios en una secuencia vertical

        var result by remember { mutableStateOf(1)  }

        val imageResource=when(result){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }*/
         var result by remember { mutableStateOf(1)  }
         var result2 by remember { mutableStateOf(1)  }
         Column (
             modifier=modifier,
             horizontalAlignment=Alignment.CenterHorizontally
         ){
             result= getRandomDiceImage(result)
             result2=getRandomDiceImage(result2)
             /*Image(
                 painter = painterResource(id= imageResource),
                 contentDescription =result.toString())*/
             Spacer(modifier = Modifier.height(16.dp))
             Button(onClick = {
                 result = (1..6).random()
                 result2 = (1..6).random() })
             {
                 Text(text = stringResource(R.string.roll))
             }
         }
}

@Composable
private fun getRandomDiceImage(result: Int):Int{

    val imageResource=when(result){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }
        Image(
        painter = painterResource(id= imageResource),
        contentDescription =result.toString())
        return result
}