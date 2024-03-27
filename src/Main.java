import individuo.Individuo;
import problema.ProblemaExemplo;
import util.FNDS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Individuo> pop = new ArrayList<Individuo>();
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{0}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{1}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{2}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{3}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{4}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{5}));

        FNDS fnds = new FNDS();
        fnds.execute(pop);
    }
}