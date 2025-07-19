
public class NQueensCountWays {

    public static int count;
    public static boolean isSafe(char[][] chessBoard,int row,int column) {
        
        for(int i = row-1;i>=0;i--) {

            if(chessBoard[i][column] == 'Q') {

                return false;
            }

        }

        for(int i = row-1,j = column-1;i>=0 && j>= 0; i--,j--) {
            if(chessBoard[i][j] == 'Q') {

                return false;

            }

        }
        for(int i = row-1,j = column+1;i>=0 && j<chessBoard.length; i--,j++) {
            if(chessBoard[i][j] == 'Q') {

                return false;

            }

        }

        return true;
    }
    public static void nQueens(char[][] chessBoard, int row) {
        if(row == chessBoard.length) {
            count++;
            return;
        }

        for(int j = 0;j<chessBoard.length;j++) {
            if(isSafe(chessBoard, row, j)) {

                chessBoard[row][j] = 'Q';
                nQueens(chessBoard, row+1);
                chessBoard[row][j] = 'x';
            }

        }
    }

    public static void printBoard(char chessBoard[][]) {

        System.out.println("---------- Board ----------");
        for(int i = 0;i<chessBoard.length;i++) {
            for(int j = 0;j<chessBoard.length;j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }


    }
    public static void main(String[] args) {
        int n = 10;
        char[][] chessBoard = new char[n][n];

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                chessBoard[i][j] = 'x';
            }
        }
        nQueens(chessBoard, 0);
        System.out.println("Total Ways To Place "+n+" Queens in a "+n+"x"+n+" Board: "+count);
    }
}
