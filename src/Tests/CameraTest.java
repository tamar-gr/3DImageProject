package Tests;

import Elements.Camera;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

public class CameraTest {
    @Test
    public void testConstructRayThroughPixel()
    {
        Camera cam=new Camera(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)),new Vector(new Point3D(new Coordinate(1.0),new Coordinate(3.0),new Coordinate(2.0))),
                new Vector(new Point3D(new Coordinate(2.0),new Coordinate(2.0),new Coordinate(1.0))));
        //Ray r=cam.constructRayThroughPixel(5, 5, 2, 2, 10, 20, 20);
        Vector v=new Vector(new Point3D(new Coordinate(20.0),new Coordinate(20.0),new Coordinate(10.0)));
        v.normalize();
        Ray ray=new Ray(new Point3D(),v);
        //assertEquals(ray,r);


    }
}
