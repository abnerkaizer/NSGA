package util;

import java.util.List;
import java.util.ArrayList;
import individuo.Individuo;

public class FNDS {
    public List<List<Individuo>> execute(List<Individuo> indList) {
        List<Point> P = new ArrayList<Point>(indList.size());
        for (int i = 0; i < indList.size(); i++) {
            Individuo ind = indList.get(i);
            Point p = new Point(ind);
            P.add(p);
        }
        int n;
        List<List<Point>> F = new ArrayList<List<Point>>();
        List<Point> front1 = new ArrayList<Point>();
        //Parte 1
        for (int i = 0; i < P.size(); i++) {
            Point p = P.get(i);
            p.setS(new ArrayList<Point>());
            p.setN(0);

            for (int j = 0; j < P.size(); j++) {

                if (i != j) {
                    Point q = P.get(j);
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
        List<Point> Fi = F.get(i);
        while (!Fi.isEmpty()) {
            List<Point> Q = new ArrayList<Point>();
            for (Point p : Fi) {
                List<Point> Sp = p.getS();
                for (Point q : Sp) {
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
                    Point p = Fi.get(j);
                    Individuo ind = p.getInd();
                    Find.add(ind);
                }
                ret.add(Find);
            }
        }
        return ret;
    }

    public boolean domina(Point p1, Point p2) {
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
