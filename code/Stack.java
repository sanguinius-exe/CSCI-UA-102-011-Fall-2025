package LinkedList_final;

public class Stack<E> extends MyPriorityQueue<E> {
    private long counter = 0;

    public void push(E element) {
        insert(counter++, element);  // newer pushes get higher priority
    }

    public E pop() {
        return removeMaxPriority();
    }

    public boolean isEmptyStack() {
        return isEmpty();
    }

    // test
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        while (!stack.isEmptyStack()) {
            System.out.println(stack.pop());  // should print C, B, A
        }
    }
}
