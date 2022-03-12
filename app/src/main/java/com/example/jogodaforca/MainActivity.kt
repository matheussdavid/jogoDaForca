package com.example.jogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.jogodaforca.Jogo.BancoPalavras
import com.example.jogodaforca.Jogo.Jogo

class MainActivity : AppCompatActivity() {
    private lateinit var tvPalavra: TextView
    private lateinit var tvDica: TextView
    private lateinit var banco: BancoPalavras
    private lateinit var jogo: Jogo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.banco = BancoPalavras()
        this.jogo  = Jogo(this.banco.palavra(), this.banco.dica())

        this.tvPalavra = findViewById(R.id.tvPalavra)
        this.tvPalavra.text = this.jogo.getPalavraEscondida().toString()

        this.tvDica = findViewById(R.id.tvDica)
        this.tvDica.text = this.jogo.getDica()
    }
}