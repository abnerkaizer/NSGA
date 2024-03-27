package util;

import individuo.Individuo;

import java.util.List;

public class Ponto {
    private double[] objs;
    private List<Ponto> S;
    private Ponto[] s;
    private int n;


    private int rank;
    private Individuo ind;

    public Ponto(Individuo ind) {
        this.ind = ind;
        this.objs = ind.getObjs();
    }

    public Individuo getInd() {
        return ind;
    }

    public List<Ponto> getS() {
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

    public void setS(Ponto[] s) {
        this.s = s;
    }

    public void setInd(Individuo ind) {
        this.ind = ind;
    }

    public void setS(List<Ponto> s) {
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
