package LinkedList_final;

public class Queue<E> extends MyPriorityQueue<E> {
    private long counter = 0;

    public void enqueue(E element) {
        insert(-counter++, element); // older enqueues have higher priority
    }

    public E dequeue() {
        return removeMaxPriority();
    }

    public boolean isEmptyQueue() {
        return isEmpty();
    }

    // test
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        while (!queue.isEmptyQueue()) {
            System.out.println(queue.dequeue());  // should print A, B, C
        }
    }
}
