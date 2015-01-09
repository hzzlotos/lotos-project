package javacore.enumtest;

public enum Color {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;

    private int    index;

    // 构造方法
    private Color(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index)
    {
        for (Color c : Color.values())
        {
            if (c.getIndex() == index)
            {
                return c.name;
            }
        }
        return null;
    }

    public int getIndex()
    {
        return this.index;
    }
}
