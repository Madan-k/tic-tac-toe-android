package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var board = Array(3) { IntArray(3) }
    var currentPlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = android.widget.GridLayout(this)
        layout.rowCount = 3
        layout.columnCount = 3

        for (i in 0..2) {
            for (j in 0..2) {
                val btn = Button(this)
                btn.textSize = 24f
                btn.setOnClickListener {
                    if (board[i][j] == 0) {
                        board[i][j] = currentPlayer
                        btn.text = if (currentPlayer == 1) "X" else "O"

                        if (checkWinner()) {
                            btn.text = "WIN"
                        } else {
                            currentPlayer = if (currentPlayer == 1) 2 else 1
                        }
                    }
                }
                layout.addView(btn)
            }
        }

        setContentView(layout)
    }

    fun checkWinner(): Boolean {
        for (i in 0..2) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0)
                return true

            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0)
                return true
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0)
            return true

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0)
            return true

        return false
    }
}
