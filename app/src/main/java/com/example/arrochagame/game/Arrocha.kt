package com.example.arrochagame.game

class Arrocha (private var numMenor: Int, private var numMaior: Int ) {
    private val numSorteio = (numMenor + 1 until numMaior).random()
    private var gameStatus = GameStatus.EXECUTANDO
    private lateinit var chuteStatus: ChuteStatus

    fun getNumMaior(): Int {
        return this.numMaior
    }

    fun getNumMenor(): Int {
        return this.numMenor
    }

    fun getChuteStatus(): ChuteStatus {
        return this.chuteStatus
    }

    fun getGameStatus(): GameStatus {
        return this.gameStatus
    }

    private fun arrochou(): Boolean {
        return this.numMenor + 1 == this.numMaior - 1
    }

    private fun atualizarIntervalo(chute: Int) {
        if (chute > this.numSorteio) {
            this.numMaior = chute
            this.chuteStatus = ChuteStatus.MAIOR
        } else if (chute < this.numSorteio) {
            this.numMenor = chute
            this.chuteStatus = ChuteStatus.MENOR
        }
    }
    private fun chuteInvalido(chute: Int): Boolean {
        if (chute == this.numSorteio) {
            this.chuteStatus = ChuteStatus.IGUAL
            return true
        }
        return chute <= this.numMenor || chute >= this.numMaior
    }

    fun chutar(chute: Int) {
        if (this.chuteInvalido(chute))
            this.gameStatus = GameStatus.PERDEU
        else {
            this.atualizarIntervalo(chute)
            if (this.arrochou())
                this.gameStatus = GameStatus.GANHOU
        }
    }
}
