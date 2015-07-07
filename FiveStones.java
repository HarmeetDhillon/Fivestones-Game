package discreteLab2;
/**
 *
 * @author Harmeet
 */
public class FiveStones {
    
    public static void main(String[] args) 
    {
       GameBoard boardGame = new GameBoard();
       boardGame.display();
       int count = 1;
     
       while (boardGame.gameActive() && count < 170 )
       {
           if ( count % 2 == 0 )
           {
               boardGame.askPlayer('O');
               
           }
           else
           {
               boardGame.askPlayer('X');
           }
               
           count++;
           System.out.print("\n");
           boardGame.display();
        
           if (count == 170)
           {
               System.out.print("MATCH ENDS IN DRAW!!!");
           }
       }
    }     
}

