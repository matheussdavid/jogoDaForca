package com.example.jogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultadoActivity : AppCompatActivity() {
    private lateinit var tvResultado: TextView
    private lateinit var tvPalavra: TextView
    private lateinit var tvDica: TextView
    private lateinit var tvChances: TextView
    private lateinit var btnJogarNovamente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        this.tvResultado = findViewById(R.id.tvResultado)
        this.tvPalavra = findViewById(R.id.tvPalavra)
        this.tvDica = findViewById(R.id.tvDica)
        this.tvChances = findViewById(R.id.tvChances)

        if(intent.hasExtra("RESULTADO") && intent.hasExtra("PALAVRA") && intent.hasExtra("DICA") && intent.hasExtra("CHANCES")){
            val resultado = intent.getStringExtra("RESULTADO")
            val palavra = intent.getStringExtra("PALAVRA")
            val dica = intent.getStringExtra("DICA")
            val chance = intent.getStringExtra("CHANCES")
            if(resultado.equals("Perdeu")){
                this.tvResultado.text = "Você Perdeu! :("
            }else{
                this.tvResultado.text = "Parabéns!! Você Ganhou! =)"
            }
            this.tvPalavra.text = "Palavra: $palavra"
            this.tvDica.text    = "Dica: $dica"
            this.tvChances.text = "Chances restantes: $chance"

        }



        this.btnJogarNovamente = findViewById(R.id.btJogarNovamente)
        this.btnJogarNovamente.setOnClickListener{voltar()}
    }

    fun voltar(){
//        val intent = Intent().apply {
//            putExtra("JOGO", "Jogo iniciando em 3,2.1...")
//        }
//        setResult(RESULT_OK, intent)
        finish()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}