public class Main {

    public static void printSpiral(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        int endRow = m-1;
        int endCol =n-1;

        while(startRow<=endRow && startCol<=endCol) {
            for(int j = startCol;j<=endCol;j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            for (int i = startRow+1;  i<= endRow; i++) {
                System.out.print(matrix[i][endCol]+" ");
            }
            for(int j = endCol-1;j>=startCol;j--) {
                if(endRow == startRow) break;
                System.out.print(matrix[endRow][j] + " ");
            }
            
            for(int i = endRow -1;i>=startRow+1;i--) {
                if(startCol==endCol) break;
                System.out.print(matrix[i][startCol]+ " ");

            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;

        }

        System.out.println();
    }
    public static void main(String[] args) {
        // int m = 4;
        // int n = 4;
        int matrix[][] = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        
        printSpiral(matrix);


    }
}
