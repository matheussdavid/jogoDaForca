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

    init {
        this.chances = 6
        this.tentativas = 0
        this.statusJogo = true
        this.ganhar = false
        this.palavra = palavra
        this.dica = dica
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
        if(this.palavra.equals(this.palavraEscondida)){
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

   /* fun jogar(){
        var letra: String
        while(this.statusJogo == true){
            this.ganhou()
            if(this.chances >=1 && this.ganhar == false ){
                println("--------------------------------\n")
                println("${this.chances}/6 chances disponíveis")
                println("PALAVRA: ${this.palavraEscondida}")
                println("DICA: $dica")
                print("Informe a letra a ser procurada: ")
                letra = readLine().toString().lowercase()
                if(this.palavra.contains(letra) && !this.letrasUsadas.contains(letra)){
                    this.buscaLetra(letra)
                    this.letrasUsadas.add(letra)
                }
                else if(this.letrasUsadas.contains(letra)){
                    println("A letra: $letra já foi utilizada, tente com outra!!!")
                    println("Letras utilizadas: ${this.letrasUsadas}")
                }
                else{
                    println("Letra incorreta, tente novamente")
                    this.letrasUsadas.add(letra)
                    println("Letras utilizadas: ${this.letrasUsadas}")
                    this.chances--
                }
            }
            else{
                if(this.ganhar){
                    println("\n\n!!! VENCEDOR !!!")
                    println("Parabéns, você acertou a palavra $this.palavra! e te restavam ${this.chances} chances")
                    break
                }else{
                    println("--------------------------------\n")
                    this.statusJogo = false
                    println("Você estourou o número de tentativas, Fim de Jogo!")
                }
            }
        }
    }̣*/
}