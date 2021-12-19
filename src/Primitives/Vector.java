package Primitives;

public class Vector
{

    private Point3D head;

    public Vector(Point3D point)
    {
        head=new Point3D(point);
    }
    public Vector(Vector vec)
    {
        head=new Point3D(vec.getHead());
    }
    public Vector(Point3D p1, Point3D p2){

        this(new Point3D(p2.getX().getCoordinate() - p1.getX().getCoordinate(),
                p2.getY().getCoordinate() - p1.getY().getCoordinate(),
                p2.getZ().getCoordinate() - p1.getZ().getCoordinate()));

    }

    public Vector()
    {
        head=new Point3D();
    }
    public Point3D getHead()
    {
        return head;
    }

    public void setHead(Point3D head1)
    {
        this.head = new Point3D(head1);
    }
    public void add(Vector vector)
    {
        Coordinate a =new Coordinate(this.getHead().getX().getCoordinate()+vector.getHead().getX().getCoordinate());
        head.setX(a);
        Coordinate b =new Coordinate(this.getHead().getY().getCoordinate()+vector.getHead().getY().getCoordinate());
        head.setY(b);
        Coordinate c =new Coordinate(this.getHead().getZ().getCoordinate()+vector.getHead().getZ().getCoordinate());
        head.setZ(c);
    }
    public void substract (Vector vector )
    {
        Coordinate a =new Coordinate(this.getHead().getX().getCoordinate()-vector.getHead().getX().getCoordinate());
        head.setX(a);
        Coordinate b =new Coordinate(this.getHead().getY().getCoordinate()-vector.getHead().getY().getCoordinate());
        head.setY(b);
        Coordinate c =new Coordinate(this.getHead().getZ().getCoordinate()-vector.getHead().getZ().getCoordinate());
        head.setZ(c);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((head == null) ? 0 : head.hashCode());
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
        Vector other = (Vector) obj;
        if (head == null) {
            if (other.head != null)
                return false;
        } else if (!head.equals(other.head))
            return false;
        return true;
    }
    @Override
    public String toString()
    {
        return "Vector [head=" + head + "]";
    }
    public void scale(double scalingFactor)
    {
        Coordinate a=new Coordinate (this.head.getX().getCoordinate());
        a.setCoordinate(a.getCoordinate()*scalingFactor);
        this.head.setX(a);
        Coordinate b=new Coordinate (this.head.getY().getCoordinate());
        b.setCoordinate(b.getCoordinate()*scalingFactor);
        this.head.setY(b);
        Coordinate c=new Coordinate (this.head.getZ().getCoordinate());
        c.setCoordinate(c.getCoordinate()*scalingFactor);
        this.head.setZ(c);
    }
    public double length()
    {
        Coordinate myX=this.head.getX();
        Coordinate myY=this.head.getY();
        Coordinate myZ=this.head.getZ();
        double ans=Math.sqrt(Math.pow(myX.getCoordinate(), 2)+Math.pow(myY.getCoordinate(), 2)+Math.pow(myZ.getCoordinate(), 2));
        return (ans);
    }
    public void normalize()
    {
        double myLength=this.length();
        this.scale(1/myLength);
    }
    public Vector crossProduct (Vector vector)
    {
        double u1=this.head.getX().getCoordinate();
        double u2=this.head.getY().getCoordinate();
        double u3=this.head.getZ().getCoordinate();
        double v1=vector.head.getX().getCoordinate();
        double v2=vector.head.getY().getCoordinate();
        double v3=vector.head.getZ().getCoordinate();
        Coordinate n1=new Coordinate (u2*v3-u3*v2);
        Coordinate n2=new Coordinate(u3*v1-u1*v3);
        Coordinate n3=new Coordinate(u1*v2-u2*v1);
        if(n1.getCoordinate()==(-0.0))
            n1.setCoordinate(0.0);
        if(n2.getCoordinate()==(-0.0))
            n2.setCoordinate(0.0);
        if(n3.getCoordinate()==(-0.0))
            n3.setCoordinate(0.0);
        Point3D point=new Point3D(n1,n2,n3);
        Vector normal=new Vector(point);
        return normal;
    }
    public double dotProduct(Vector vector)
    {
        double u1=this.head.getX().getCoordinate();
        double u2=this.head.getY().getCoordinate();
        double u3=this.head.getZ().getCoordinate();
        double v1=vector.head.getX().getCoordinate();
        double v2=vector.head.getY().getCoordinate();
        double v3=vector.head.getZ().getCoordinate();
        return (u1*v1+u2*v2+u3*v3);
    }
    public double magnitude() //the distance from the reshit(0,0,0)
    {
        Point3D p0 = new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(0));
        double x = head.distance(p0);
        return x;
    }

}
