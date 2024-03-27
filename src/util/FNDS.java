package util;

import java.util.List;
import java.util.ArrayList;

import individuo.Individuo;

public class FNDS {
    public List<List<Individuo>> execute(List<Individuo> indList) {
        List<Ponto> P = new ArrayList<Ponto>(indList.size());
        for (int i = 0; i < indList.size(); i++) {
            Individuo ind = indList.get(i);
            Ponto p = new Ponto(ind);
            P.add(p);
        }
        int n;
        List<List<Ponto>> F = new ArrayList<List<Ponto>>();
        List<Ponto> front1 = new ArrayList<Ponto>();
        //Parte 1
        for (int i = 0; i < P.size(); i++) {
            Ponto p = P.get(i);
            p.setS(new ArrayList<Ponto>());
            p.setN(0);

            for (int j = 0; j < P.size(); j++) {

                if (i != j) {
                    Ponto q = P.get(j);
                    if (domina(p, q)) {
                        p.getS().add(q);
                    } else if (domina(q, p)) {
                        n = p.getN();
                        p.setN(++n);
                    }
                }
            }
            if (p.getN() == 0) {
                p.setRank(1);
                front1.add(p);
            }
        }
        F.add(front1);

        //Parte 2

        int i = 0;
        List<Ponto> Fi = F.get(i);
        while (!Fi.isEmpty()) {
            List<Ponto> Q = new ArrayList<Ponto>();
            for (Ponto p : Fi) {
                List<Ponto> Sp = p.getS();
                for (Ponto q : Sp) {
                    n = q.getN();
                    q.setN(--n);
                    if (q.getN() == 0) {
                        q.setRank(i + 1);
                        Q.add(q);
                    }
                }
            }
            i++;
            F.add(Q);
            Fi = Q;
        }
        List<List<Individuo>> ret = new ArrayList<List<Individuo>>();
        for (i = 0; i < F.size(); i++) {
            Fi = F.get(i);
            if (!Fi.isEmpty()) {
                List<Individuo> Find = new ArrayList<Individuo>();
                for (int j = 0; j < Fi.size(); j++) {
                    Ponto p = Fi.get(j);
                    Individuo ind = p.getInd();
                    Find.add(ind);
                }
                ret.add(Find);
            }
        }
        return ret;
    }

    public boolean domina(Ponto p1, Ponto p2) {
        double[] obj1 = p1.getObjs();
        double[] obj2 = p2.getObjs();
        for (int i = 0; i < obj1.length; i++) {
            if (obj2[i] < obj1[i]) {
                return false;
            }
        }
        for (int i = 0; i < obj1.length; i++) {
            if (obj1[i] < obj2[i]) {
                return true;
            }
        }
        return true;
    }
}
