import algoritmo.NSGA2;
import individuo.IndividuoFactory;
import individuo.IndividuoShafferFactory;

public class Main {
    public static void main(String[] args) {
        IndividuoFactory indFactory = new IndividuoShafferFactory();
        NSGA2 nsga = new NSGA2(-50, 50);
        double startTime = System.currentTimeMillis();
        nsga.execute(indFactory, 20, 1000);
        double endTime = System.currentTimeMillis();
        double tempo = (endTime - startTime);
        System.out.printf("Tempo: %d ms\n", (int) tempo);
    }
}