package com.example.myprimerproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myprimerproyecto.IMCCalculator.IMCActivity
import com.example.myprimerproyecto.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        btnSaludar.setOnClickListener { navigateToSaludar() }
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        btnIMC.setOnClickListener { navigateToIMC() }
    }

    private fun navigateToIMC() {
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludar() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}