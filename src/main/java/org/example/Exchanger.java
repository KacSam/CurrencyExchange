package org.example;

public class Exchanger {
    private static Exchanger exchanger = null;
    private Exchanger(){}
    public static Exchanger getInstance(){
        if (exchanger==null){
            exchanger = new Exchanger();
        }
        return exchanger;
    }
    public double exchange(Currency source, Currency destination, double amount){
        double amountInPLN = amount * source.getRate();
        return amountInPLN / destination.getRate();
    }
}
