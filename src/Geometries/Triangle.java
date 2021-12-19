package Geometries;

import java.util.ArrayList;

import Primitives.Coordinate;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import java.awt.Color;
public class Triangle extends Geometry implements FlatGeometry
{


    @Override
    public String toString()
    {
        return "Triangle [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
    }
    private Point3D p1;
    private Point3D p2;
    private Point3D p3;

    //getters and setters
    public Point3D getP1() {
        return p1;
    }
    public void setP1(Point3D p11) {
        this.p1 = new Point3D(p11);
    }
    public Point3D getP2() {
        return p2;
    }
    public void setP2(Point3D p22) {
        this.p2 = new Point3D(p22);
    }
    public Point3D getP3() {
        return p3;
    }
    public void setP3(Point3D p33) {
        this.p3 =new Point3D(p33);
    }
    //constructors
    public Triangle( Point3D p11, Point3D p22, Point3D p33)
    {
        super();
        this.p1 = new Point3D(p11);
        this.p2 = new Point3D(p22);
        this.p3 = new Point3D(p33);
    }
    public Triangle( Point3D p11, Point3D p22, Point3D p33,Color col)
    {
        super();
        this.setEmission(col);
        this.p1 = new Point3D(p11);
        this.p2 = new Point3D(p22);
        this.p3 = new Point3D(p33);
    }
    public Triangle(Color col,Material mat, Point3D p11, Point3D p22, Point3D p33)
    {
        super(col,mat);
        this.p1 = new Point3D(p11);
        this.p2 = new Point3D(p22);
        this.p3 = new Point3D(p33);
    }
    public Triangle()
    {
        super();
        this.p1 = new Point3D();
        this.p2 = new Point3D();
        this.p3 = new Point3D();
    }
    public Triangle(Triangle t1)
    {
        super(t1.getEmission(),t1.getMaterial());
        this.p1 = new Point3D(t1.getP1());
        this.p2 = new Point3D(t1.getP2());
        this.p3 = new Point3D(t1.getP3());
    }
    //getHashCode and Equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
        result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
        result = prime * result + ((p3 == null) ? 0 : p3.hashCode());
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
        Triangle other = (Triangle) obj;
        if (p1 == null) {
            if (other.p1 != null)
                return false;
        } else if (!p1.equals(other.p1))
            return false;
        if (p2 == null) {
            if (other.p2 != null)
                return false;
        } else if (!p2.equals(other.p2))
            return false;
        if (p3 == null) {
            if (other.p3 != null)
                return false;
        } else if (!p3.equals(other.p3))
            return false;
        return true;
    }



    @Override
    public Vector getNormal(Point3D p)
    {
        Vector U = new Vector (p1, p2);
        Vector V = new Vector (p1, p3);
        Vector N = new Vector (U.crossProduct(V));

        N.normalize();
        N.scale(-1);
        return N;
    }

    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {

        ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>(1);

        // Intersecting the triangular plane

        Point3D P0 = new Point3D(ray.getPOO());

        Vector N = new Vector(getNormal(null));
        Plane plane = new Plane(p3, N);

        if (plane.findIntersections(ray).isEmpty())
            return intersectionPoints;

        Point3D intersectionPlane =new Point3D( plane.findIntersections(ray).get(0));

        // Checking if the interseculating point is bounded by the triangle
        Vector P_P0 = new Vector(P0, intersectionPlane);

        // Checking 1/3 triangular side
        Vector V1_1 = new Vector(P0, this.p1);
        Vector V2_1 = new Vector(P0, this.p2);
        Vector N1 = V1_1.crossProduct(V2_1);
        N1.normalize();
        double S1 = -P_P0.dotProduct(N1);

        // Checking 2/3 triangular side
        Vector V1_2 = new Vector(P0, this.p2);
        Vector V2_2 = new Vector(P0, this.p3);
        Vector N2 = V1_2.crossProduct(V2_2);
        N2.normalize();
        double S2 = -P_P0.dotProduct(N2);

        // Checking 1/3 triangular side
        Vector V1_3 = new Vector(P0, this.p3);
        Vector V2_3 = new Vector(P0, this.p1);
        Vector N3 = V1_3.crossProduct(V2_3);
        N3.normalize();
        double S3 = -P_P0.dotProduct(N3);

        if (((S1 > 0) && (S2 > 0) && (S3 > 0)) ||
                ((S1 < 0) && (S2 < 0) && (S3 < 0))){
            intersectionPoints.add(intersectionPlane);
        }

        return intersectionPoints;

    }



}
