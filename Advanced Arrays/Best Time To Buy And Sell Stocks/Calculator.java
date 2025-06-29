
public class Calculator {
    public static int maximumProfit(int stocks[]) {
        int maxProfit=0;

        int maxRightBoundary[] = new int[stocks.length];
        maxRightBoundary[stocks.length-1] = stocks[stocks.length-1];
        
        for(int i = stocks.length-2;i>=0;i--) {
            maxRightBoundary[i] = Math.max(maxRightBoundary[i+1], stocks[i]);
        }
        for(int i = 0;i<stocks.length;i++) {
            if(maxRightBoundary[i]-stocks[i]>maxProfit) maxProfit = maxRightBoundary[i] - stocks[i];
        }
        return maxProfit;
    }
}   
