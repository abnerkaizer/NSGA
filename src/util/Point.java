package util;

import individuo.Individuo;

import java.util.List;

public class Point {
    private final double[] objs;
    private List<Point> S;
    private int n;


    private int rank;
    private Individuo ind;

    public Point(Individuo ind) {
        this.ind = ind;
        this.objs = ind.getObjs();
    }

    public Individuo getInd() {
        return ind;
    }

    public List<Point> getS() {
        return S;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double[] getObjs() {
        return objs;
    }

    public void setS(List<Point> s) {
        S = s;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String toString() {
        return ind.toString() + " n: "+n+" rank: "+rank;
    }
}
