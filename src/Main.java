import algoritmo.NSGA2;
import individuo.IndividuoDTLZ1Factory;
import individuo.IndividuoDTLZ2Factory;
import individuo.IndividuoFactory;
import individuo.IndividuoShaffeFactory;

public class Main {
    public static void main(String[] args) {
        IndividuoFactory indFactory = new IndividuoDTLZ1Factory(7,3);
        NSGA2 nsga = new NSGA2(0, 1);
        double startTime = System.currentTimeMillis();
        nsga.execute(indFactory, 21, 1000);
        double endTime = System.currentTimeMillis();
        double tempo = (endTime - startTime);
        System.out.printf("Tempo: %d ms\n", (int) tempo);
    }
}