package com.example.lab2_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edName: EditText = findViewById(R.id.edName)
        val text: TextView = findViewById(R.id.text)
        val textname:TextView = findViewById(R.id.textname)
        val textwin:TextView = findViewById(R.id.textwin)
        val textView8:TextView = findViewById(R.id.textView8)
        val textView9:TextView = findViewById(R.id.textView9)
        val radioButton: RadioButton = findViewById(R.id.radioButton)
        val radioButton2:RadioButton = findViewById(R.id.radioButton2)
        val radioButton3:RadioButton = findViewById(R.id.radioButton3)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            if (edName.length()<1)
                text.text = "請輸入玩家姓名"
            else{
                textname.text = String.format("名字\n%s",edName.text.toString())

                if(radioButton.isChecked)
                    textView8.text = "我方出拳\n剪刀"
                else if(radioButton2.isChecked)
                    textView8.text = "我方出拳\n石頭"
                else
                    textView8.text = "我方出拳\n布"

                val computer : Int = Random.nextInt(0,2)


                when(computer){
                    0 -> textView9.text = "電腦出拳\n剪刀"
                    1 -> textView9.text = "電腦出拳\n石頭"
                    2 -> textView9.text = "電腦出拳\n布"
                }

                if((radioButton.isChecked && computer == 2)||
                    (radioButton2.isChecked && computer == 0)||
                    (radioButton3.isChecked && computer == 1)){
                    textwin.text = "勝利者\n" + edName.text.toString()
                    text.text = "恭喜你獲勝了!!!"
                }
                else if((radioButton.isChecked && computer == 1)||
                    (radioButton2.isChecked && computer == 2)||
                    (radioButton3.isChecked && computer == 0)){
                    textwin.text = "勝利者\n電腦"
                    text.text = "可惜，電腦獲勝了!"
                }
                else{
                    textwin.text = "勝利者\n平手"
                    text.text = "平局，請再試一次"
                }
            }


        }




    }
}