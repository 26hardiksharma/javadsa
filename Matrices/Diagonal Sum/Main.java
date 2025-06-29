public class Main {

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;

        for(int i = 0;i<matrix.length;i++) {
            for(int j = 0;j<matrix.length;j++) {
                if(i == j) {
                    sum+=matrix[i][i];
                } else if(i+j == matrix.length-1&& i!=j){
                    sum+= matrix[i][j];
                }
            }
        
        }

        return sum;
    }
    public static void main(String[] args) {
        int matrix[][] =  {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            
        };
        System.out.println(diagonalSum(matrix));
    }    
}
