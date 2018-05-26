/** TicTacToeController takes inputs (position of row and column to put the mark in specified cell) 
    from users and shows them in the board view. */
import javax.swing.*;
public class TicTacToeController{
   
   private TicTacToeModel model;
   private TicTacToeView view;
   
   public TicTacToeController(TicTacToeModel m, TicTacToeView v){
      model = m;
      view = v;
   }
   
   public void welcome(){
      JOptionPane.showMessageDialog(null, "Instructions:\nYou should determine the number of row and column to place the mark.\n" +
                                          "0 --- First Row or Column \n1 --- Second Row or Column \n2 --- Third Row or Column \n" +
                                          "Enjoy it!", "Welcome to TicTacToe", JOptionPane.INFORMATION_MESSAGE);
   }
   
   public void play(){
      while(model.getPlayersTurn() < 9 && !model.getGameIsWon()){
         int turn = model.getPlayersTurn();
         char player;
         if(turn % 2 == 0){player = 'X';}
         else{player = 'O';}
         try{
            String row = JOptionPane.showInputDialog("Player " + player+ "\nEnter number for ROW{0,1,2}:");
            int r = new Integer(row).intValue();
            String col = JOptionPane.showInputDialog("Player " + player + "\nEnter number for COLUMN{0,1,2}:");
            int c = new Integer(col).intValue();
         
            if(model.makeMove(r, c)){
               if(turn % 2 == 0){ view.drawX(r, c); }
               else{ view.drawO(r, c); }
               model.checkForWin();
            }
         }
         catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "ERROR: Invalid input. \nPlease enter a number between 0 and 2.");}
      
      }
      model.printFinalStatus();
      view.closeWindow();
      while(playAgain()){this.play();}
   }
   
   public boolean playAgain(){
      boolean answer = false;
      int again = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Let's play again", JOptionPane.YES_NO_OPTION);
      if(again == 0){ new TicTacToeController(new TicTacToeModel(),new TicTacToeView()).play();}
      else{JOptionPane.showMessageDialog(null, "Ok, come back later and play again.");}
      return answer;
   }
}