package Primitives;
public class Point2D implements Comparable<Point2D>
{
    private Coordinate x;
    private Coordinate y;
    public Point2D(Coordinate xx, Coordinate yy)
    {
        this.x=new Coordinate(xx);
        this.y=new Coordinate(yy);
    }
    public Point2D(double xx, double yy)
    {
        this.x=new Coordinate(xx);
        this.y=new Coordinate(yy);
    }
    public Point2D()
    {
        this.x=new Coordinate();
        this.y=new Coordinate();
    }

    public Coordinate getX()
    {
        return x;
    }
    public void setX(Coordinate xx)
    {
        this.x = new Coordinate(xx);
    }
    public Coordinate getY()
    {
        return y;
    }
    public void setY(Coordinate yy)
    {
        this.y = new Coordinate(yy);
    }
    @Override
    public String toString()
    {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }
    @Override
    public int compareTo(Point2D point2D) {
        if (this.x.compareTo(point2D.x) == 0 &&
                this.y.compareTo(point2D.y) == 0)
            return 0;
        return 1;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point2D other = (Point2D) obj;
        if (x == null) {
            if (other.x != null)
                return false;
        } else if (!x.equals(other.x))
            return false;
        if (y == null) {
            if (other.y != null)
                return false;
        } else if (!y.equals(other.y))
            return false;
        return true;
    }

}
