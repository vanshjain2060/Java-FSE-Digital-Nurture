package Week1.DSA.FinancialForecasting;

public class ForecastTest {
    public static void main(String[] args) {
        double currValue = 104560;

        double[] rates = {0.10, 0.09, 0.11, 0.08, 0.12};
        int years = rates.length;

        double futureValue = Forecast.predict(currValue, rates, years);
        futureValue = Math.round(futureValue * 100.0) / 100.0;
        
        System.out.println("Future value " + futureValue);
    }
}


/*
 * Output of the current example 
 * Future value 168325.35
 */