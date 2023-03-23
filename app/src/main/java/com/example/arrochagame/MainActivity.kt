package com.example.arrochagame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.arrochagame.game.Controller
import com.example.arrochagame.game.Status

class MainActivity : AppCompatActivity() {
    private lateinit var tvMenor: TextView
    private lateinit var tvMaior: TextView
    private lateinit var etInput: EditText
    private lateinit var btChute: Button
    private lateinit var btReset: Button
    private lateinit var tvStatus: TextView
    private lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.controller = Controller(1,100)

        this.tvMaior = findViewById(R.id.tvMaior)
        this.tvMenor = findViewById(R.id.tvMenor)
        this.etInput = findViewById(R.id.etInput)
        this.btChute = findViewById(R.id.btChute)
        this.btReset = findViewById(R.id.btReset)
        this.tvStatus = findViewById(R.id.tvStatus)
        this.f5()

        this.btReset.setOnClickListener {
            this.controller = Controller(1,100)
            f5()
            Toast.makeText(this, "new game!", Toast.LENGTH_SHORT).show()
        }

        this.btChute.setOnClickListener(ButtonClick())
    }

    fun f5() {
        this.tvMenor.text = this.controller.numMenor.toString()
        this.tvMaior.text = this.controller.numMaior.toString()
        this.tvStatus.text = this.controller.status.toString()
        this.etInput.text.clear()
    }

    inner class ButtonClick: View.OnClickListener {
        override fun onClick(p0: View?) {
            var value = this@MainActivity.etInput.text.toString().toInt()
            var response = this@MainActivity.controller.playArrochaGame(value)

            if (response > 0) {
                Toast.makeText(this@MainActivity, "Seu chute é Maior!", Toast.LENGTH_SHORT).show()
                f5()
            }

            if ( response < 0) {
                Toast.makeText(this@MainActivity, "Seu chute é Menor!", Toast.LENGTH_SHORT).show()
                f5()
            }
        }
    }


}