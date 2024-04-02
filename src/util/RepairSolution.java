package util;

public class RepairSolution {
    public static double repair(double value, double lower, double upper){
        if (value < lower){
            value = lower;
        } else if (value > upper) {
            value  = upper;
        }
        return value;
    }
}
