package discreteLab2;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
      char gameboard[][];
     private boolean gameIsOn = true;
     
     public GameBoard() // fill the array with spaces 
     {
        gameboard = new char[13][13];
         
        for (int row = 0; row < gameboard.length; row++)
        {
           Arrays.fill(gameboard[row],' ');
        }
     } 
     /*
      *  This method will display the board of 13 by 13 
      */
     
    public void display()
    {
        for (int n =1 ; n <= 13 ; n++)
        {
            System.out.print(n+"    ");
           
        }
       System.out.print("\n");
        for (int row = 0; row < gameboard.length;row++)
        {
            System.out.println(row+1);
            for (int col = 0; col < gameboard[0].length;col++)
            {
                System.out.print("   "+gameboard[row][col]);
                if(col==0 || col==1 || col==2 || col==3 || col==4 || col==5 || col==6 || col==7 || col==8 || col==9 || col==10 || col==11 )
                {
                   System.out.print("|");
                }
            }
            if ( row == 0 || row != 12)
            {
                System.out.print("\n--------------------------------------------------------------------\n");
            } 
        } 
        System.out.println();
    }
    //end of method display 
    
    /*
     * this method will return the flag value to true or false to determine if game will continue or not
     */
    
    public boolean gameActive()
    {
        return gameIsOn;
    }

    /*
     * this method will ask the user to pick a row and column , validate the inputs and call method getMove() and return true if valid
     */
    
    public void askPlayer(char player)
    {
        Scanner keyboard  = new Scanner(System.in); // get input value from the user  
        int row , col; 
        do
        {
            System.out.printf("Player %s Please enter a row (1-13)  : ", player);
            row = keyboard.nextInt();
           
            System.out.printf("Player %s Please enter a column (1-13)  :", player);
            col = keyboard.nextInt();
                 
        }    
        while(notValid(row,col) || !isEmpty(row,col));   // loop will go until the row col is valid and is empty 
        getMove(player,row-1,col-1);
        CheckForWinner(player,row,col); // this method will check for the winner
        
    } // end of method askPlayer
   
    /*
    *This Method will call the rowWin ColWin and AntidiaWin and DiagWin methods to check for the winner.
    */
   private void CheckForWinner(char player,int row,int col)
   {
       rowWin(player,row,col);// This will  check the row wise winner
       colWin(player,row,col);// This method will check the winner column wise.
       AntidiaWin(player,row,col);// this method will check the winner diagonally.
       diagWin(player,row,col);// This method will check the winner anti diagonally
       
   } // end of method CheckForWinner
   
/*  This method will check over each row and check for the winner. 
 *  if count == 5 then game is come to end and declare the winner player.
 */
    private boolean rowWin(char player, int row, int col)
    {
    	int count = 0  ;  // Number of pieces in a row belonging to the player.
          
        int r, c;      // A row and column to be examined
           
         r = row -1 ;  // Look at square in specified direction.
         c = col;
        
         while ( r >= 0 && r < 13 && c >= 0 && c < 13 && gameboard[r][c] == player) 
           {   
              count++;
              c = c + 1; 
           }
              
             if ( count == 5 )
            {
                 gameIsOn = false;
                 System.out.print("\n GAME OVER!!!\n");
                 System.out.print("\n THE WINNER IS " + gameboard[row-1][col-1]);
                 return gameIsOn;
            }
                           // Look in the opposite direction.
           c = col - 1;
           while ( r >= 0 && r < 13 && c >= 0 && c < 13 && gameboard[r][c] == player )
           {
              count++;
              c = c - 1;
           }
      
           if ( count == 5 )
             {
                 gameIsOn = false;
                 System.out.print("\nGAME OVER!!!\n");
                 System.out.print("\nTHE WINNER IS "+ gameboard[row-1][col-1]);
                 return gameIsOn;
             }
           return true;
 }  // end of method rowWin
 /*
   *This method will check for the winner column wise and declare the winner player 
    */   
            
private boolean colWin(char player, int row, int col) 
    {
           int count = 0  ;  // Number of pieces in a row belonging to the player.
          
           int r, c;      // A row and column to be examined
           
           r = row;  // Look at square in specified direction.
           c = col - 1;
          
           while ( r >= 0 && r < 13 && c >= 0 && c < 13 && gameboard[r][c] == player) 
           {   
              count++;
              r = r + 1; 
           }
             if ( count == 5 )
            {
                 gameIsOn = false;
                 System.out.print("\nGAME OVER!!!\n");
                 System.out.print("\nTHE WINNER IS "+ gameboard[row-1][col-1]);
                 return gameIsOn;
            }
                          // Look in the opposite direction.
           r = row - 1;
           while ( r >= 0 && r < 13 && c >= 0 && c < 13 && gameboard[r][c] == player )
           {
              count++;
              r =r - 1;
           }
             
           if ( count == 5 )
             {
                 gameIsOn = false;
                 System.out.print("\nGAME OVER!!!");
                 System.out.print("\nTHE WINNER IS "+ gameboard[row-1][col-1]);
                 return gameIsOn;
               
             }
           return true;
 }  // end of method colWin  

//to check for diagonal and declare the winner.


private boolean AntidiaWin(char player, int row, int col) 
    {
           int count = 1  ;  // Number of pieces in a row belonging to the player.
           int r, c;      // A row and column to be examined
           
           r = row ;  // Look at square in specified direction.
           c = col - 2;
          
           while ( r >= 0 && r < 13 && c >= 0 && c < 13 && gameboard[r][c] == player) 
           {   
              count++;
              r = r + 1;
              c = c - 1;
   
           }
             
             if ( count == 5 )
            {
                 gameIsOn = false;
                 System.out.print("\nGAME OVER!!!\n");
                 System.out.print("\nTHE WINNER IS "+ gameboard[row-1][col-1]);
                 return gameIsOn;
            }
                          // Look in the opposite direction.
           r = row - 2;
           c = col;
   
           while ( r >= 0 && r < 13 && c >= 0 && c < 13 && gameboard[r][c] == player )
           {
              count++;
              r = r - 1;
              c = c + 1; 
             
           }
           
           if ( count == 5 )
             {
                 gameIsOn = false;
                 System.out.print("\nGAME OVER!!!");
                 System.out.print("\nTHE WINNER IS "+ gameboard[row-1][col-1]);
                 return gameIsOn;
             }
           return true;
 } 
    
/*
* this method will check for the winner diagonally across the squares and declare the winner.
*/
 private boolean diagWin(char player, int row, int col) 
    {
           int count = 0  ;  // Number of pieces in a row belonging to the player.
          
           int r, c;      // A row and column to be examined
           
           r = row;  // Look at square in specified direction.
           c = col;
 
           while ( r >= 0 && r < 13 && c >= 0 && c < 13 && gameboard[r][c] == player) 
           {   
              count++;
              r = r + 1;
              c = c + 1;
           }
             if ( count == 5 )
            {
                 gameIsOn = false;
                 System.out.print("\nGAME OVER!!!\n");
                 System.out.print("\nTHE WINNER IS "+ gameboard[row-1][col-1]);
                 return gameIsOn;
            }
                          // Look in the opposite direction.
           r = row - 1;
           c = col - 1;
           
           while ( r >= 0 && r < 13 && c >= 0 && c < 13 && gameboard[r][c] == player )
           {
              count++;
              r = r - 1;
              c = c - 1; 
           }
           if ( count == 5 )
             {
                 gameIsOn = false;
                 System.out.print("\nGAME OVER!!!\n");
                 System.out.print("\nTHE WINNER IS "+ gameboard[row-1][col-1]);
                 return gameIsOn;
             }
           return true;
           
    }          
  /*this method will check if position is empty   
  *and row and column entered is between 1 to 13
    */  
    public boolean notValid(int row , int col)
    {
        if (row > 13 || row < 1 )
        {
            System.out.print("Please enter a valid position!!\n");
            return true;
        }    
       
        if (col > 13 || col < 1 )
        {
           System.out.print("Please enter a valid position!!\n");
            return true;
        }    
        else
            return false ; 
     }
    
    /*
     * this method will check if position is empty
     */
    public boolean isEmpty(int row , int col)
    {   
        if (gameboard[row-1][col-1] == ' ')
        {
            return true;
        }            
        else 
        {
            System.out.print("That Position is taken!!\n");
            return false;
        }
    }
   
    /*
     * This method will validate if players move is allowed or not
     */
    public boolean getMove(char player, int row, int col)
    {
        if (row >=0  || row <= 13  || col >= 0 || col <= 13)
        {
            if (gameboard[row][col] != ' ')
            {
                return false;
                
            }
            else
            {
             gameboard[row][col] = player;
             //System.out.print(player);
             return true ;
            }    
        }
        else
            return false;
            
    }
    //end of getMove method
}

