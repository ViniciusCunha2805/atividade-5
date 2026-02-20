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
                textoResultado.text = "Por favor, cole um código correto primeiro!"
            }
        }
    }

    private fun desembolar (base64Input: String, campoTexto: TextView){
        try {
            val bytes = android.util.Base64.decode(base64Input, android.util.Base64.DEFAULT)

            val registros = bytes[0].toInt() and 0xFF
            val bateria = bytes[1].toInt() and 0xFF

            val relojoaria01 = ((bytes[2].toInt() and 0xFF) shl 24) or
                    ((bytes[3].toInt() and 0xFF) shl 16) or
                    ((bytes[4].toInt() and 0xFF) shl 8) or
                    (bytes[5].toInt() and 0xFF)

            val resultadoFinal = """
            QT de registro: $registros
            Nível da bateria: $bateria%
            Relojoaria 01: $relojoaria01
            """.trimIndent()

            campoTexto.text = resultadoFinal

        } catch (e: Exception) {
            campoTexto.text = "Erro: Código Base64 inválido!"
        }
    }
}