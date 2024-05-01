package util;

import individuo.Individuo;
import java.util.List;

public class CrowdingDistance {
    private final QuickSort qs = new QuickSort();

    public void avaliar(List<Individuo> individuos) {
        int s = individuos.size();
        for (Individuo ind : individuos) {
            ind.setD(0);
        }
        Individuo ind0 = individuos.getFirst();
        int M = ind0.getObjs().length;
        for (int m = 0; m < M; m++) {
            qs.sort(individuos, m);
            individuos.getFirst().setD(Double.POSITIVE_INFINITY);
            individuos.getLast().setD(Double.POSITIVE_INFINITY);
            for (int i = 1; i < s - 1; i++) {
                Individuo antInd = individuos.get(i - 1);
                Individuo posInd = individuos.get(i + 1);
                double aux = individuos.get(i).getD() + ((posInd.getObjs()[m] - antInd.getObjs()[m]) / (individuos.getLast().getObjs()[m] - individuos.getFirst().getObjs()[m]));
                individuos.get(i).setD(aux);
            }
        }
    }
}
