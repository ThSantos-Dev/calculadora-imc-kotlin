package com.example.calculadoraimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Resgatando os botões */
        val calcular = findViewById<Button>(R.id.btnCalcular)
        val sair = findViewById<Button>(R.id.btnSair)

        calcular.setOnClickListener {
            /* Resgatando valores e TextView da View */
            val altura = findViewById<EditText>(R.id.altura).text.toString().toDouble()
            val peso = findViewById<EditText>(R.id.peso).text.toString().toDouble()
            val tituloSituacao = findViewById<TextView>(R.id.tituloSituacao)
            val containerSituacao = findViewById<TextView>(R.id.containerSituacao)
            val alerta = findViewById<TextView>(R.id.alerta)
            var situacao = " "

            val imc = peso / (altura * altura)

            tituloSituacao.text = "Situação: "

            /* Definindo a situação do usuário */
            when{
                imc <= 16 -> situacao = " e você está muito abaixo do peso."
                imc < 18.5 ->  situacao = " e você está abaixo do peso."
                imc <= 25 -> {
                    situacao = " e você está com o peso ideal."
                    alerta.setTextColor(Color.GREEN)
                    alerta.text = "Parabéns!"
                }
                imc <= 30 -> {
                    situacao = " e você está levemente acima do peso."
                    alerta.setTextColor(Color.RED)
                    alerta.text = "Cuidado!"
                }
                imc <= 35 -> situacao = " e você está acima do peso (Obsidade Grau I)."
                imc <= 40 -> situacao = " e você está acima do peso (Obsidade Grau II)."
                imc > 40 -> situacao = " e você está acima do peso (Obsidade Grau III)."
            }

            containerSituacao.text = "O seu IMC é de: ${imc} ${situacao}"
        }

        sair.setOnClickListener {
            finish()
        }

    }
}