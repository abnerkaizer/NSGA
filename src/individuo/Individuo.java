package individuo;

import problema.Problema;

public class Individuo {
    private double[] vars;
    private double[] objs;
    private Problema problema;

    public Individuo(Problema problema, double[] vars) {
        this.problema = problema;
        this.vars = vars;
    }

    public double[] getObjs() {
        if (objs == null) {
            objs = problema.avaliar(this.vars);
        }
        return objs;
    }
    public String toString(){
        String ret = "Individuo - vars[";
        for (int i = 0; i < vars.length; i++) {
            if (i==vars.length-1){
                ret += vars[i]+"]";
            }else {
                ret += vars[i]+",";
            }
        }
        ret += " - obs [";
        for (int i = 0; i < objs.length; i++) {
            if (i==objs.length-1){
                ret += objs[i]+"]";
            }else {
                ret += objs[i]+",";
            }
        }
        return ret;
    }
}
