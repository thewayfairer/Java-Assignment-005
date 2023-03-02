import java.util.Scanner;

public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    public static double convertC2F(double celsius) {
        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {
        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }

    public static double convertK2F(double kelvin) {
        double celsius = convertK2C(kelvin);
        double fahrenheit = convertC2F(celsius);
        return fahrenheit;
    }

    public static double getTemp(String unit) {
        System.out.printf("%-40s : ", String.format("Please enter °%s temperature to convert", unit));
        return Double.parseDouble(input.nextLine());
    }

    public static String getUnitChoice() {
        System.out.printf("%-4s : %40s%n", "C).", "To convert a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        return input.nextLine();
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("Choose the temperature unit to convert from:");
            String fromUnit = getUnitChoice();
            if(fromUnit.equals("Q")) {
                break;
            }

            System.out.println("Choose the temperature unit to convert to:");
            String toUnit = getUnitChoice();
            if(toUnit.equals("Q")) {
                break;
            }

            System.out.println("Enter the temperature value:");
            double tempValue = Double.parseDouble(input.nextLine());

            double result = 0.0;

            switch(fromUnit) {
                case "C":
                    switch(toUnit) {
                        case "F":
                            result = convertC2F(tempValue);
                            break;
                        case "K":
                            result = convertC2K(tempValue);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;
                case "F":
                    switch(toUnit) {
                        case "C":
                            result = convertF2C(tempValue);
                            break;
                        case "K":
                            result = convertF2K(tempValue);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;
                case "K":
                    switch(toUnit) {
                        case "C":
                            result = convertK2C(tempValue);
                            break;
                        case "F":
                            result = convertK2F(tempValue);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            System.out.printf("Result: %.6f°%s is %.6f°%s%n", tempValue, fromUnit, result, toUnit);
        }
    }
}
