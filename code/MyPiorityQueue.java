package LinkedList_final;

import java.util.ArrayList;

public class MyPriorityQueue<E> implements PriorityQueue<E> {

    private class Entry {
        double priority;
        E element;
        Entry(double p, E e) {
            priority = p;
            element = e;
        }
    }

    private ArrayList<Entry> list;

    public MyPriorityQueue() {
        list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void insert(double priority, E element) {
        list.add(new Entry(priority, element));
    }

    @Override
    public E removeMaxPriority() {
        if (isEmpty()) return null;
        int maxIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).priority > list.get(maxIndex).priority) {
                maxIndex = i;
            }
        }
        E result = list.get(maxIndex).element;
        list.remove(maxIndex);
        return result;
    }

    // test
    public static void main(String[] args) {
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        double[] priorities = {3,4,2,7,6,8,5,9,1,0};

        for (int i = 1; i <= 10; i++) {
            pq.insert(priorities[i-1], i);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.removeMaxPriority());
        }
    }
}
