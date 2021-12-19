package Tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import org.junit.Test;

import Elements.Camera;
import Geometries.Plane;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class PlaneTest
{

    @Test
    public void testIntersectionPoints()
    {

        final int WIDTH  = 3;
        final int HEIGHT = 3;

        Ray[][] rays = new Ray [HEIGHT][WIDTH];
        Coordinate a=new Coordinate(1.0);
        Coordinate b= new Coordinate(-1.0);
        Coordinate c= new Coordinate(0);

        Camera camera = new Camera(new Point3D(c,c,c),
                new Vector (new Point3D(c, a, c)),
                new Vector (new Point3D(c, c, b)));

        // plane orthogonal to the view plane
        Plane plane  = new Plane(new Point3D(c, c, new Coordinate(-3.0)),new Vector(new Point3D(c,c, b)));

        // 45 degrees to the view plane
        Plane plane2 = new Plane(new Point3D(c,c,new Coordinate(-3.0)),new Vector(new Point3D(c,new Coordinate(0.25), b)));

        List<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
        List<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();

        System.out.println("Camera:\n" + camera);

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){

                //		rays[i][j] = camera.constructRayThroughPixel(
                //			WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

                List<Point3D> rayIntersectionPoints   = plane. findIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2  = plane2.findIntersections(rays[i][j]);

                for (Point3D iPoint: rayIntersectionPoints)
                    intersectionPointsPlane.add(iPoint);

                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsPlane2.add(iPoint);
            }
        }

        assertTrue(intersectionPointsPlane. size() == 9);
        assertTrue(intersectionPointsPlane2.size() == 9);

        for (Point3D iPoint: intersectionPointsPlane)
            System.out.println(iPoint);

        System.out.println("---");

        for (Point3D iPoint: intersectionPointsPlane2)
            System.out.println(iPoint);
    }

}

