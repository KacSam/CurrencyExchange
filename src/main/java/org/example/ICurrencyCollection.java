package org.example;

import java.util.List;

public interface ICurrencyCollection {
    public void add(Currency curr);
    public List<Currency> getCurrencies();
    public void delete(Currency curr);

    public void modify(Currency curr);
}
