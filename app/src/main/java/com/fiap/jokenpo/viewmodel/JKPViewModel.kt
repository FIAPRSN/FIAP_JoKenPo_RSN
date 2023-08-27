package com.fiap.jokenpo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fiap.jokenpo.R
import com.fiap.jokenpo.data.JKPChoices
import com.fiap.jokenpo.data.JKPScoreController

class JKPViewModel: ViewModel() {

    private val _playerScore = MutableLiveData<Int>()
    val playerScore: LiveData<Int> = _playerScore

    private val _deviceScore = MutableLiveData<Int>()
    val deviceScore: LiveData<Int> = _deviceScore

    private val _resultText = MutableLiveData<String>()
    val resultText: LiveData<String> = _resultText

    private val _playerChoice = MutableLiveData<String>()
    val playerChoice: LiveData<String> = _playerChoice

    private val _deviceChoice = MutableLiveData<String>()
    val deviceChoice: LiveData<String> = _deviceChoice

    private val choicesJKP = arrayOf(
        JKPChoices("pedra", R.drawable.rock),
        JKPChoices("tesoura", R.drawable.scissor),
        JKPChoices("papel", R.drawable.paper)
    )

    init {
        _playerScore.value = 0
        _deviceScore.value = 0
    }

    fun playGame(playerChoice: String) {
        val deviceChoice = choicesJKP.random()
        _playerChoice.value = playerChoice
        _deviceChoice.value = deviceChoice.name

        val result = JKPScoreController.winnerController(playerChoice, deviceChoice.name)
        updateScoresAndResult(result)
    }

    private fun updateScoresAndResult(result: String) {
        if (result == "Você Venceu") {
            _playerScore.value = (_playerScore.value ?: 0) + 1
        } else if (result == "Dispositivo Venceu") {
            _deviceScore.value = (_deviceScore.value ?: 0) + 1
        }
        _resultText.value = result
    }
}
