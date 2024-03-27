import individuo.Individuo;
import problema.ProblemaExemplo;
import util.CrowdingDistance;
import util.FNDS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Individuo> f = new ArrayList<Individuo>();
        f.add(new Individuo(new ProblemaExemplo(), new double[]{6}));
        f.add(new Individuo(new ProblemaExemplo(), new double[]{7}));
        f.add(new Individuo(new ProblemaExemplo(), new double[]{8}));
        f.add(new Individuo(new ProblemaExemplo(), new double[]{9}));
        CrowdingDistance cd = new CrowdingDistance();
        cd.avaliar(f);
    }
}