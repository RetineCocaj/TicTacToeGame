/**TicTacToeView draws the board and the marks that are needed to be shown*/
import javax.swing.*;
import java.awt.*;

public class TicTacToeView extends JPanel{
     
   final private int WIDTH = 500;
   final private int pos_Border = 100;
   final private int pos_XO = 120;
   final private int size_XO = 60;
   final private int[][] rowsX = new int[3][3];
   final private int[][] colsX = new int[3][3];
   final private int[][] rowsO = new int[3][3];
   final private int[][] colsO = new int[3][3];
   private JFrame my_frame;


    public TicTacToeView(){
   
      my_frame = new JFrame();
      my_frame.getContentPane().add(this);
      my_frame.setTitle("TIC TAC TOE");
      my_frame.setSize(WIDTH,WIDTH);
      my_frame.setVisible(true);
      
      for(int i=0; i<3; i++){
         for(int j=0; j<3; j++){
            rowsX[i][j] = -5;
            rowsO[i][j] = -5;
         }
      }
      
      for(int j=0;j<3;j++){  
         for(int i=0;i<3;i++){
            colsX[i][j] = -5;
            colsO[i][j] = -5;
         }
      }
     
   }
   
   public void paintComponent(Graphics g){
     
      g.setColor(Color.white);
      g.fillRect(0,0,WIDTH,WIDTH);
      g.setColor(Color.black);
      for(int i=1; i<3;i++){
         for(int j=1; j<=2; j++){
            g.drawLine(pos_Border*(i+1), pos_Border, pos_Border*(i+1), pos_Border*(j+2));
            g.drawLine(pos_Border, pos_Border*(j+1), pos_Border*(i+2), pos_Border*(j+1));
         }
      }
      g.setColor(Color.red);
      for(int i=0;i<3;i++){
         for(int j=0;j<3;j++){
            g.drawLine(pos_XO+(colsX[i][j]*pos_Border), pos_XO+(rowsX[i][j]*pos_Border), 
                       pos_XO+(colsX[i][j]*pos_Border)+size_XO, pos_XO+(rowsX[i][j]*pos_Border)+size_XO);
                       
            g.drawLine(pos_XO+(colsX[i][j]*pos_Border), pos_XO+(rowsX[i][j]*pos_Border)+size_XO, 
                       pos_XO+(colsX[i][j]*pos_Border)+size_XO, pos_XO+(rowsX[i][j]*pos_Border));
         }
      }    
      g.setColor(Color.blue);
      for(int i=0;i<3;i++){
         for(int j=0;j<3;j++){
            g.drawOval(pos_XO+(colsO[i][j]*pos_Border), pos_XO+(rowsO[i][j]*pos_Border), size_XO, size_XO);
         }
      }               
   }
   
   public void drawX(int row,int col){
      rowsX[row][col] = row;
      colsX[row][col] = col;
      this.repaint();  
   }

   
   public void drawO(int row,int col){
      rowsO[row][col] = row;
      colsO[row][col] = col;
      this.repaint();  
   }
   
   public void closeWindow(){
      my_frame.dispose();
   }
}