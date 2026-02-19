package com.example.atividade_5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.atividade_5.ui.theme.Atividade5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entradaBase64 = findViewById<EditText>(R.id.editBase64)
        val botaoDesembolar = findViewById<Button>(R.id.btnDesembolar)
        val textoResultado = findViewById<TextView>(R.id.txtResultado)

        botaoDesembolar.setOnClickListener {
            val codigo = entradaBase64.text.toString()

            if (codigo.isNotEmpty()) {
                desembolar(codigo, textoResultado)
            } else {
                textoResultado.text = "Por favor, cole um código primeiro!"
            }
        }
    }
}