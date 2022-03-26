package com.example.jogodaforca.Jogo

class Jogo(palavra: String, dica: String){
    private var chances: Int
    private var tentativas: Int
    private var statusJogo: Boolean
    private var ganhar: Boolean
    private var palavraEscondida=  arrayListOf<String>()
    private var letrasUsadas = mutableListOf<String>()
    private val palavra: String
    private val dica: String
    private var status: String

    init {
        this.chances = 6
        this.tentativas = 0
        this.statusJogo = true
        this.ganhar = false
        this.palavra = palavra
        this.dica = dica
        this.status = "Jogo Iniciado"
        this.esconderletras()

    }

    fun tamanhoPalavra(): Int{
        return this.palavra.length
    }

    fun letrasDistintas(): String{
        var letrasDist = this.palavra.lowercase().chars().distinct().count().toString()
        return "A palavra possui $letrasDist letras distintas"

    }

    fun buscaLetra(letra: String){
        for((i, item) in this.palavra.withIndex()){
            if(letra == this.palavra[i].toString()){
                this.palavraEscondida[i] = letra
            }
        }
    }

    fun ganhou(){
        var palavraEcondida = this.palavraEscondida.joinToString("")
        if(this.palavra.equals(palavraEcondida)){
            this.ganhar = true
        }
    }

    fun esconderletras(){
        for(letra in this.palavra){
            this.palavraEscondida.add("*")
        }
    }

    fun getPalavraEscondida(): ArrayList<String> {
        return this.palavraEscondida
    }

    fun getDica(): String{
        return this.dica
    }

    fun getPalavra(): String {
        return this.palavra
    }

    fun getLetrasUsadas(): MutableList<String> {
        return this.letrasUsadas
    }

    fun getChances(): Int {
        return this.chances
    }

    fun checaStatus(){
        if(this.chances == 0){
            this.status = "Perdeu"
        }
        if(this.ganhar){
            this.status = "Ganhou"
        }
    }

    fun getStatus(): String {
        return this.status
    }

    fun jogar(letra: String): Boolean{
        var sucesso = true
        if(this.chances >=1 && this.ganhar == false ){
            if(this.palavra.contains(letra) && !this.letrasUsadas.contains(letra)){
                this.buscaLetra(letra)
                this.letrasUsadas.add(letra)
                sucesso = true
            }
            else{
                this.letrasUsadas.add(letra)
                this.chances--
                sucesso =  false
            }
        }
        else{
            if(this.ganhar){
                println("\n\n!!! VENCEDOR !!!")
                println("Parabéns, você acertou a palavra $this.palavra! e te restavam ${this.chances} chances")
            }else{
                println("--------------------------------\n")
                this.statusJogo = false
                println("Você estourou o número de tentativas, Fim de Jogo!")
            }
        }
        return sucesso
    }
}