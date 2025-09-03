public class ArrayQueue {
    int[] array;
    int size;
    int rear;

    ArrayQueue(int n){
        array = new int[n];
        size = n;
        rear = -1;  
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == size-1;
    }

    public void add(int n) {
        if (this.isFull()) {
            System.out.println("Queue is full");
            return;
        }
        this.array[++this.rear] = n;
        
        
    }

    public int remove() {
        if(this.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int front = array[0];
        for(int i = 1;i<rear+1;i++) {
            array[i-1] = array[i];
        }
        rear--;
        return front;
        
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(6);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6); // Queue is full
        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
        queue.remove(); 
    }

}
