package LinkedList_final;

public class RandomQueue<E> extends MyPriorityQueue<E> {
    public void insertAtRandom(E element) {
        double randomPriority = Math.random();
        insert(randomPriority, element);
    }

    // test
    public static void main(String[] args) {
        RandomQueue<String> rq = new RandomQueue<>();
        rq.insertAtRandom("A");
        rq.insertAtRandom("B");
        rq.insertAtRandom("C");

        while (!rq.isEmpty()) {
            System.out.println(rq.removeMaxPriority());
        }
    }
}
