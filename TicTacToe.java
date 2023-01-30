import java.util.*;

// Ok most of this code is from Becky, just improved

public class TicTacToe {
    public static void main(String[] args) {
        Board boardTest = new Board(); 
        boardTest.printBoard();
        boolean winCon = false; 
        int row;
        int column;
        char playerX = 'X'; 
        char playerO = 'O';
        Scanner sc = new Scanner(System.in);
        int moveCount = 0;
        while (winCon == false){
            System.out.println("Type Row Position ");
            row = sc.nextInt()-1;
            System.out.println("Type Column Position");
            column = sc.nextInt()-1; 
            boardTest.set(row, column, playerX);
            boardTest.printBoard();
            //reprint new board
            winCon = boardTest.winCon();
            if (winCon) break; 
            moveCount++;
            if(moveCount >= 9) break;
            //if winning coniditions occur
            System.out.println("Type Row Position");
            row = sc.nextInt()-1;
            System.out.println("Type Column Position");
            column = sc.nextInt()-1;
            boardTest.set(row, column, playerO);
            boardTest.printBoard();
            winCon = boardTest.winCon();
            if (winCon) break;
            moveCount++;
            if(moveCount >= 9) break;
        }
        if(!winCon) System.out.println("Tie!");
    }
} 

class Board{
    char [][] boardSpace; 
    public void printBoard() {
        // System.out.println(" " + boardSpace[0][0] + "  | " + boardSpace[0][1] + "  | " + boardSpace[0][2]);
        System.out.printf(" %s | %s | %s \n", boardSpace[0][0], boardSpace[0][1], boardSpace[0][2]);
        System.out.println("---|---|---");
        // System.out.println(" " + boardSpace[1][0] + "  | " + boardSpace[1][1] + "  | " + boardSpace[1][2]);
        System.out.printf(" %s | %s | %s \n", boardSpace[1][0], boardSpace[1][1], boardSpace[1][2]);
        System.out.println("---|---|---");
        // System.out.println(" " + boardSpace[2][0] + "  | " + boardSpace[2][1] + "  | " + boardSpace[2][2]);
        System.out.printf(" %s | %s | %s \n", boardSpace[2][0], boardSpace[2][1], boardSpace[2][2]);
        System.out.println("____________");
        
    }
    public Board() {
        this.boardSpace = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '},{' ', ' ', ' '}};
    }
    public void set(int row, int column, char x) {
        boardSpace[row][column] = x;
    }
    public boolean winCon(){
        for(int row = 0; row < 3; row++){
            if(boardSpace[row][0] == boardSpace[row][1] && boardSpace[row][1] == boardSpace[row][2] && (boardSpace[row][2] == 'X' || boardSpace[row][2] == 'O')){
                System.out.println("Good game ! ");
                return true;
            }
        }
        for(int column = 0; column < 3; column++){
            if(boardSpace[0][column] == boardSpace[1][column] && boardSpace[1][column] == boardSpace[2][column] && (boardSpace[2][column] == 'X' || boardSpace[2][column] == 'O')){
                System.out.println("Good game ! ");
                return true;
            }
        }
        if(boardSpace[0][0] == boardSpace[1][1] && boardSpace[1][1] == boardSpace[2][2] && (boardSpace[2][2] == 'X' || boardSpace[2][2] == 'O')){
            System.out.println("Good game ! ");
            return true;
        } 
        if(boardSpace[0][2] == boardSpace[1][1] && boardSpace[1][1] == boardSpace[2][0] && (boardSpace[2][0] == 'X' || boardSpace[2][0] == 'O')){
            System.out.println("Good game ! ");
            return true;
        }
        return false;
    }
}