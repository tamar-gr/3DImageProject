package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;
import Primitives.Point3D;

public class Point3DTest {

    @Test
    public void testAdd()
    {
        Coordinate a =new Coordinate(1);
        Coordinate b =new Coordinate(2);
        Point3D p1=new Point3D(a,a,a);
        Point3D p2=new Point3D(a,a,a);
        p1.add(p2);
        Point3D ans=new Point3D(b,b,b);
        assertEquals(p1,ans);

        //fail("Not yet implemented");
    }

    @Test
    public void testSubstract()
    {
        Coordinate a =new Coordinate(2);
        Coordinate b =new Coordinate(1);
        Point3D p1=new Point3D(a,a,a);
        Point3D p2=new Point3D(b,b,b);
        p1.substract(p2);
        Point3D ans=new Point3D(b,b,b);
        assertEquals(p1,ans);

        //fail("Not yet implemented");
    }

}
