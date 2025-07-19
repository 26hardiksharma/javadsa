
public class RatMazeAllPaths {
    public static int count;
    public static void solve(int[][] maze,int[][] ans,int row,int col) {
        if(row == maze.length || col == maze.length || row == -1 || col == -1) {
            return;
        }

        if(row == maze.length-1 && col == maze.length-1) {
            ans[row][col] = 1;
            printBoard(ans);
            ans[row][col] = 0;
            count++;
            return;
        }

        if(maze[row][col] == 0 || ans[row][col] == 1) {
            return;
        }

        ans[row][col] = 1;

        solve(maze, ans, row, col+1);
        solve(maze, ans, row+1, col);
        solve(maze, ans, row, col-1);
        solve(maze, ans, row-1, col);

        ans[row][col] = 0;
    }

    

    public static void printBoard(int board[][]) {
        System.out.println("============ MAZE ============");
        for(int i = 0;i<board.length;i++) {
            for(int j = 0;j<board.length;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 1, 1, 0, 0 },
            { 1, 1, 1, 1 } 
        };

        int ans[][] = new int[4][4];
        solve(maze, ans, 0, 0);
        System.out.println(count);


    }    
}
