package Geometries;



import java.awt.Color;
import java.util.ArrayList;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Plane extends Geometry implements FlatGeometry
{
    private Point3D p1;
    private Vector normal;

    public Plane(Point3D p11, Vector normal1)
    {
        super();
        this.p1 = new Point3D(p11);
        this.normal = new Vector(normal1);
        this.normal.normalize();
        //?
    }

    public Plane(Color col,Material mat,Point3D p11, Vector normal1)
    {
        super(col,mat);
        this.p1 = new Point3D(p11);
        this.normal = new Vector(normal1);
        this.normal.normalize();
        //?
    }
    public Plane()
    {
        super();
        this.p1 = new Point3D();
        this.normal = new Vector();
    }
    public Plane(Plane p)
    {
        super();
        this.p1 = new Point3D(p.getP1());
        this.normal = new Vector(p.getNormal(null));
        this.normal.normalize();
    }
    public Point3D getP1() {
        return p1;
    }
    public void setP1(Point3D p11) {
        this.p1 =new Point3D(p11);
    }
    public Vector getNormal(Point3D p)
    {
        return normal;
    }
    public void setNormal(Vector normal1) {
        this.normal = new Vector(normal1);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((normal == null) ? 0 : normal.hashCode());
        result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
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
        Plane other = (Plane) obj;
        if (normal == null) {
            if (other.normal != null)
                return false;
        } else if (!normal.equals(other.normal))
            return false;
        if (p1 == null) {
            if (other.p1 != null)
                return false;
        } else if (!p1.equals(other.p1))
            return false;
        return true;
    }
    @Override
    public ArrayList<Point3D> findIntersections(Ray ray)
    {
		/*
		Point3D Q0 =new Point3D(p1);
		Vector N= new Vector(normal);
		Vector V= new Vector(ray.getDirection());
		Point3D P0 =new Point3D(ray.getPOO());
		Point3D P0Copy =new Point3D(P0);
		N.scale(-1);
		P0Copy.substract(Q0);
		Vector substract= new Vector(P0Copy);
		double mone=N.dotProduct(substract);
		double mechane=N.dotProduct(V);
		double t=mone/mechane;
		V.scale(t);
		P0.add(V.getHead());
		ArrayList<Point3D> result=new ArrayList<Point3D>();
		result.add(P0);
		return result;		*/

        ArrayList<Point3D> intersectionPoint = new ArrayList<Point3D>(1);

        Point3D P0 = new Point3D(ray.getPOO());
        Point3D Q0 =  new Point3D(this.getP1());
        Vector N = new Vector(this.getNormal(null));
        Vector V = new Vector(ray.getDirection());

        Vector v = new Vector (Q0, P0);
        double t = (N.dotProduct(v) * -1) / N.dotProduct(V);

        if (t >= 0){
            V.scale(t);
            P0.add(V.getHead());
            intersectionPoint.add(P0);
        }

        return intersectionPoint;

    }
}


