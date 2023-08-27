package com.fiap.jokenpo

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.fiap.jokenpo.databinding.ActivityJkpGameBinding
import com.fiap.jokenpo.viewmodel.JKPViewModel

class JKPGame : AppCompatActivity() {

    private lateinit var binding: ActivityJkpGameBinding
    private lateinit var viewModel: JKPViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJkpGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[JKPViewModel::class.java]
        setupCL()
        observeVM()
    }

    private fun setupCL() {
        binding.playerPaper.setOnClickListener {
            viewModel.playGame("papel")
        }

        binding.playerRock.setOnClickListener {
            viewModel.playGame("pedra")
        }

        binding.playerScissor.setOnClickListener {
            viewModel.playGame("tesoura")
        }
    }

    private fun observeVM() {
        viewModel.playerScore.observe(this) { score ->
            binding.playerScore.text = score.toString()
        }

        viewModel.deviceScore.observe(this) { score ->
            binding.deviceScore.text = score.toString()
        }

        viewModel.playerChoice.observe(this) { choice ->
            updateChoiceImage(choice, binding.choicePlayer)
        }

        viewModel.deviceChoice.observe(this) { choice ->
            updateChoiceImage(choice, binding.choiceDevice)
        }
    }

    private fun updateChoiceImage(choiceName: String, imageView: ImageView) {
        val resourceID = when (choiceName) {
            "pedra" -> R.drawable.rock
            "tesoura" -> R.drawable.scissor
            "papel" -> R.drawable.paper
            else -> 0
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(this, resourceID))
    }
}
