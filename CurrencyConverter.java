import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        System.out.print("Enter the amount in USD: $");
        double usdAmount = scanner.nextDouble();

        double conversionRate = 0.85; // 1 USD = 0.85 EUR
        double eurAmount = usdToEur(usdAmount, conversionRate);

        System.out.println("$" + usdAmount + " USD is equivalent to €" + eurAmount + " EUR");

        scanner.close();
    }

    public static double usdToEur(double usdAmount, double conversionRate) {
        return usdAmount * conversionRate;
    }

}
    

