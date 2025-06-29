

public class decimalToBinary {

    public static int convert(int n) {
        int ret =0;
        int rem;
        int digit = 0;
        while(n != 0) {
            rem = n%2;
            n/=2;
            ret= (int)Math.pow(10,digit++)*rem + ret;
        }
        return ret;
    }
    public static void main(String[] args) {
        int n = 9;
        System.out.println(decimalToBinary.convert(n));

    }
}
