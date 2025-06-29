public class binaryToDecimal {
    public static int convert(int binary) {
        int ret = 0;
        int rem;
        int power = 0;
        while(binary != 0) {
            rem = binary%10;
            binary = binary/10;
            ret += rem*Math.pow(2,power++);
        }   
        return ret;
    }
    public static void main(String[] args) {
        int n = 1010;
        System.out.println(convert(n));
    }
}
