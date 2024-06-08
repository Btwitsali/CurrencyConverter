import java.text.DecimalFormat;
import java.util.Scanner;

// Main class handling user input and interaction
public class CurrencyConverter {
    public static void main(String[] args) {
        DecimalFormat d = new DecimalFormat("##.###");
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("***** WELCOME TO THE CURRENCY CONVERTER *****");

            // Creating an array to store different CurrencyConverter objects
            Converter[] c = {
                new PkrToUsdConverter(),
                new UsdToPkrConverter(),
                new PkrToEuroConverter(),
                new EuroToPkrConverter(),
                new UsdToEuroConverter(),
                new EuroToUsdConverter(),
                new PkrToGbpConverter(),
                new GbpToPkrConverter(),
                new UsdToGbpConverter(),
                new GbpToUsdConverter()
                // Add more currency converters here
            };

            // Displaying currency options
            System.out.println("Choose the currency you want to convert from:");
            for (int i = 0; i < c.length; i++) {
                System.out.println((i + 1) + ". " + c[i].getName());
            }
            System.out.print("Your selection: ");
            int ci = s.nextInt() - 1; // Adjusting index to match array

            // Validating user input
            if (ci >= 0 && ci < c.length) {
                Converter cc = c[ci];
                System.out.print("Enter the amount you want to convert: ");
                double a = s.nextDouble();
                double ca = cc.convert(a);
                System.out.println("Converted amount: " + d.format(ca) + " " + cc.getOutputCurrency());
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}

// Interface for currency converters
interface Converter {
    double convert(double a);
    String getName();
    String getOutputCurrency();
}

// Class for converting PKR to USD
class PkrToUsdConverter implements Converter {
    @Override
    public double convert(double p) {
        return p * 0.0035; // Conversion rate from PKR to USD
    }

    @Override
    public String getName() {
        return "Pakistani Rupee (PKR) to United States Dollar (USD)";
    }

    @Override
    public String getOutputCurrency() {
        return "USD";
    }
}

// Class for converting USD to PKR
class UsdToPkrConverter implements Converter {
    @Override
    public double convert(double u) {
        return u * 285.0; // Conversion rate from USD to PKR
    }

    @Override
    public String getName() {
        return "United States Dollar (USD) to Pakistani Rupee (PKR)";
    }

    @Override
    public String getOutputCurrency() {
        return "PKR";
    }
}

// Class for converting PKR to Euro
class PkrToEuroConverter implements Converter {
    @Override
    public double convert(double p) {
        return p * 0.0087; // Conversion rate from PKR to Euro
    }

    @Override
    public String getName() {
        return "Pakistani Rupee (PKR) to Euro";
    }

    @Override
    public String getOutputCurrency() {
        return "Euro";
    }
}

// Class for converting Euro to PKR
class EuroToPkrConverter implements Converter {
    @Override
    public double convert(double e) {
        return e * 115.0; // Conversion rate from Euro to PKR
    }

    @Override
    public String getName() {
        return "Euro to Pakistani Rupee (PKR)";
    }

    @Override
    public String getOutputCurrency() {
        return "PKR";
    }
}

// Class for converting USD to Euro
class UsdToEuroConverter implements Converter {
    @Override
    public double convert(double u) {
        return u * 0.82; // Conversion rate from USD to Euro
    }

    @Override
    public String getName() {
        return "United States Dollar (USD) to Euro";
    }

    @Override
    public String getOutputCurrency() {
        return "Euro";
    }
}

// Class for converting Euro to USD
class EuroToUsdConverter implements Converter {
    @Override
    public double convert(double e) {
        return e * 1.22; // Conversion rate from Euro to USD
    }

    @Override
    public String getName() {
        return "Euro to United States Dollar (USD)";
    }

    @Override
    public String getOutputCurrency() {
        return "USD";
    }
}

// Class for converting PKR to GBP
class PkrToGbpConverter implements Converter {
    @Override
    public double convert(double p) {
        return p * 0.0078; // Conversion rate from PKR to GBP
    }

    @Override
    public String getName() {
        return "Pakistani Rupee (PKR) to British Pound (GBP)";
    }

    @Override
    public String getOutputCurrency() {
        return "GBP";
    }
}

// Class for converting GBP to PKR
class GbpToPkrConverter implements Converter {
    @Override
    public double convert(double g) {
        return g * 128.0; // Conversion rate from GBP to PKR
    }

    @Override
    public String getName() {
        return "British Pound (GBP) to Pakistani Rupee (PKR)";
    }

    @Override
    public String getOutputCurrency() {
        return "PKR";
    }
}

// Class for converting USD to GBP
class UsdToGbpConverter implements Converter {
    @Override
    public double convert(double u) {
        return u * 0.72; // Conversion rate from USD to GBP
    }

    @Override
    public String getName() {
        return "United States Dollar (USD) to British Pound (GBP)";
    }

    @Override
    public String getOutputCurrency() {
        return "GBP";
    }
}

// Class for converting GBP to USD
class GbpToUsdConverter implements Converter {
    @Override
    public double convert(double g) {
        return g * 1.39; // Conversion rate from GBP to USD
    }

    @Override
    public String getName() {
        return "British Pound (GBP) to United States Dollar (USD)";
    }

    @Override
    public String getOutputCurrency() {
        return "USD";
    }
}
