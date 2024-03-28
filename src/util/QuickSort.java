package util;

import individuo.Individuo;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class QuickSort {
    public void sort(List<Individuo> T, int m) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(T.size() - 1);

        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();

            if (high > low) {
                int pi = partition(T, low, high, m);
                stack.push(low);
                stack.push(pi - 1);
                stack.push(pi + 1);
                stack.push(high);
            }
        }
    }

    private int partition(List<Individuo> T, int low, int high, int m) {
        Individuo pivot = T.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (T.get(j).getObjs()[m] <= pivot.getObjs()[m]) {
                i++;
                Collections.swap(T, i, j);
            }
        }

        Collections.swap(T, i + 1, high);
        return i + 1;
    }
}
