package com.fiap.jokenpo

import com.fiap.jokenpo.data.JKPScoreController
import org.junit.Assert
import org.junit.Test

class JKPScoreControllerTest {

    @Test
    fun devicePaperWin() {
        val winner = JKPScoreController.winnerController("pedra", "papel")
        Assert.assertEquals("Dispositivo Venceu", winner)
    }

    @Test
    fun deviceRockWin() {
        val winner = JKPScoreController.winnerController("tesoura", "pedra")
        Assert.assertEquals("Dispositivo Venceu", winner)
    }

    @Test
    fun deviceScissorWin() {
        val winner = JKPScoreController.winnerController("papel", "tesoura")
        Assert.assertEquals("Dispositivo Venceu", winner)
    }

    @Test
    fun shouldTie() {
        val winner = JKPScoreController.winnerController("papel", "papel")
        Assert.assertEquals("Empate", winner)
    }

    @Test
    fun playerPaperWin() {
        val winner = JKPScoreController.winnerController("papel", "pedra")
        Assert.assertEquals("Você Venceu", winner)
    }

    @Test
    fun playerRockWin() {
        val winner = JKPScoreController.winnerController("pedra", "tesoura")
        Assert.assertEquals("Você Venceu", winner)
    }

    @Test
    fun playerScissorWin() {
        val winner = JKPScoreController.winnerController("tesoura", "papel")
        Assert.assertEquals("Você Venceu", winner)
    }
}
