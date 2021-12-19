package Primitives;

public class Coordinate
{
    private double coordinate1;
    public Coordinate()
    {
        coordinate1=0;
    }
    public Coordinate(double coordinate)
    {
        this.coordinate1 = coordinate;
    }
    public Coordinate(Coordinate c)
    {
        this.coordinate1 = c.getCoordinate();
    }
    public double getCoordinate()
    {
        double c= coordinate1;
        return c;
    }

    public void setCoordinate(double coordinate)
    {
        this.coordinate1 = coordinate;
    }
    public void add(Coordinate y)
    {
        this.setCoordinate(this.getCoordinate()+y.getCoordinate());

    }
    public void substract(Coordinate y)
    {
        this.setCoordinate(this.getCoordinate()-y.getCoordinate());

    }
    public int compareTo(Coordinate coordinate)
    {
        return Double.compare(this.coordinate1, coordinate.getCoordinate());
    }
    @Override
    public String toString()
    {
        return "Coordinate [coordinate=" + coordinate1 + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(coordinate1);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (Double.doubleToLongBits(coordinate1) != Double.doubleToLongBits(other.coordinate1))
            return false;
        return true;
    }


}
