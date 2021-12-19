package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import java.awt.Color;
import Elements.Camera;
import Geometries.Sphere;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class SphereTest {

    @Test
    public void testFindIntersections()
    {
        //without intersection
        Sphere sp=new Sphere(200.,new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-400))/*,new Vector(new Point3D(new Coordinate(4),new Coordinate(2),new Coordinate(1)))*/ );
        double num = (long) Math.pow((double) 1 / 3, 0.5);
        Ray ray=new Ray(new Ray(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)), new Vector(new Point3D(new Coordinate(num),new Coordinate(-1*num),new Coordinate(-1*num)))));
        ArrayList<Point3D> intersection=new ArrayList<Point3D>();
        assertEquals(sp.findIntersections(ray),intersection);
        //one intersection

        Sphere sp1=new Sphere(2.,new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0))/*,new Vector(new Point3D(new Coordinate(4),new Coordinate(2),new Coordinate(1)))*/ );
        Ray ray1=new Ray(new Ray(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)), new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1)))));
        ArrayList<Point3D> intersection1=new ArrayList<Point3D>();
        intersection1.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(2)));
        System.out.println(intersection1);
        assertEquals(sp1.findIntersections(ray1),intersection1);

        //2 intersection

        Sphere sp2=new Sphere(2,new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)) );
        Ray ray2=new Ray(new Ray(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(3)), new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1)))));
        ArrayList<Point3D> intersection2=new ArrayList<Point3D>();
        intersection2.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(2)));
        intersection2.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-2)));
        System.out.println(intersection2);
        assertEquals(sp2.findIntersections(ray2),intersection2);

    }
}



