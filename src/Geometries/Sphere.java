package Geometries;

import java.awt.Color;
import java.util.ArrayList;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Sphere extends RadialGeometry
{
    private Point3D center;

    public Sphere(double radius, Point3D center1)
    {
        super(radius);
        center = new Point3D(center1);
    }
    public Sphere(double radius, Point3D center1,Color col)
    {
        super(radius);
        center = new Point3D(center1);
        this.setEmission(col);
    }
    public Sphere(Color col,Material mat,double radius, Point3D center1)
    {
        super(col,mat,radius);
        center = new Point3D(center1);
    }
    public Sphere(Sphere s1)
    {
        super(s1.getEmission(),s1.getMaterial(),s1.getRadius());
        center= new Point3D(s1.getCenter());
    }

    @Override
    public String toString() {
        return "Sphere [center=" + center + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((center == null) ? 0 : center.hashCode());
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
        Sphere other = (Sphere) obj;
        if (center == null) {
            if (other.center != null)
                return false;
        } else if (!center.equals(other.center))
            return false;
        return true;
    }

    public Point3D getCenter()
    {
        Point3D point= new Point3D(this.center);
        return point;
    }

    public void setCenter(Point3D center1) {
        this.center =new Point3D(center1);
    }
    @Override
    public Vector getNormal(Point3D p)
    {
        Point3D p1=new Point3D(p);
        p1.substract(center);
        Vector v =new Vector(p1);
        v.normalize();
        return v;
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray)
    {
        Ray ray1=new Ray (ray);
        Vector rayP0 = new Vector(ray1.getPOO());
        Point3D center1= new Point3D(center);
        center1.substract(rayP0.getHead());
        Vector L = new Vector(center1);
        double Tm = L.dotProduct(ray1.getDirection());
        double dis = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(Tm, 2));
        ArrayList<Point3D> intersections = new ArrayList<Point3D>();
        if (dis <= this.getRadius()) {
            double Th = Math.sqrt(Math.pow(this.getRadius(), 2) - Math.pow(dis, 2));
            double t1 = Tm - Th;
            double t2 = Tm + Th;
            ray1.getDirection().scale(t1);
            ray1.getPOO().add(new Point3D(ray1.getDirection().getHead()));
            Point3D P1 =  ray1.getPOO();
            ray1=new Ray (ray);// not to change a value
            ray1.getDirection().scale(t2);
            ray1.getPOO().add(new Point3D( ray1.getDirection().getHead()));
            Point3D P2 = ray1.getPOO();
            if (t1 > 0) {
                intersections.add(P1);
            }
            if (t2 > 0) {
                intersections.add(P2);
            }
        }
        return intersections;

    }

}













