
public class KnightsTour {
    public static int step=1;

    public static int[] nextRow = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] nextCol= {1, 2, 2, 1, -1, -2, -2, -1};

    public static boolean knightsTour(int[][] board,int row,int col) {
        if(row <0 || col <0 || row>= board.length || col >= board.length) {
            return false;
        }

        if(step == board.length*board.length+1) {
            printBoard(board);
            return true;
        } 

        if(board[row][col] != 0) {
            return false;
        }
        board[row][col]=step++;

        for(int i = 0;i<8;i++) {
            if(knightsTour(board, row+nextRow[i], col+nextCol[i])) {
                return true;
            }
        }
        board[row][col] = 0;
        step--;

        return false;

    }
    
    public static void printBoard(int board[][]) {
        System.out.println("============ BOARD ============");
        for(int i = 0;i<board.length;i++) {
            for(int j = 0;j<board.length;j++) {
                System.out.printf("%2d ",board[i][j]);
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        int n = 8;
        int board[][] = new int[n][n];
        if(!knightsTour(board,7,7)){
            System.out.println("No Solution Found.");
        };

    }    
}
