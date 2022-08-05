package ir.ciph3r.mercury.utility;

public class NumeralUtils {

    public static int generateRandomNumber(int min, int max, int current) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static double generateRandomNumber(double min, double max, double current) {
        return (double) ((Math.random() * (max - min)) + min);
    }

    public static float generateRandomNumber(float min, float max, float current) {
        return (float) ((Math.random() * (max - min)) + min);
    }

    public static int generateNonDupeRandomNumber(int min, int max, int current) {
        int generated = (int) ((Math.random() * (max - min)) + min);

        if (generated == current) {
            return generateNonDupeRandomNumber(min, max, current);
        }
        return generated;
    }
}
