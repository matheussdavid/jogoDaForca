package com.example.jogodaforca.Jogo

class BancoPalavras {
    private var listaDePalavras = mutableMapOf<String, String>()
    lateinit var palavraSorteada: String

    init {
        this.listaDePalavras = mutableMapOf()
        this.popularLista()
        this.sorteio()
    }

    fun popularLista(){
        this.listaDePalavras.put("Cinema",  "Uma pipoquinha vai bem")
        this.listaDePalavras.put("Futebol", "Somos Hexa")
        this.listaDePalavras.put("Praia",   "Recarregar as energias")
        this.listaDePalavras.put("Salgado", "Alguns acham melhor do que doce")
        this.listaDePalavras.put("Brian",   "Droga, é o ...")
    }

    fun sorteio(){
        this.palavraSorteada = this.listaDePalavras.keys.random()
    }

    fun palavra(): String{
        return this.palavraSorteada
    }

    fun dica(): String{
        return this.listaDePalavras.getValue(palavraSorteada)
    }

}