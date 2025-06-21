package Week1.DSA.FinancialForecasting;

public class Forecast {
    public static double predict(double value, double[] rates, int years) {
        if(years == 0) return value;

        double getPrev = predict(value, rates, years-1);

        return getPrev * (1 + rates[years-1]); 
    }
}
