/** TicTacToeModel models the logic of moving the mark on the board, checking for win and 
    looking the spot where the user wants to put the mark if it is free.*/
import javax.swing.*;
public class TicTacToeModel{

   final private char[][] board;
   private int playersTurn; 
   private boolean gameWon;
   
   
   public TicTacToeModel(){
   
      board = new char[3][3];
      
      for(int i=0; i<3;i++){
         for(int j=0; j<3; j++){
            board[i][j]=' ';
         }
      }
      playersTurn = 0;
      gameWon = false;
   }
   
   public int getPlayersTurn()
   { return playersTurn; }
   
   public boolean getGameIsWon()
   { return gameWon; }
   
     
   public boolean makeMove(int row, int col){
      
      boolean result = false;
      if(validateMove(row,col)){
         if(playersTurn % 2 == 0)
            {board[row][col] = 'X';}
         else{board[row][col] = 'O';}
         playersTurn++;
         result = true;
      }
      return result;
   }

   public void checkForWin(){
      if(playersTurn >=5){
         for(int i=0; i<board.length; i++){
            if(board[0][i]!=' ' && board[0][i]==board[1][i] && board[1][i]==board[2][i])
               { gameWon = true; }
            else if(board[i][0]!= ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
               { gameWon = true; }
         }
         if (board[1][1]!=' ' && ((board[0][0]==board[1][1] && board[1][1]==board[2][2]) || (board[0][2]==board[1][1] && board[1][1]==board[2][0])))
           { gameWon = true; }
      }
   }
   
   public void printFinalStatus(){
      if(gameWon){
         if(playersTurn % 2 != 0)
            {JOptionPane.showMessageDialog(null, "X is the champion!");}
         else{JOptionPane.showMessageDialog(null, "O is the champion!");}
      }
      else{JOptionPane.showMessageDialog(null, "It's a Draw!");} 
   }
   
    private boolean validateMove(int row, int col){
   
      boolean validMove = true;
      if(row < 0 || col < 0 || row > 2 || col > 2){
         JOptionPane.showMessageDialog(null, "ERROR: Invalid location.\nTry again.");
         validMove = false;
      }else if(board[row][col] != ' '){JOptionPane.showMessageDialog(null,"ERROR: Spot taken,\nTry again.");
         validMove = false;
      }
      return validMove;  
   }
 
}