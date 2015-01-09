package javacore.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalTest
{
    public static void main(String[] args)
    {
        BigDecimal bigDecimal1 = new BigDecimal(10.0F), bigDecimal3;
        BigDecimal bigDecimal2 = new BigDecimal(5.0D);
        bigDecimal3 = bigDecimal1.add(bigDecimal2);// +
        System.out.println(bigDecimal3.doubleValue());

        bigDecimal3 = bigDecimal1.subtract(bigDecimal2);// -
        System.out.println(bigDecimal3.doubleValue());

        bigDecimal3 = bigDecimal1.multiply(bigDecimal2);// *
        System.out.println(bigDecimal3.doubleValue());

        bigDecimal3 = bigDecimal1.divide(bigDecimal2);// /
        System.out.println(bigDecimal3.doubleValue());

        System.out.println(bigDecimal1.compareTo(bigDecimal2));

        System.out.println(bigDecimal2.compareTo(bigDecimal1));
    }
}
