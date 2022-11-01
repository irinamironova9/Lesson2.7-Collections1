package part2;

import java.util.*;

public class CashRegister {
    private final static Random RANDOM = new Random();
    private final List<Queue<String>> registers;

    public CashRegister() {
        registers = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            registers.add(new LinkedList<>());
        }
    }

    public void addToQueue(String name) {
        if (allRegistersFull()) {
            System.out.println("Позовите Галю.");
        } else {
            Queue<String> minQueue = selectMinQueue();
            minQueue.add(name);
        }
    }

    public void remove() {
//        this.registers.get(RANDOM.nextInt(0, registers.size())).poll();
    }

    private boolean allRegistersFull() {
        for (Queue<String> queue : registers) {
            if (queue.size() < 5) {
                return false;
            }
        }
        return true;
    }

    private Queue<String> selectMinQueue() {
        int min = Integer.MAX_VALUE;
        Queue<String> minQueue = null;
        for (Queue<String> queue : registers) {
            if (queue.size() < min) {
                min = queue.size();
                minQueue = queue;
            }
        }
        return minQueue;
    }
}
