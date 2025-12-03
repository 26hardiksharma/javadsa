import java.util.PriorityQueue;
public class PQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        PriorityQueue<Student> pqs = new PriorityQueue<>();

        Student s1 = new Student("Hardik", 100);
        Student s2 = new Student("Saumya", 200);
        Student s3 = new Student("Saptanshu", 150);

        pqs.add(s3);
        pqs.add(s2);
        pqs.add(s1);

        while (!pqs.isEmpty()) {
            System.out.println(pqs.peek().name + " " + pqs.peek().rank);
            pqs.remove();
        }

        
    }
}
