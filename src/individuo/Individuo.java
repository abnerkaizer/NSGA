package individuo;

import problema.Problema;


public class Individuo {
    private double[] vars;
    private double[] objs;
    private final Problema problema;
    private double d;


    public Individuo(Problema problema, double[] vars) {
        this.problema = problema;
        this.vars = vars;
    }

    public double[] getVars() {
        return vars;
    }

    public void setVars(double[] vars) {
        this.vars = vars;
    }

    public double[] getObjs() {
        if (this.objs == null) {
            this.objs = problema.avaliar(this.vars);
        }
        return this.objs;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("Individuo - vars[");
        for (int i = 0; i < vars.length; i++) {
            if (i == vars.length - 1) {
                ret.append(vars[i]).append("]");
            } else {
                ret.append(vars[i]).append(",");
            }
        }
        ret.append(" - obs [");
        for (int i = 0; i < objs.length; i++) {
            if (i == objs.length - 1) {
                ret.append(objs[i]).append("]");
            } else {
                ret.append(objs[i]).append(",");
            }
        }
        ret.append(" - d = ").append(d);

        return ret.toString();
    }
}
