/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 2/12/2022
 */

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentController
import kotlin.random.Random

class FourInARow
/**
 * clear board and set current player
 */
    : IGame , Fragment() {

    lateinit var navController: FragmentController
    // game board in 2D array initialized to zeros
    private val board = Array(GameConstants.ROWS) { IntArray(GameConstants.COLS){0} }

    override fun clearBoard() {
        //Go through the array setting to 0
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                board[row][col] = 0
            }
        }
    }

    override fun setMove(player: Int, location: Int) {
        //Find the row an column for the location number
        val row = location / board[0].size
        val column = location % board[0].size
        board[row][column] = player
    }

    override val computerMove: Int
        get() =// TODO Auto-generated method stub
//   return a random number
            Random.nextInt(1,35)

    override fun checkForWinner(): Int {
        // Check horizontal and vertical spaces for winner
        var counter0 = 0
        var hCounter1 = 0
        var hCounter2 = 0
        var vCounter1 = 0
        var vCounter2 = 0
        for (row in 0 until GameConstants.ROWS) {
            hCounter1 = 0
            hCounter2 = 0
            for (col in 0 until GameConstants.COLS) {
                if (board[row][col] == 0) {
                    counter0 +=1
                    hCounter1 = 0
                    hCounter2 = 0
                } else if (board[row][col] == 1) {
                    hCounter1 += 1
                    hCounter2 = 0
                    if (hCounter1 >= 4) {
                        return 3
                    }
                } else if (board[row][col] == 2) {
                    hCounter1 = 0
                    hCounter2 += 1
                    if (hCounter2 >= 4) {
                        return 2
                    }
                }
                if (board[col][row] == 0) {
                    vCounter1 = 0
                    vCounter2 = 0
                } else if (board[col][row] == 1) {
                    vCounter1 += 1
                    vCounter2 = 0
                    if (vCounter1 >= 4) {
                        return 3
                    }
                } else if (board[col][row] == 2) {
                    vCounter1 = 0
                    vCounter2 += 1
                    if (vCounter2 >= 4) {
                        return 2
                    }
                }
            }
        }
// Check diagonals for win
        var dCounter1 = 0
        var dCounter2 = 0
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                var i = row
                var j = col
                do{
                    if (board[i][j] == 0){
                        dCounter1 = 0
                        dCounter2 = 0
                    }
                    else if (board[i][j] == 1){
                        dCounter1 += 1
                        dCounter2 = 0
                        if (dCounter1 >= 4){
                            return  3
                        }
                    }
                    else if (board[i][j] == 2){
                        dCounter1 = 0
                        dCounter2 += 1
                        if (dCounter2 >= 4){
                            return  2
                        }
                    }
                    i += 1
                    j += 1
                }
                while (i < GameConstants.ROWS && j < GameConstants.COLS)

            }
        }

        dCounter1 = 0
        dCounter2 = 0
        for (row in 0 until  GameConstants.ROWS) {
            for (col in GameConstants.COLS-1 downTo  0) {
                var i = row
                var j = col
                do{
                    if (board[i][j] == 0){
                        dCounter1 = 0
                        dCounter2 = 0
                    }
                    else if (board[i][j] == 1){
                        dCounter1 += 1
                        dCounter2 = 0
                        if (dCounter1 >= 4){
                            return  3
                        }
                    }
                    else if (board[i][j] == 2){
                        dCounter1 = 0
                        dCounter2 += 1
                        if (dCounter2 >= 4){
                            return  2
                        }
                    }
                    i += 1
                    j -= 1
                }
                while (i < GameConstants.ROWS && j >=0)

            }
        }


        if (counter0 == 0){
            return 1
        }
        return 0
    }

    /**
     * Print the game board
     */
    fun printBoard() {
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                printCell(board[row][col]) // print each of the cells
                if (col != GameConstants.COLS - 1) {
                    print("|") // print vertical partition
                }
            }
            println()
            if (row != GameConstants.ROWS - 1) {
                println("-----------") // print horizontal partition
            }
        }
        println()
    }

    /**
     * Print a cell with the specified "content"
     * @param content either BLUE, RED or EMPTY
     */
    fun printCell(content: Int) {
        when (content) {
            GameConstants.EMPTY -> print("   ")
            GameConstants.BLUE -> print(" B ")
            GameConstants.RED -> print(" R ")
        }
    }
    fun checkBoard(location: Int): Int {
        val row = location / board[0].size
        val column = location % board[0].size
        return board[row][column]
    }
}

