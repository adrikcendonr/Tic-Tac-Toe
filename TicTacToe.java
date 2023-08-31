
import java.util.Scanner;
import java.util.Random;

public class TicTacToe 
{

    public static void main(String[] args) 
    {   
        GameBoard b = new GameBoard();
        int winner;
        Scanner in = new Scanner (System.in);
        
        //Two human players
        if(args.length == 0)
        {
            humanPlayer x = new humanPlayer(1);
            humanPlayer y = new humanPlayer(2);
            winner = 0;
            
            while(winner == 0)
            {
                b.PrintBoard();
                System.out.println("Player 1, please enter a move (1-9): ");
                int move = in.nextInt();
                while(checkMove(move) != true)
                {
                    System.out.println("Player 1, please enter a move (1-9): ");
                    move = in.nextInt();
                }
                x.Play(b, move);
                winner = b.winner(x.sign());
                if(winner != 0) 
                    break;
                b.PrintBoard();
                System.out.println("Player 2, please enter a move (1-9): ");
                move = in.nextInt();
                while(checkMove(move) != true)
                {
                    System.out.println("Player 2, please enter a move (1-9): ");
                    move = in.nextInt();
                }
                y.Play(b, move);
                winner = b.winner(y.sign());
            }
            switch(winner)
            {
                case 1: 
                    b.PrintBoard();
                    System.out.println("Player 1 has won. Congratulations!");
                    break;
                case 2:
                    b.PrintBoard();
                    System.out.println("Player 2 has won. Congratulations!");
                    break;
                default:
                    b.PrintBoard();
                    System.out.println("Game has ended in a tie.");
            }
        }
        
        //Two computer players
        else if(args.length == 1)
        {
            compPlayer x = new compPlayer(1);
            compPlayer y = new compPlayer(2);
            winner = 0;
            
            while(winner == 0)
            {
                b.PrintBoard();
                System.out.println("Player 1 selected " + x.Play(b, 0));                
                winner = b.winner(x.sign());
                if(winner != 0)
                    break;
                b.PrintBoard();
                System.out.println("Player 2 selected " + y.Play(b, 0));                
                winner = b.winner(y.sign());
            }
            switch(winner)
            {
                case 1:
                    b.PrintBoard();
                    System.out.println("Player 1 has won. Congratulations!");
                    break;
                case 2:
                    b.PrintBoard();
                    System.out.println("Player 2 has won. Congratulations!");
                    break;
                default:
                    b.PrintBoard();
                    System.out.println("Game has ended in a tie.");
            }
        }
        
        else if(args[0].equals("-c") && args[1].equals("1")) //computer is 'X', human is 'O
        {
            compPlayer x = new compPlayer(1);
            humanPlayer y = new humanPlayer(2);
            winner = 0;
            
            while(winner == 0)
            {
                b.PrintBoard();
                System.out.println("Player 1 selected " + x.Play(b, 0));                
                winner = b.winner(x.sign());
                if(winner != 0)
                    break;
                b.PrintBoard();
                System.out.println("Player 2, please enter a move (1-9):");
                int move = in.nextInt();
                while(checkMove(move) != true)
                {
                    System.out.println("Player 2, please enter a move (1-9):");
                    move = in.nextInt();
                }
                y.Play(b, move);
                winner = b.winner(y.sign());
            }
            switch(winner)
            {
                case 1:
                    b.PrintBoard();
                    System.out.println("Player 1 has won. Congratulations!");
                    break;
                case 2:
                    b.PrintBoard();
                    System.out.println("Player 2 has won. Congratulations!");
                    break;
                default:
                    b.PrintBoard();
                    System.out.println("Game has ended in a tie.");
                    break;
            }
            
        }
        
        //Human player is 'X' and computer player is 'O
        else if(args[0].equals("-c") && args[1].equals("2"))
        {
            humanPlayer x = new humanPlayer(1);
            compPlayer y = new compPlayer(2);
            winner = 0;
            
            while(winner == 0)
            {
                b.PrintBoard();
                System.out.println("Player 1, please enter a move (1-9):");
                int move = in.nextInt();
                while(checkMove(move) != true)
                {
                    System.out.println("Player 1, please enter a move (1-9):");
                    move = in.nextInt();
                }
                x.Play(b, move);
                winner = b.winner(x.sign());
                if(winner != 0) 
                    break;
                b.PrintBoard();
                System.out.println("Player 2 selected " + y.Play(b, 0));                
                winner = b.winner(y.sign());
                
            }
            
            switch(winner)
            {
                case 1:
                    b.PrintBoard();
                    System.out.println("Player 1 has won. Congratulations!");
                    break;
                case 2:
                    b.PrintBoard();
                    System.out.println("Player 2 has won. Congratulations!");
                    break;
                default:
                    b.PrintBoard();
                    System.out.println("Game has ended in a tie.");
                    break;
            }
        }
    }
    
    //error checking
    static public boolean checkMove(int move)
    {
        if(move < 1 || move > 9)
        {
            System.out.println("Invalid move entered.");
            return false;
        }
        else
            return true;
    }
    
    

}
    
//base class to make derived classes
abstract class Player
{
    public int playerNum;
    
    public Player()
    {}
    
    public Player(int x)
    {
        playerNum = x;
    }
    
    public char sign()
    {
        if(playerNum == 1)
            return 'X';
        else if(playerNum == 2)
            return 'O';
        else 
            return '\0';
    }
    
    public abstract int Play(GameBoard b, int move);
     
    
}

class humanPlayer extends Player
{
    public humanPlayer()
    {
        super();
    }
    
    public humanPlayer(int x)
    {
        super(x);
    }
    
    public int Play(GameBoard b, int move)
    {
        Scanner in = new Scanner(System.in);
        int check = 1;
        char sign;
        if(playerNum == 1)
        {
            sign = 'X';
        }
        else if(playerNum == 2)
        {
            sign = 'O';
        }
        else 
            sign = '\0';
        
        
        while(check == 1)
        {
            if(b.checkPos(move, sign)==true)
                check = 0;
            else
            {
                b.PrintBoard();
                System.out.println("The position on that board is already filled.");
                System.out.println("Please enter another move: ");
                move = in.nextInt();
            }
       }
       
       return 0;
    }
    
}

class compPlayer extends Player
{
    public compPlayer()
    {
        super();
    }
    
    public compPlayer(int x)
    {
        super(x);
    }
    public int Play(GameBoard b, int move)
    {
        Scanner in = new Scanner(System.in);
        int check = 1;
        char sign;
        if(playerNum == 1)
        {
            sign = 'X';
        }
        else if(playerNum == 2)
        {
            sign = 'O';
        }
        else 
            sign = '\0';
        
        
        int winningMove = 0;
        winningMove = b.compWin(sign);
        if(winningMove != 0)
        {
            b.setMove(winningMove, sign);
            return winningMove;
        }
        
        char blocking = '\0';
        if(sign == 'X')
            blocking = 'O';
        else if(sign == 'O')
            blocking = 'X';
        winningMove = b.compWin(sign);
        if(winningMove != 0)
        {
            b.setMove(winningMove, blocking);
            return winningMove;
        }
        
        char middle = ' ';
        if(b.checkPos(5, middle) == true)
        {
            b.board[1][1] = sign;
            return 5;
        }
        
        Random pos = new Random();
        int play;
        play = pos.nextInt(9);
        play = play + 1;
        if(b.checkPos(play, sign) == true)
        {
            b.setMove(play, sign);
            return play;
        }
        
        
        
        return 0;
    }
    
 
    

            
}
