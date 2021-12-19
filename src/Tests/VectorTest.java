package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;

public class VectorTest {

    @Test
    public void testAdd()
    {
        Coordinate a= new Coordinate(1);
        Coordinate b= new Coordinate(2);
        Point3D p1= new Point3D(a,a,a);
        Point3D p2= new Point3D(b,b,b);
        Vector V= new Vector(p1);
        Vector U= new Vector(p1);
        Vector ans = new Vector(p2);
        V.add(U);
        assertEquals(ans,V);
        //fail("Not yet implemented");
    }
    @Test
    public void testSubstract()
    {
        Coordinate a= new Coordinate(1);
        Coordinate b= new Coordinate(2);
        Point3D p1= new Point3D(a,a,a);
        Point3D p2= new Point3D(b,b,b);
        Vector V= new Vector(p1);
        Vector U= new Vector(p2);
        Vector ans = new Vector(p1);
        U.substract(V);
        assertEquals(ans,V);
        //	fail("Not yet implemented");
    }
    @Test
    public void testScaling()
    {
        Coordinate a= new Coordinate(6);
        Coordinate b= new Coordinate(18);
        Point3D p1= new Point3D(a,a,a);
        Point3D p2= new Point3D(b,b,b);
        Vector V= new Vector(p1);
        V.scale(3);
        Vector ans=new Vector(p2);
        assertEquals(ans,V);
        //	fail("Not yet implemented");
    }
    @Test
    public void testdotProduct()
    {
        Coordinate a= new Coordinate(3);
        Point3D p1= new Point3D(a,a,a);
        Vector V= new Vector(p1);
        Vector U= new Vector(p1);
        double sum= V.dotProduct(U);
        assertEquals(27, sum,0);
        //fail("Not yet implemented");
    }
    @Test
    public void testLength()
    {
        Coordinate a= new Coordinate(3);
        Point3D p1= new Point3D(a,a,a);
        Vector V= new Vector(p1);
        double length= V.length();
        assertEquals(Math.sqrt(27), length,0);
        //fail("Not yet implemented");
    }
    @Test
    public void testNormalize()
    {
        Coordinate a= new Coordinate(1);
        Coordinate b= new Coordinate(1/Math.sqrt(3));
        Point3D p1= new Point3D(a,a,a);
        Point3D p2= new Point3D(b,b,b);
        Vector vec=new Vector(p1);
        vec.normalize();
        Vector ans=new Vector(p2);
        assertEquals(ans,vec);
        //fail("Not yet implemented");
    }
    @Test
    public void testCrossProduct()
    {
        Coordinate a= new Coordinate(1);
        Coordinate b= new Coordinate(0);
        Coordinate c= new Coordinate(-1);
        Point3D p1= new Point3D(b,b,c);
        Point3D p2= new Point3D(b,a,b);
        Point3D p3= new Point3D(a,b,b);
        Vector vec1=new Vector(p1);
        Vector vec2=new Vector(p2);
        Vector exp=new Vector(p3);
        Vector ans=vec1.crossProduct(vec2);
        assertEquals(exp,ans);
        //	fail("Not yet implemented");
    }

}
