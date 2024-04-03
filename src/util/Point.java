package util;

import individuo.Individuo;

import java.util.List;

public class Point {
    private double[] objs;
    private List<Point> S;
    private Point[] s;
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

    public void setObjs(double[] objs) {
        this.objs = objs;
    }

    public void setS(Point[] s) {
        this.s = s;
    }

    public void setInd(Individuo ind) {
        this.ind = ind;
    }

    public void setS(List<Point> s) {
        S = s;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String toString() {
        return ind.toString() + " n: "+n+" rank: "+rank;
    }
}
