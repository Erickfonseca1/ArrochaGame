package com.example.arrochagame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.arrochagame.game.Arrocha

class MainActivity : AppCompatActivity() {
    private lateinit var tvMenor: TextView
    private lateinit var tvMaior: TextView
    private lateinit var etInput: EditText
    private lateinit var btChute: Button
    private lateinit var btReset: Button
    private lateinit var tvStatus: TextView
    private lateinit var arrocha: Arrocha

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.arrocha = Arrocha(0,100)
        this.tvMaior = findViewById(R.id.tvMaior)
        this.tvMenor = findViewById(R.id.tvMenor)
        this.etInput = findViewById(R.id.etInput)
        this.btChute = findViewById(R.id.btChute)
        this.btReset = findViewById(R.id.btReset)
        this.tvStatus = findViewById(R.id.tvStatus)

        this.btReset.setOnClickListener {
            this.reset()
        }

        this.btChute.setOnClickListener {
            this.chutar()
        }
    }

    private fun atualizarTela() {
        this.etInput.setText("")
        this.tvStatus.text = this.arrocha.getGameStatus().toString()
        this.tvMaior.text = this.arrocha.getNumMaior().toString()
        this.tvMenor.text = this.arrocha.getNumMenor().toString()
    }

    private fun reset() {
        this.arrocha = Arrocha(0, 100)
        this.atualizarTela()
    }

    private fun chutar() {
        val chute = this.etInput.text.toString()

        if(chute != "") {
            this.arrocha.chutar(Integer.parseInt(chute))
        }

        this.atualizarTela()
        Toast.makeText(this, this.arrocha.getChuteStatus().toString(),Toast.LENGTH_SHORT).show()

    }
}