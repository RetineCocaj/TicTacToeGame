/** TicTacToeManager creates the instances of model, view, controller and shows the connection between them. */
public class TicTacToeManager{
   
   public static void main(String[] args){
      
      TicTacToeModel model = new TicTacToeModel();
      TicTacToeView view = new TicTacToeView();
      TicTacToeController controller = new TicTacToeController(model, view);
      controller.welcome();
      controller.play(); 
   }
}