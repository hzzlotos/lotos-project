package net.newtouch;

public class MatrixMultiplicationTest
{
    public static void main(String[] args)
    {
        int[][] one = new int[2][3];
        one[0][0] = 1;

        double a = 1000000000;
        int ccc = 0;
        int index = 0;
        while (index < a)
        {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y <= 1)
            {
                ccc++;
            }
            index++;
        }
        System.out.println((ccc / a) * 4);
    }
}