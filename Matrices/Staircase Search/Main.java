public class Main {
    public static void search(int matrix[][],int key) {
        int startRow = 0;
        int startCol = matrix[0].length-1;

        while(startRow<matrix.length && startCol >0) {
            if(matrix[startRow][startCol] == key) {
                System.out.println("Key Found at Index: "+startRow + ","+startCol);
                return;
            } else if(matrix[startRow][startCol]<key) {
                startRow++;
            } else {
                startCol--;
            }
        }
        System.out.println("Key not found in the matrix.");
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50}
        };
        search(matrix, 33);
    }    
}
