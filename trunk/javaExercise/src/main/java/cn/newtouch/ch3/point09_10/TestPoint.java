package cn.newtouch.ch3.point09_10;

class Point
{
    double x, y, z;

    Point(double _x, double _y, double _z)
    {
        this.x = _x;
        this.y = _y;
        this.z = _z;
    }

    void setX(double _x)
    {
        this.x = _x;
    }

    double getDistance(Point p)
    {
        return (this.x - p.x) * (this.x - p.x) + (this.y - p.y)
                * (this.y - p.y) + (this.z - p.z) * (this.z - p.z);
    }

}

public class TestPoint
{
    public static void main(String[] args)
    {
        Point p = new Point(1.0, 2.0, 3.0);
        Point p1 = new Point(0.0, 0.0, 0.0);
        System.out.println(p.getDistance(p1));

        p.setX(5.0);
        System.out.println(p.getDistance(new Point(1.0, 1.0, 1.0)));
    }
}