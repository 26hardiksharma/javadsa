import java.util.PriorityQueue;

public class NearbyCars {

    static class Car implements Comparable<Car>{
        int x,y;
        double dist;
        Car(int x,int y) {
            this.x = x;
            this.y = y;
            this.dist = Math.sqrt(x*x + y*y);
        }

        public int compareTo(Car c) {
            return Double.compare(this.dist,c.dist);
        }
        
    }

    public static void nearbyKCars(Car[] arr,int k) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        for (Car car : arr) {
            pq.add(car);
        }
        for(int i = 0;i<k;i++) {
            Car c = pq.remove();
            System.out.println("("+c.x + " " + c.y + ")");

        }

    }
    public static void main(String[] args) {
        Car c1 = new Car(3,3);
        Car c2 = new Car(5,-1);
        Car c3 = new Car(-2,4);
        nearbyKCars(new Car[]{c1,c2,c3}, 2);
    }
}
