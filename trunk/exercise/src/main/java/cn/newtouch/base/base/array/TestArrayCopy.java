package cn.newtouch.base.base.array;

public class TestArrayCopy
{
    public static void main(String args[])
    {
        String[] s = { "Mircosoft", "IBM", "Sun", "Oracle", "Apple" };
        String[] sBak = new String[6];
        System.arraycopy(s, 0, sBak, 0, s.length);

        for (String element : sBak)
        {
            System.out.print(element + " ");
        }

        System.out.println();
        int[][] intArray = { { 1, 2 }, { 1, 2, 3 }, { 3, 4 } };
        int[][] intArrayBak = new int[3][];
        System.arraycopy(intArray, 0, intArrayBak, 0, intArray.length);
        intArrayBak[2][1] = 100;

        for (int[] element : intArray)
        {
            for (int j = 0; j < element.length; j++)
            {
                System.out.print(element[j] + "  ");
            }
            System.out.println();
        }
    }
}
