
public class GameBoard 
{
    public char [][] board = new char [3][3];
    
    public GameBoard() 
    {
        for(int i = 0; i < 3; i++)
        {
            for(int x = 0; x < 3; x++)
                board[i][x] = ' ';
        }
    }
    
    public void PrintBoard()
    {
        System.out.println("Playing Board:          Positions:");
        System.out.println();
        System.out.print("  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.print("        ");
        System.out.println("    1 | 2 | 3 ");
        System.out.println(" ------------          -----------");
        System.out.print("  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.print("        ");
        System.out.println("    4 | 5 | 6 ");
        System.out.println(" ------------          -----------");
        System.out.print("  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
        System.out.print("        ");
        System.out.println("    7 | 8 | 9 ");
        System.out.println();

    }
    
    //checking possible win scenarios
    public int winner(char x)
    {
        int winner = 0;
        
        //draw
        if(board[0][0] != ' ' && board[0][1] != ' ' && board[0][2] != ' ' && board[1][0] != ' ' && board[1][1] != ' ' && board[1][2] != ' ' && board[2][0] != ' ' && board[2][1] != ' ' && board[2][2] != ' ')
        {
            winner = 3;
        }
        //top left corner wins
        if(board[0][0] == x)
        {
            //first row
            if(board[0][1] == x && board[0][2] == x)
            {
                if(x == 'X')
                    winner = 1;
                else if(x == 'O')
                    winner = 2;
            }
            //first column
            else if(board[1][0] == x && board[2][0] == x)
            {
                if(x == 'X')
                    winner = 1;
                else if(x == 'O')
                    winner = 2;
            }
            //diagonal \
            else if(board[1][1] == x && board[2][2] == x)
            {
                if(x == 'X')
                    winner = 1;
                else if(x == 'O')
                    winner = 2;
            }          
        }
        
        //bottom right wins
        else if(board[2][2] == x)
        {
            //last column
            if(board[2][1] == x && board[0][2] == x)
            {
                if(x == 'X')
                    winner = 1;
                else if(x == 'O')
                    winner = 2;
            }
            //last row
            else if(board[2][1] == x && board[2][0] == x)
            {
                if(x == 'X')
                    winner = 1;
                else if(x == 'O')
                    winner = 2;
            }
        }
        
        //middle
        else if(board[1][1] == x)
        {
            //middle column
            if(board[0][1] == x && board[2][1] == x)
            {
                if(x == 'X')
                    winner = 1;
                else if(x == 'O')
                    winner = 2;
            }
            //middle row
            else if(board[1][0] == x && board[1][2] == x)
            {
                if(x == 'X')
                    winner = 1;
                else if(x == 'O')
                    winner = 2;
            }
            //diagonal /
            else if(board[2][0] == x && board[0][2] == x)
            {
                if(x == 'X')
                    winner = 1;
                else if(x == 'O')
                    winner = 2;
            }
        }
                return winner;
    }
    
    //checking to see if positions are already filled
    public boolean checkPos(int move, char x)
    {
        boolean position;
        position = true;
        switch(move)
        {
            case 1:
                //top left
                if (board[0][0] == 'X' || board[0][0] == 'O')
                {
                    position = false;
                    break;
                }
                else if(board [0][0] == ' ')
                {
                    board[0][0] = x;
                    break;
                }
            case 2:
                //top middle
                if (board[0][1] == 'X' || board[0][1] == 'O')
                {
                    position = false;
                    break;
                }
                else if(board [0][1] == ' ')
                {
                   board[0][1] = x; 
                   break;
                }
                          
            case 3:
                //top right
                if (board[0][2] == 'X' || board[0][2] == 'O')
                {
                    position = false;
                    break;
                }
                else if(board [0][2] == ' ')
                {
                   board[0][2] = x;
                   break;
                }
            case 4:
                //middle left
                if (board[1][0] == 'X' || board[1][0] == 'O')
                { 
                    position = false;
                    break;
                }
                else if(board [1][0] == ' ')
                {
                   board[1][0] = x; 
                   break;
                }
            case 5:
                //middle
                if (board[1][1] == 'X' || board[1][1] == 'O')
                { 
                    position = false;
                    break;
                }
                else if(board [1][1] == ' ')
                {
                   board[1][1] = x;
                   break;
                }
                    
            case 6:
                //middle right
                if (board[1][2] == 'X' || board[1][2] == 'O')
                {
                    position = false;
                    break;
                }
                else if(board [1][2] == ' ')
                {
                   board[1][2] = x; 
                   break;
                }
                
            case 7:
                //bottom left
                if (board[2][0] == 'X' || board[2][0] == 'O')
                {
                    position = false;
                    break;
                }
                else if(board [2][0] == ' ')
                {
                   board[2][0] = x; 
                   break;
                }
            case 8:
                //bottom middle
                if (board[2][1] == 'X' || board[2][1] == 'O')
                {
                    position = false;
                    break;
                }
                else if(board [2][1] == ' ')
                {
                   board[2][1] = x; 
                   break;
                }
            case 9:
                //bottom right
                if (board[2][2] == 'X' || board[2][2] == 'O')
                {
                    position = false;
                    break;
                }
                else if(board [2][2] == ' ')
                {
                   board[2][2] = x; 
                   break;
                }
                   
            default:
                position = false;
                
        }
    
        return position;
    }
    
    public void setMove(int x, char y)
    {
        switch(x)
        {
            case 1:
                board[0][0] = y;
                break;
            case 2:
                board[0][1] = y;
                break;
            case 3:
                board[0][2] = y;
                break;
            case 4:
                board[1][0] = y;
                break;
            case 5:
                board[1][1] = y;
                break;
            case 6:
                board[1][2] = y;
                break;
            case 7:
                board[2][0] = y;
                break;
            case 8:
                board[2][1] = y;
                break;
            case 9:
                board[2][2] = y;
                break;
            
        }
    }
    
    public int compWin(char x)
    {   
        int winningMove = 0;
        
        //Through center
        if(board[1][1] == x)
        {
            if(board[0][0] == x && board[2][2] == ' ')
                winningMove = 9;
            else if(board[0][1] == x && board[2][1] == ' ')
                winningMove = 8;
            else if(board[0][2] == x && board[2][0] == ' ')
                winningMove = 7;
            else if(board[1][0] == x && board[1][2] == ' ')
                winningMove = 6;
            else if(board[1][2] == x && board[1][0] == ' ')
                winningMove = 4;
            else if(board[2][0] == x && board[0][2] == ' ')
                winningMove = 3;
            else if(board[2][1] == x && board[0][1] == ' ')
                winningMove = 2;
            else if(board[2][2] == x && board[0][0] == ' ')
                winningMove = 1;
        }
        //top left corner
        else if(board[0][0] == x)
        {
            if(board[0][1] == x && board[0][2] == ' ')
                winningMove = 3;
            else if(board[0][2] == x && board[0][1] == ' ')
                winningMove = 2;
            else if(board[1][1] == x && board[2][2] == ' ')
                winningMove = 9;            
            else if(board[2][2] == x && board[1][1] == ' ')
                winningMove = 5;
            else if(board[2][0] == x && board[1][0] == ' ')
                winningMove = 4;
            else if(board[1][0] == x && board[2][0] == ' ')
                winningMove = 7;           
        }
        //bottom right coner
        else if(board[2][0] == x)
        {
            if(board[2][1] == x && board[2][2] == ' ')
                winningMove = 9;
            else if(board[2][2] == x && board[2][1] == ' ')
                winningMove = 8;
            else if(board[1][0] == x && board[0][0] == ' ')
                winningMove = 1;            
            else if(board[0][0] == x && board[1][0] == ' ')
                winningMove = 4;
            else if(board[0][2] == x && board[1][1] == ' ')
                winningMove = 5;
            else if(board[1][1] == x && board[0][2] == ' ')
                winningMove = 3;           
        }
        //bottom right corner
        else if(board[2][2] == x)
        {
            if(board[2][0] == x && board[2][1] == ' ')
                winningMove = 8;
            else if(board[2][1] == x && board[2][0] == ' ')
                winningMove = 7;
            else if(board[1][2] == x && board[0][2] == ' ')
                winningMove = 3;            
            else if(board[0][2] == x && board[1][2] == ' ')
                winningMove = 6;
            else if(board[0][0] == x && board[1][1] == ' ')
                winningMove = 5;
            else if(board[1][1] == x && board[0][0] == ' ')
                winningMove = 1;           
        }
        //bottom left corner
        else if(board[2][0] == x)
        {
            if(board[2][1] == x && board[2][2] == ' ')
                winningMove = 9;
            else if(board[2][2] == x && board[2][1] == ' ')
                winningMove = 8;
            else if(board[1][1] == x && board[0][2] == ' ')
                winningMove = 3;            
            else if(board[0][2] == x && board[1][1] == ' ')
                winningMove = 5;
            else if(board[0][0] == x && board[1][0] == ' ')
                winningMove = 4;
            else if(board[1][0] == x && board[0][0] == ' ')
                winningMove = 1;           
        }


        return winningMove;
    }
    
}



    

