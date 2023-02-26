


val FIR_board = FourInARow()

/** The entry main method (the program starts here)  */
fun main() {
 var currentState: Int = GameConstants.PLAYING
 var userInput = ""
 //game loop
 do {
  FIR_board.printBoard()
  /** TODO implement the game loop
   * 1- accept user move
   * 2- call getComputerMove
   * 3- Check for winner
   * 4- Print game end messages in case of Win , Lose or Tie !
   */
  System.out.println("Please enter a location (0-35) or enter 'q' to quit")
  userInput = readln();
// If user input is not q run through one round of putting spaces on th board and check for a win
  if (userInput != "q") {
   if (FIR_board.checkBoard(userInput.toInt()) == 0) {
    FIR_board.setMove(1, userInput.toInt());
    var computerMove = FIR_board.computerMove
    var done = false
    while (!done){
     if (FIR_board.checkBoard(computerMove) == 0){
      FIR_board.setMove(2, computerMove)
      done = true
     }
     else{
      computerMove = FIR_board.computerMove
     }
    }
   }
   else {
    System.out.println("Invalid space try again")
   }
   currentState = FIR_board.checkForWinner()
   if(currentState == 3) {
    System.out.println("Blue Wins!")
   }
   else if (currentState ==2){
    System.out.println("Red Wins!")
   }
  }



 } while (currentState == GameConstants.PLAYING && userInput != "q")
// repeat if not game-over
 FIR_board.printBoard()
}
 