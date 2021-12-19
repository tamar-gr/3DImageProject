package Primitives;

public class Ray
{
    private Point3D POO;
    private Vector direction;
    public Ray()
    {
        super();
    }
    public Ray(Point3D pOO, Vector direction)
    {
        super();
        this.POO =new Point3D(pOO);
        this.direction = new Vector(direction);
    }
    public Ray(Ray r)
    {
        super();
        this.POO =new Point3D(r.getPOO());
        this.direction = new Vector(r.getDirection());
    }

    public Vector getDirection()
    {
        //Vector v= new Vector(direction);
        return direction;//v//
    }
    public void setDirection(Vector direction1)
    {
        this.direction = new Vector(direction1);
    }
    public Vector getDirectionNew()
    {
        //Vector v= new Vector(direction);
        return new Vector(direction);//v//
    }
    public Point3D getPOO()
    {
        //Point3D p= new Point3D(POO);
        return POO;//p;
    }
    public void setPOO(Point3D pOO)
    {
        POO = new Point3D(pOO);
    }
    public Point3D getPOONew()
    {
        //Point3D p= new Point3D(POO);
        return new Point3D(POO);//p;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((POO == null) ? 0 : POO.hashCode());
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
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
        Ray other = (Ray) obj;
        if (POO == null) {
            if (other.POO != null)
                return false;
        } else if (!POO.equals(other.POO))
            return false;
        if (direction == null) {
            if (other.direction != null)
                return false;
        } else if (!direction.equals(other.direction))
            return false;
        return true;
    }


    @Override
    public String toString()
    {
        return "Ray [POO=" + POO + ", direction=" + direction + "]";
    }


}
