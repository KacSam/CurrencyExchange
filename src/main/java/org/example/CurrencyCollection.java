package org.example;

import java.util.ArrayList;
import java.util.List;

public class CurrencyCollection implements ICurrencyCollection{

    private ArrayList<Currency> currencyArray;

    public CurrencyCollection() {
        this.currencyArray = new ArrayList<>();
        currencyArray.add(new Currency("PLN", "zloty", 1.0));
    }
    @Override
    public void add(Currency curr) {
        currencyArray.add(curr);
    }

    @Override
    public List<Currency> getCurrencies() {
        return currencyArray;
    }

    @Override
    public void delete(Currency curr) {
        currencyArray.remove(curr);

    }

    @Override
    public void modify(Currency curr) {

    }
}
