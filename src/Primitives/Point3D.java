package Primitives;

public class Point3D extends Point2D
{
    private Coordinate z;
    public Point3D( Coordinate x1, Coordinate y1, Coordinate z1)
    {
        super(x1,y1);
        z= new Coordinate(z1);
    }
    public Point3D( double x1, double y1, double z1)
    {
        super(x1,y1);
        z= new Coordinate(z1);
    }

    public Point3D()
    {
        super();
        z=new Coordinate();
    }
    public Point3D(Point3D point)
    {
        super(point.getX(), point.getY());
        z = new Coordinate(point.getZ());

        //this.setX(point.getX());
        //this.setY(point.getY());
        //this.setZ(point.getZ());
        // TODO Auto-generated constructor stub
    }

    public Coordinate getZ()
    {
        return z;
    }

    public void setZ(Coordinate s)
    {
        this.z = new Coordinate(s);
    }
    public int compareTo(Point3D point3D)
    {

        if (((Point2D)this).compareTo((Point2D)point3D) == 0)
            if (this.z.compareTo(point3D.z) == 0)
                return 0;
        return 1;
    }



    public void add(Point3D point)
    {
        Coordinate a =new Coordinate(this.getX().getCoordinate()+point.getX().getCoordinate());
        this.setX(a);
        Coordinate b =new Coordinate(this.getY().getCoordinate()+point.getY().getCoordinate());
        this.setY(b);
        Coordinate c =new Coordinate(this.getZ().getCoordinate()+point.getZ().getCoordinate());
        this.setZ(c);

    }
    public void substract(Point3D point)
    {
        Coordinate a =new Coordinate(this.getX().getCoordinate()-point.getX().getCoordinate());
        this.setX(a);
        Coordinate b =new Coordinate(this.getY().getCoordinate()-point.getY().getCoordinate());
        this.setY(b);
        Coordinate c =new Coordinate(this.getZ().getCoordinate()-point.getZ().getCoordinate());
        this.setZ(c);

    }
    public double distance(Point3D point)
    {
        return Math.sqrt((Math.pow((this.getX().getCoordinate()-point.getX().getCoordinate()),2)+
                Math.pow((this.getY().getCoordinate()-point.getY().getCoordinate()),2)+
                Math.pow((this.getZ().getCoordinate()-point.getZ().getCoordinate()),2)));
    }
    @Override
    public String toString()
    {
        return super.toString()+ "Point3D [z=" + z + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((z == null) ? 0 : z.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point3D other = (Point3D) obj;
        if (z == null) {
            if (other.z != null)
                return false;
        } else if (!z.equals(other.z))
            return false;
        return true;
    }

}
