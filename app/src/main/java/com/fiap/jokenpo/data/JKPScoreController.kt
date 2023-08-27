package com.fiap.jokenpo.data

import com.fiap.jokenpo.R

object JKPScoreController {
    fun winnerController(
        player: String,
        device: String): String
    {
        return when {
            player == device -> "Empate"
            (player == "pedra" && device == "tesoura") ||
                    (player == "papel" && device == "pedra") ||
                    (player == "tesoura" && device == "papel") -> "Você Venceu"
            else -> "Dispositivo Venceu"
        }
    }
}
