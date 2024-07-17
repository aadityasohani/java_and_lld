package prep_java;

import java.util.Scanner;

class Board{
    private boolean gameOn;
    private int emptyCells;
    private String turn;
    private final String [][]boardPlane;
    private final int row;
    private final int col;
    private final boolean isFullRowWin;
    private final boolean isFullColWin;
    private final boolean isFullUpDiagonalWin;
    private final boolean isFullDownDiagonalWin;
    private final int numOfPlayers;

    //rows and cols

    Board(int row, int col, boolean isFullRowWin, boolean isFullColWin, boolean isFullUpDiagonalWin, boolean isFullDownDiagonalWin, int numOfPlayers){
        this.numOfPlayers = numOfPlayers;
        this.isFullColWin = isFullColWin;
        this.isFullRowWin = isFullRowWin;
        this.isFullDownDiagonalWin = isFullDownDiagonalWin;
        this.isFullUpDiagonalWin = isFullUpDiagonalWin;
        this.gameOn = true;
        this.emptyCells = row*col;
        this.row = row;
        this.col = col;
        this.turn = "0";
        this.boardPlane = new String[row][];
        for(int i = 0;i<this.row;i++){
            this.boardPlane[i] = new String[col];
            for(int j = 0;j<this.col;j++){
                this.boardPlane[i][j] = "";
            }
        }

        showBoard();
    }

    public boolean isPossible(int i, int j){
        return i<this.row && j<this.col && i>=0 && j>=0 &&  this.boardPlane[i][j] == null || this.boardPlane[i][j].isEmpty();
    }

    public String checkWinnerInRow(){
        String winner = "";
        for(int i = 0;i<this.row; i++){
            if(!this.boardPlane[i][0].isEmpty()){
                winner = this.boardPlane[i][0];
            }else{
                continue;
            }
            for(int j = 1;j<this.col; j++){
                if(!winner.equals(this.boardPlane[i][j])){
                    winner = "";
                    break;
                }
            }

            if(!winner.isEmpty()){
                return winner;
            }
        }
        return winner;
    }

    public String checkWinnerInCol(){
        String winner = "";
        for(int i = 0;i<this.col; i++){
            if(!this.boardPlane[0][i].isEmpty()){
                winner = this.boardPlane[0][i];
            }else{
                continue;
            }
            for(int j = 1;j<this.row; j++){
                if(!winner.equals(this.boardPlane[j][i])){
                    winner = "";
                    break;
                }
            }

            if(!winner.isEmpty()){
                return winner;
            }
        }
        return winner;
    }

    public String checkWinnerInUpDiagonal(){
        String winner = !this.boardPlane[row-1][0].isEmpty()? this.boardPlane[row-1][0]:"";
        int i = row-2;
        int j = 0;

        while(j<this.col && i>=0 && !winner.isEmpty()){
            if(!winner.equals(this.boardPlane[i][j])){
                return "";
            }
            i--;
            j++;
        }

        return winner;
    }

    public String checkWinnerInDownDiagonal(){
        String winner = !this.boardPlane[0][0].isEmpty()? this.boardPlane[0][0]:"";
        int i = 0;
        int j = 0;

        while(j<this.col && i<row && !winner.isEmpty()){
            if(!winner.equals(this.boardPlane[i][j])){
                return "";
            }
            i++;
            j++;
        }

        return winner;
    }
    public String checkWinner(){
        if(this.isFullRowWin){
            String winner = this.checkWinnerInRow();
            if(!winner.isEmpty()){
                return winner;
            }
        }
        if(this.isFullColWin){
            String winner = this.checkWinnerInCol();
            if(!winner.isEmpty()){
                return winner;
            }
        }

        if(this.isFullUpDiagonalWin){
            String winner = this.checkWinnerInUpDiagonal();
            if(!winner.isEmpty()){
                return winner;
            }
        }
        if(this.isFullDownDiagonalWin){
            String winner = this.checkWinnerInDownDiagonal();
            if(!winner.isEmpty()){
                return winner;
            }
        }
        return "";

    }


    public void placeCurr(int i, int j){
        if(isPossible(i, j)){
            boardPlane[i][j] = String.valueOf(Integer.parseInt(this.turn)+1);
            this.emptyCells -= 1;
            String winner = this.checkWinner();
            this.showBoard();
            if(!winner.isEmpty()){
                this.gameOn = false;
                System.out.println(String.valueOf(Integer.parseInt(this.turn)+1) + " Winns!!");
            }
            if(emptyCells == 0){
                this.gameOn = false;
                if(winner.isEmpty()) {
                    System.out.println("Game Draw!");
                }
            }
            this.turn = String.valueOf((Integer.parseInt(this.turn)+1)%this.numOfPlayers);
        }else{
            System.out.println("Tile doesn't exists/Already Played on this tile! \nRetry!!!");
        }

    }

    public boolean isGameOn(){
        return this.gameOn;
    }

    public void showBoard(){
        System.out.println();
        for(int i = 0;i<this.row;i++){
            for(int j = 0;j<this.col; j++){
                if(this.boardPlane[i][j].isEmpty()) System.out.print("_ ");
                else System.out.print(this.boardPlane[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
public class TicTacToe {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numOfPlayers = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        Board b = new Board(row, col, true, true, true, true, numOfPlayers);
        while(b.isGameOn()){
            int i = sc.nextInt();
            int j = sc.nextInt();

            b.placeCurr(i, j);
        }

    }
}
