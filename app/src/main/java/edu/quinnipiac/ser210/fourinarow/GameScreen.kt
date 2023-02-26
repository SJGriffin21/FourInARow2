package edu.quinnipiac.ser210.fourinarow

import FourInARow
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs

class GameScreen : Fragment(), View.OnClickListener {

    val FIR_board = FourInARow()
    lateinit var textView: TextView
    lateinit var buttonArray: ArrayList<Button>
    lateinit var playerName: String
    val args: GameScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_screen, container, false)
        playerName = args.playerName.toString()
        textView = view.findViewById<TextView>(R.id.messageDisplay)
        buttonArray = ArrayList<Button>()
        buttonArray.add(view.findViewById<Button>(R.id.button01))
        buttonArray.add(view.findViewById<Button>(R.id.button02))
        buttonArray.add(view.findViewById<Button>(R.id.button03))
        buttonArray.add(view.findViewById<Button>(R.id.button04))
        buttonArray.add(view.findViewById<Button>(R.id.button05))
        buttonArray.add(view.findViewById<Button>(R.id.button06))
        buttonArray.add(view.findViewById<Button>(R.id.button07))
        buttonArray.add(view.findViewById<Button>(R.id.button08))
        buttonArray.add(view.findViewById<Button>(R.id.button09))
        buttonArray.add(view.findViewById<Button>(R.id.button10))
        buttonArray.add(view.findViewById<Button>(R.id.button11))
        buttonArray.add(view.findViewById<Button>(R.id.button12))
        buttonArray.add(view.findViewById<Button>(R.id.button13))
        buttonArray.add(view.findViewById<Button>(R.id.button14))
        buttonArray.add(view.findViewById<Button>(R.id.button15))
        buttonArray.add(view.findViewById<Button>(R.id.button16))
        buttonArray.add(view.findViewById<Button>(R.id.button17))
        buttonArray.add(view.findViewById<Button>(R.id.button18))
        buttonArray.add(view.findViewById<Button>(R.id.button19))
        buttonArray.add(view.findViewById<Button>(R.id.button20))
        buttonArray.add(view.findViewById<Button>(R.id.button21))
        buttonArray.add(view.findViewById<Button>(R.id.button22))
        buttonArray.add(view.findViewById<Button>(R.id.button23))
        buttonArray.add(view.findViewById<Button>(R.id.button24))
        buttonArray.add(view.findViewById<Button>(R.id.button25))
        buttonArray.add(view.findViewById<Button>(R.id.button26))
        buttonArray.add(view.findViewById<Button>(R.id.button27))
        buttonArray.add(view.findViewById<Button>(R.id.button28))
        buttonArray.add(view.findViewById<Button>(R.id.button29))
        buttonArray.add(view.findViewById<Button>(R.id.button30))
        buttonArray.add(view.findViewById<Button>(R.id.button31))
        buttonArray.add(view.findViewById<Button>(R.id.button32))
        buttonArray.add(view.findViewById<Button>(R.id.button33))
        buttonArray.add(view.findViewById<Button>(R.id.button34))
        buttonArray.add(view.findViewById<Button>(R.id.button35))
        buttonArray.add(view.findViewById<Button>(R.id.button36))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var i = 0
        while (i <= 35){
            val tempButton = buttonArray[i]
            tempButton.setBackgroundColor(Color.DKGRAY)
            tempButton.setOnClickListener(this)
            i++
        }
        view.findViewById<Button>(R.id.ResetButton).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ResetButton -> {
                FIR_board.clearBoard()
                textView.text = "Please Choose a tile"
                var i = 0
                while (i <= 35){
                    buttonArray[i].setBackgroundColor(Color.DKGRAY)
                    buttonArray[i].isEnabled = true
                    buttonArray[i].isClickable = true
                    i++
                }
            }
            else -> {
                val location = v.id.toString().takeLast(2).toInt()-21
                if (FIR_board.checkBoard(location) == 0) {
                    FIR_board.setMove(1, location)
                    v.setBackgroundColor(Color.BLUE)
                    v.isEnabled = false
                    v.isClickable = false

                    var computerMove = FIR_board.computerMove
                    var done = false
                    while (!done) {
                        if (FIR_board.checkBoard(computerMove) == 0) {
                            FIR_board.setMove(2, computerMove)
                            buttonArray[computerMove].setBackgroundColor(Color.RED)
                            buttonArray[computerMove].isEnabled = false
                            buttonArray[computerMove].isClickable = false
                            done = true
                        } else {
                            computerMove = FIR_board.computerMove
                        }
                    }
                    val currentState = FIR_board.checkForWinner()
                    if(currentState == 3) {
                        textView.text ="$playerName Wins!"
                    }
                    else if (currentState ==2){
                        textView.text ="Red Wins!"
                    }
                    if (currentState == 3 || currentState == 2){
                        var i = 0
                        while (i <= 35){
                            buttonArray[i].isEnabled = false
                            buttonArray[i].isClickable = false
                            i++
                        }
                    }
                }
            }
        }
    }
}