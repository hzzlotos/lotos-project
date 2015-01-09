package javacore.local;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocalTest
{

    public static void main(String[] args)
    {
        // test();
        numTest();
    }

    private static void numTest()
    {
        try
        {

            NumberFormat fmt = NumberFormat.getNumberInstance();
            Number input = fmt.parse("123456.78");
            System.out.println(input.doubleValue());
            System.out.println("==============================");
            Locale germanGermany = new Locale("de", "DE");
            fmt = NumberFormat.getCurrencyInstance(germanGermany);
            input = fmt.parse("132.456,78 €");
            System.out.println(input.doubleValue());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    private static void test()
    {
        // Locale german = new Locale("de");
        Locale germanGermany = new Locale("de", "DE");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(germanGermany);
        double num = 132456.78;
        System.out.println(fmt.format(num));
        // Locale germanSwitzerland = new Locale("de","CH");
        Locale china = Locale.CHINA;
        // Locale chinese = Locale.CHINESE;
        System.out.println(china.getDisplayName(Locale.GERMAN));
        System.out.println(Locale.GERMAN.getDisplayName());
    }
}