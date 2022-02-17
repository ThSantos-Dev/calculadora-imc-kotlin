package com.example.calculadoraimc

import android.graphics.Color

// Calcula Imc
fun calculaImc(altura: Double, peso: Double): Double {
    return peso / (altura * altura)
}

// Situacao do usuario
fun situacaoUsuario(imc: Double): String {
    var situacao = ""

    /* Definindo a situação do usuário */
    when{
        imc <= 16 -> situacao = " e você está muito abaixo do peso."
        imc < 18.5 ->  situacao = " e você está abaixo do peso."
        imc <= 25 -> {
            situacao = " e você está com o peso ideal."

        }
        imc <= 30 -> {
            situacao = " e você está levemente acima do peso."

        }
        imc <= 35 -> situacao = " e você está acima do peso (Obsidade Grau I)."
        imc <= 40 -> situacao = " e você está acima do peso (Obsidade Grau II)."
        imc > 40 -> situacao = " e você está acima do peso (Obsidade Grau III)."
    }

    return situacao
}