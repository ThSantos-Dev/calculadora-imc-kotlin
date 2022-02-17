package com.example.calculadoraimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// Declaração de variáveis antes da criação da view
lateinit var alturaEditText: EditText
lateinit var  pesoEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Resgatando os botões */
        val calcular = findViewById<Button>(R.id.btnCalcular)
        val sair = findViewById<Button>(R.id.btnSair)

        calcular.setOnClickListener {
            /* Resgatando valores e TextView da View */
            alturaEditText = findViewById(R.id.altura)
            pesoEditText = findViewById(R.id.peso)
            val tituloSituacao = findViewById<TextView>(R.id.tituloSituacao)
            val containerSituacao = findViewById<TextView>(R.id.containerSituacao)
            val alerta = findViewById<TextView>(R.id.alerta)
            var situacao = " "

            if(validaCampos()){
                val altura = alturaEditText.text.toString().toDouble()
                val peso = pesoEditText.text.toString().toDouble()

                val imc = calculaImc(altura, peso)
                val situacao = situacaoUsuario(imc)

                if(imc > 18.5 && imc <= 25){
                    alerta.setTextColor(Color.GREEN)
                    alerta.text = "Parabéns!"
                }

                if(imc > 25 && imc <= 30){
                    alerta.setTextColor(Color.RED)
                    alerta.text = "Cuidado!"
                }

                tituloSituacao.text = "Situação: "
                containerSituacao.text = "O seu IMC é de: ${imc} ${situacao}"
            }
        }

        sair.setOnClickListener {
            finish()
        }

    }

    private fun validaCampos(): Boolean {
        var noError = true
        if(alturaEditText.text.isBlank()) {
            alturaEditText.setError("Digite a altura!")
            noError = false
        }
        if(pesoEditText.text.isBlank()){
            pesoEditText.setError("Digite seu peso!")
            noError = false
        }
        return noError
    }
}