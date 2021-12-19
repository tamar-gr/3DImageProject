package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;

public class CoordinateTest
{

    @Test
    public void testAdd()
    {
        Coordinate a =new Coordinate(5);
        Coordinate b=new Coordinate(2);
        a.add(b);
        double c=a.getCoordinate();
        assertEquals(7.0,c,0);
//		fail("Not yet implemented");
    }

    @Test
    public void testSubstract()
    {
        Coordinate a =new Coordinate(5);
        Coordinate b=new Coordinate(2);
        a.substract(b);
        double c=a.getCoordinate();
        assertEquals(3.0,c,0);
//		fail("Not yet implemented");
    }

}
