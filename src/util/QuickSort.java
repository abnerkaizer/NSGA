package util;

import individuo.Individuo;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class QuickSort {
    public void sort(List<Individuo> individuos, int m) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(individuos.size() - 1);

        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();

            if (high > low) {
                int pi = partition(individuos, low, high, m);
                stack.push(low);
                stack.push(pi - 1);
                stack.push(pi + 1);
                stack.push(high);
            }
        }
    }

    private int partition(List<Individuo> individuos, int low, int high, int m) {
        Individuo pivot = individuos.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (individuos.get(j).getObjs()[m] < pivot.getObjs()[m]) {
                i++;
                Collections.swap(individuos, i, j);
            }
        }

        Collections.swap(individuos, i + 1, high);
        return i + 1;
    }
    public void sort(List<Individuo> individuos) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(individuos.size() - 1);

        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();

            if (high > low) {
                int pi = partition(individuos, low, high);
                stack.push(low);
                stack.push(pi - 1);
                stack.push(pi + 1);
                stack.push(high);
            }
        }
    }

    private int partition(List<Individuo> individuos, int low, int high) {
        Individuo pivot = individuos.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (individuos.get(j).getD() > pivot.getD()) {
                i++;
                Collections.swap(individuos, i, j);
            }
        }

        Collections.swap(individuos, i + 1, high);
        return i + 1;
    }
}
