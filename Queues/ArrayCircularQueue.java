public class ArrayCircularQueue {
    int[] array;
    int front;
    int rear;
    int size;

    ArrayCircularQueue(int n){
        array = new int[n];
        size = n;
        front = -1;  
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear+1)%size == front;
    }

    public void add(int n) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if(front == -1) front = 0;
        rear = (rear+1)%size;
        array[rear] = n;
        if(front == -1) {
            front = rear;
        }
    }

    public int remove() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } 

        int ret = array[front];
        front = (front+1)%size;
        if(rear == front) {
            rear = front = -1;

        }

        return ret;
    }

    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(6);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println(queue.remove());
    }
}
