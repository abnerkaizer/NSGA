package problema;

public class ProblemaDTLZ2 extends Problema {

    private final int numberOfObjectives;
    private final int nVars;
    /**
     * Creates a default DTLZ1 problem (7 variables and 3 objectives)
     */

    public ProblemaDTLZ2(int nVars, int numberOfObjectives) {
        this.numberOfObjectives = numberOfObjectives;
        this.nVars = nVars;
    }
    public double[] avaliar(double[] vars) {

        double[] f = new double[numberOfObjectives];
        double[] x = new double[nVars];

        int k = nVars - numberOfObjectives + 1;

        System.arraycopy(vars, 0, x, 0, nVars);


        double g = 0.0;
        for (int i = nVars - k; i < nVars; i++) {
            g += Math.pow(x[i] - 0.5, 2.0);
        }

        for (int i = 0; i < numberOfObjectives; i++) {
            f[i] = 1.0 + g;

            for (int j = 0; j < numberOfObjectives - i - 1; j++) {
                f[i] *= Math.cos(0.5 * Math.PI * x[j]);
            }

            if (i != 0) {
                f[i] *= Math.sin(0.5 * Math.PI * x[numberOfObjectives - i - 1]);
            }
        }

        return f;
    }

    @Override
    public int getNvars() {
        return this.nVars;
    }
}
