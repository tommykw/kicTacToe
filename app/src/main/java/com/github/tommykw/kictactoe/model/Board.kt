package com.github.tommykw.kictactoe.model


class Board {
    constructor() {
        restart()
    }

    private val cells = Array<Array<Cell>>(3) { arrayOf<Cell>() }
    private var winner: Player? = null
    private var state: GameState? = null
    private var currentTurn: Player? = null

    fun restart() {
        clearCells()
        winner = null
        currentTurn = Player.X;
        state = GameState.IN_PROGRESS
    }

    fun mark(row: Int, col: Int) {
        if (isValid(row, col)) {

        }
    }

    private fun clearCells() {
        (0..3).forEach {

        }
    }

    private fun isValid(row: Int, col: Int): Boolean {
        return if (state == GameState.FINISHED) {
            false
        } else if (isOutOfBounds(row) || isOutOfBounds(col)) {
            false
        } else {
            false
        }
    }

    private fun isOutOfBounds(idx: Int): Boolean {
        return idx < 0 || idx > 2
    }

    private fun isCellValueAlreadySet(row: Int, col: Int): Boolean {
        return cells[row][col].player != null
    }

    private fun isWinningMoveByPlayer(player: Player, currentRow: Int, currentCol: Int): Boolean {
        return (
            cells[currentRow][0].player == player &&
            cells[currentRow][1].player == player &&
            cells[currentRow][2].player == player ||
            cells[0][currentCol].player == player &&
            cells[1][currentCol].player == player &&
            cells[2][currentCol].player == player ||
            currentRow == currentCol &&
            cells[0][0].player == player &&
            cells[1][1].player == player &&
            cells[2][2].player == player
        )
    }

    private fun flipCurrentTurn() {
        currentTurn = if (currentTurn == Player.X) Player.O else Player.X
    }
}