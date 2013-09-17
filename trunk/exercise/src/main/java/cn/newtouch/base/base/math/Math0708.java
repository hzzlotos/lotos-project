package cn.newtouch.base.base.math;

import java.util.List;

public class Math0708
{

    /*
     * 有一个int型数组，数组长度为l（l>0），数组里成员的值互不相等
     * 现要从中取n个数（n的值要尽可能小），使其总和大等于指定值m（若无法等于m，则要求尽可能地接近）
     * 
     * 如：int[] srcArray={1,2,3}; m=6 返回 {3,3} int[] srcArray={2,3}; m=1 返回 {2}
     * int[] srcArray={2,3,4}; m=9 返回{2,3,4}或{3,3,3}
     */

    private List<Integer[]> result;

    public List<Integer[]> math0708(int[] array, int m)
    {

        Bubble bubble = new Bubble();

        array = bubble.doBubble(array);

        return result;
    }

    private void Earthbags(int[] array, int m, int index, int sum,
            Integer[] indexSum, Integer[] difference)
    {

        index = index + 1;

        // for () {

        // }

        int number = Math.abs(m - sum - array[index]);

        if (Math.abs(m - sum) == 0)
        {

        }
        else
            if (number < Math.abs(m - sum))
            {

                sum = sum + array[index];

                for (int i = 0; i < indexSum.length; i++)
                {

                    if (null == indexSum[i])
                    {

                        indexSum[i] = index;

                        break;
                    }
                }
            }
    }
}
