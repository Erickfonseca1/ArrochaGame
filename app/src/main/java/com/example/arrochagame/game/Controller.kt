package com.example.arrochagame.game

class Controller ( var numMenor: Int, var numMaior: Int ) {
    var numSorteio: Int
    var status: Status

    init {
        this.numSorteio = ((this.numMenor + 1)..(this.numMaior - 1)).random()
        this.status = Status.EXECUTANDO
    }

    fun arrochado(): Boolean {
        return this.numMenor + 1 == this.numMaior - 1
    }

    fun updateRange(chute: Int): Int {
        if (chute < this.numSorteio && chute > this.numMenor) {
            this.numMenor = chute
            return -1
        } else if (chute > this.numSorteio && chute < this.numMaior) {
            this.numMaior = chute
            return 1
        } else {
            this.status = Status.PERDEU
            return 0
        }
    }

    fun playArrochaGame(chute: Int): Int {
        var value = this.updateRange(chute)
        if (this.arrochado()) {
            this.status = Status.GANHOU
        }
        return value
    }
}
