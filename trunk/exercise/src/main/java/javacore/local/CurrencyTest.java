package javacore.local;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyTest
{

    public static void main(String[] args)
    {
        // NumberFormat dollarfFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat euroFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        euroFormatter.setCurrency(Currency.getInstance("EUR"));
        System.out.println("=======================" + euroFormatter.format(12345678));
    }
}