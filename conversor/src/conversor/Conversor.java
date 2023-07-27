package conversor;
import javax.swing.*;

public class Conversor {

    public static void main(String[] args) {
        boolean continuar = true;

        do {
            String[] options = {
                    "Conversor de Divisas",
                    "Conversor de Temperatura",
            };

            String selectedOption = (String) JOptionPane.showInputDialog(null,
                    "Seleccione el conversor:",
                    "Menú Inicial",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (selectedOption != null) {
                switch (selectedOption) {
                    case "Conversor de Divisas":
                        mostrarMenuDivisas();
                        break;
                    case "Conversor de Temperatura":
                        convertTemperature();
                        break;
                }
            } else {
                
                continuar = false;
            }
        } while (continuar);
    }

    // mostrar menu
    private static void mostrarMenuDivisas() {
        boolean continuar = true;

        do {
            String[] options = {
                    "Convertir de Pesos Argentinos a Dólar",
                    "Convertir de Dólar a Pesos Argentinos",
                    "Convertir de Pesos Argentinos a Euros",
                    "Convertir de Euros a Pesos Argentinos",
                    "Convertir de Pesos Argentinos a Libras Esterlinas",
                    "Convertir de Libras Esterlinas a Pesos Argentinos",
                    "Convertir de Pesos Argentinos a Yen Japonés",
                    "Convertir de Yen Japonés a Pesos Argentinos",
                    "Convertir de Pesos Argentinos a Won sul-coreano",
                    "Convertir de Won sul-coreano a Pesos Argentinos",
            };

            String selectedOption = (String) JOptionPane.showInputDialog(null,
                    "Seleccione el tipo de conversor o conversores:",
                    "Conversor de Divisas",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (selectedOption != null) {
                switch (selectedOption) {
                    case "Convertir de Pesos Argentinos a Dólar":
                        convertPesosToCurrency("Dólar", 0.00367);
                        break;
                    case "Convertir de Dólar a Pesos Argentinos":
                        convertCurrencyToPesos("Dólar", 272.46);
                        break;
                    case "Convertir de Pesos Argentinos a Euros":
                        convertPesosToCurrency("Euro", 0.00331);
                        break;
                    case "Convertir de Euros a Pesos Argentinos":
                        convertCurrencyToPesos("Euro", 302.13);
                        break;
                    case "Convertir de Pesos Argentinos a Libras Esterlinas":
                        convertPesosToCurrency("Libra Esterlina", 0.00284);
                        break;
                    case "Convertir de Libras Esterlinas a Pesos Argentinos":
                        convertCurrencyToPesos("Libra Esterlina", 352.71);
                        break;
                    case "Convertir de Pesos Argentinos a Yen Japonés":
                        convertPesosToCurrency("Yen Japonés", 0.515);
                        break;
                    case "Convertir de Yen Japonés a Pesos Argentinos":
                        convertCurrencyToPesos("Yen Japonés", 1.94);
                        break;
                    case "Convertir de Pesos Argentinos a Won sul-coreano":
                        convertPesosToCurrency("Won sul-coreano", 4.76);
                        break;
                    case "Convertir de Won sul-coreano a Pesos Argentinos":
                        convertCurrencyToPesos("Won sul-coreano", 0.21);
                        break;
                    default:
                        break;
                }
            } else {
                continuar = false;
            }
        } while (continuar);
    }

    // conversion + restricciones
    private static double getCurrencyAmount(String message) {
        double amount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog(null, message);
                if (input == null) {
                    validInput = true;
                } else {
                    double parsedAmount = Double.parseDouble(input);
                    if (parsedAmount >= 0) {
                        amount = parsedAmount;
                        validInput = true;
                    } else {
                        showMessage("Error", "La cantidad ingresada no es válida.");
                    }
                }
            } catch (NumberFormatException e) {
                showMessage("Error", "La cantidad ingresada no es válida.");
            }
        }

        return amount;
    }

    // conversor de temp + restric
    private static double getTemperatureAmount(String message) {
        double amount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = JOptionPane.showInputDialog(null, message);
                if (input == null) {
                    validInput = true;
                } else {
                    amount = Double.parseDouble(input);
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                showMessage("Error", "La cantidad ingresada no es válida.");
            }
        }

        return amount;
    }

    // metodo de conversion temp
    private static void convertTemperature() {
        Double celsius = getTemperatureAmount("Ingrese la temperatura en Celsius:");
        if (celsius != 0) {
            showMessage("Fahrenheit", "La temperatura en Fahrenheit es: " + (celsius * 9 / 5 + 32) + " °F");
        }
    }

    // conver divisas
    private static void convertPesosToCurrency(String currencyName, double exchangeRate) {
        Double pesos = getCurrencyAmount("Ingrese la cantidad en Pesos Argentinos:");
        if (pesos != 0) {
            double result = pesos * exchangeRate;
            showMessage(currencyName, "Usted tiene " + result + " " + currencyName + ".");
        }
    }

    // conver divisasa
    private static void convertCurrencyToPesos(String currencyName, double exchangeRate) {
        Double currencyAmount = getCurrencyAmount("Ingrese la cantidad en " + currencyName + ":");
        if (currencyAmount != 0) {
            double pesos = currencyAmount / exchangeRate;
            showMessage("Pesos Argentinos", "Usted tiene " + pesos + " Pesos Argentinos.");
        }
    }

    private static void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}




