package util;

import individuo.Individuo;

import java.util.ArrayList;
import java.util.List;

public class CrowdingDistance {
    public void avaliar(List<Individuo> T) {
        int s = T.size();
        for (Individuo ind : T) {
            ind.setD(0);
        }
        Individuo ind0 = T.getFirst();
        int M = ind0.getObjs().length;
        for (int m = 0; m < M; m++) {
            sort(T, m);
            T.getFirst().setD(Double.POSITIVE_INFINITY);
            T.getLast().setD(Double.POSITIVE_INFINITY);
            for (int i = 1; i < s - 1; i++) {
                Individuo antInd = T.get(i - 1);
                Individuo posInd = T.get(i + 1);
                double aux = T.get(i).getD()+((posInd.getObjs()[m] - antInd.getObjs()[m]) / (T.getLast().getObjs()[m] - T.getFirst().getObjs()[m]));
                T.get(i).setD(aux);
            }
        }
        System.out.println();
    }

    private void sort(List<Individuo> T, int m) {
        for (int i = 0; i < T.size() - 1; i++) {
            for (int j = i + 1; j < T.size(); j++) {
                if (T.get(i).getObjs()[m] > T.get(j).getObjs()[m]) {
                    Individuo aux = T.get(i);
                    T.set(i, T.get(j));
                    T.set(i, aux);
                }
            }
        }
    }
}
