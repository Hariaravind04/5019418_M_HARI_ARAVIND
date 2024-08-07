public class FinancialForecasting {
    public static double predictFutureValue(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        return predictFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        double futureValue = predictFutureValue(initialValue, growthRate, years);
        System.out.println("Predicted future value after " + years + " years: " + futureValue);
    }
}