package org.example;

import java.util.Scanner;

public class CurrencyUI {

    private Exchanger exchanger;
    private CurrencyCollection currencyCollection;


    public CurrencyUI(){
        this.exchanger= Exchanger.getInstance();
        this.currencyCollection = new CurrencyCollection();
    }



    public void menu(){
        DataProvider dataProvider = DataProvider.getInstance();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        try {
            String xmlData = dataProvider.getData("https://api.nbp.pl/api/exchangerates/tables/a/");
            parser.parse(xmlData, currencyCollection);
        } catch (Exception e){
            System.out.println("Error retrieving data: " + e.getMessage());
            return;
        }
        int choice = 0;

        while (choice != 3) {
            System.out.println("Menu:");
            System.out.println("1. Display all currencies");
            System.out.println("2. Currency exchange");
            System.out.println("3. Exit program");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllCurrencies();
                    break;
                case 2:
                    exchange();
                    delay();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
    public void exchange() {
        Scanner scanner = new Scanner(System.in);

        String sourceCurrencyCode = getCurrencyCode(scanner, "source");
        double amount = getInputAmount(scanner);
        String targetCurrencyCode = getCurrencyCode(scanner, "target");

        Currency sourceCurrency = chooseCurrency(sourceCurrencyCode);
        Currency targetCurrency = chooseCurrency(targetCurrencyCode);

        if (sourceCurrency != null && targetCurrency != null) {
            double result = exchanger.exchange(sourceCurrency, targetCurrency, amount);
            System.out.printf("%.2f %s to %.2f %s\n", amount, sourceCurrency.getCode(), result, targetCurrency.getCode());
        } else {
            System.out.println("Invalid currency code. Please try again.");
            exchange();

        }
    }
    public void displayAllCurrencies() {
        System.out.println("Available currencies:");
        for (Currency currency : currencyCollection.getCurrencies()) {
            System.out.println(currency.getName() + ": " + currency.getCode() + " - " + currency.getRate());
        }
    }

    private double getInputAmount(Scanner scanner) {
        double amount = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter amount in source currency: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                valid = amount > 0;
            } else {
                System.out.println("Please enter a valid amount.");
                scanner.next();
            }
        }
        return amount;
    }

    private String getCurrencyCode(Scanner scanner, String type) {
        System.out.print("Enter " + type + " currency code: ");
        return scanner.next().toUpperCase();
    }

    private Currency chooseCurrency(String code){
        for (Currency currency : currencyCollection.getCurrencies()) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return currency;
            }
        }
        return null;
    }

    private void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error during delay: " + e.getMessage());
        }
    }

}
