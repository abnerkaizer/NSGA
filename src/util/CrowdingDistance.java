package util;

import individuo.Individuo;

import java.util.List;

public class CrowdingDistance {
    private final QuickSort qs = new QuickSort();
    public void avaliar(List<Individuo> T) {
        int s = T.size();
        for (Individuo ind : T) {
            ind.setD(0);
        }
        Individuo ind0 = T.getFirst();
        int M = ind0.getObjs().length;
        for (int m = 0; m < M; m++) {
            qs.sort(T, m);
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


}
