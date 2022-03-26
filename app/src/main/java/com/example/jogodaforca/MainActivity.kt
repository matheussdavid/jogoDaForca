package com.example.jogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.jogodaforca.Jogo.BancoPalavras
import com.example.jogodaforca.Jogo.Jogo

class MainActivity : AppCompatActivity() {
    private lateinit var tvPalavra: TextView
    private lateinit var tvDica: TextView
    private lateinit var banco: BancoPalavras
    private lateinit var jogo: Jogo
    private lateinit var etLetra :EditText
    private lateinit var btJogar: Button
    private lateinit var tvLetras: TextView
    private lateinit var tvChances : TextView
    private lateinit var tvStatus : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.banco = BancoPalavras()
        this.jogo  = Jogo(this.banco.palavra(), this.banco.dica())
        this.etLetra = findViewById(R.id.etLetra)
        this.btJogar = findViewById(R.id.btJogar)

        this.tvPalavra = findViewById(R.id.tvPalavra)
        this.tvPalavra.text = this.jogo.getPalavraEscondida().toString()

        this.tvDica = findViewById(R.id.tvDica)
        this.tvDica.text = this.jogo.getDica()

        this.tvLetras = findViewById(R.id.tvLetras)

        this.tvChances = findViewById(R.id.tvChances)
        this.tvChances.text = this.jogo.getChances().toString()

        this.tvStatus = findViewById(R.id.tvStatus)
        this.tvStatus.text = this.jogo.getStatus()

        this.btJogar.setOnClickListener(ClickBotao())
    }

    // TODO: Arrumar uma maneira de converter a letra informada via teclado para minúscula - OK
    // TODO: exibir as letras que já foram utilizadas pelo jogador - OK
    //       Impedir que o usuário tente utilizar letras repetidas - OK
    //       inferormar caso a letra já tenha sido utilizada - OK
    //       Decrementar o número de chances do jogador em caso de erro - OK
    //       depois de informar uma letra, limpar o editText - OK
    // TODO: Controlar o número de erros para poder atualizar as imagens e encerrar o jogo se for o caso - OK
    // TODO: Uma maneira de finalizar o jogo
    inner class ClickBotao: View.OnClickListener{
        override fun onClick(p0: View?) {
            val letra = this@MainActivity.etLetra.text.toString().lowercase()
            if(letra.length == 1){
                if(!this@MainActivity.jogo.getLetrasUsadas().contains(letra)){
                    if(!this@MainActivity.jogo.jogar(letra.toString())){
                        Toast.makeText(this@MainActivity,"Letra errada, ${this@MainActivity.jogo.getChances()} chances restantes.",Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this@MainActivity,"Letra já utilizada, tente outra.",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@MainActivity,"Informar apenas 1 letra.",Toast.LENGTH_SHORT).show()
            }
            checaStatus()
            atualizaTela()
        }
    }

    private fun atualizaTela() {
        this@MainActivity.etLetra.setText("")
        this@MainActivity.tvPalavra.text = this@MainActivity.jogo.getPalavraEscondida().toString()
        this@MainActivity.tvLetras.text  = this@MainActivity.jogo.getLetrasUsadas().toString()
        this@MainActivity.tvChances.text = this@MainActivity.jogo.getChances().toString()
        this@MainActivity.tvStatus.text  = this@MainActivity.jogo.getStatus()
    }

    private fun checaStatus() {
        this@MainActivity.jogo.ganhou()
        this@MainActivity.jogo.checaStatus()
    }
}
