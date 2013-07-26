package cn.newtouch.base.base.math;

public class Bubble
{

    public int[] doBubble(int[] arr)
    {

        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++)
        {

            for (int j = i + 1; j < arr.length; j++)
            {

                if (arr[i] < arr[j])
                {

                    temp = arr[i];

                    arr[i] = arr[j];

                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
