package Tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import java.awt.Color;
import Elements.Camera;
import Geometries.Triangle;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class TriangleTest
{

//			@Test
//			public void testIntersectionPoints()
//			{
//
//				final int WIDTH  = 3;
//				final int HEIGHT = 3;
//
//				Ray[][] rays = new Ray [HEIGHT][WIDTH];
//				Coordinate a= new Coordinate(0.0);
//				Coordinate b= new Coordinate(1.0);
//				Coordinate c= new Coordinate(-1.0);
//				Coordinate d= new Coordinate(2);
//				Coordinate e= new Coordinate(-2);
//				Camera camera = new Camera(new Point3D(a,a,a),
//										   new Vector (new Point3D(a, b, a)),
//										   new Vector (new Point3D(a, a, c)));
//
//				Triangle triangle = new Triangle(new Point3D( a,  b, e),
//												 new Point3D( b, c, e),
//												 new Point3D(c, c, e));
//
//				Triangle triangle2 = new Triangle(new Point3D( a,new Coordinate(10), e),
//						 			 			  new Point3D( b, c, e),
//						 			 			  new Point3D(c, c, e));
//
//				List<Point3D> intersectionPointsTriangle = new ArrayList<Point3D>();
//				List<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();
//
//				System.out.println("Camera:\n" + camera);
//
//				for (int i = 0; i < HEIGHT; i++){
//					for (int j = 0; j < WIDTH; j++){
//
//						rays[i][j] = camera.constructRayThroughPixel(
//								WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
//
//						List<Point3D> rayIntersectionPoints   = triangle.  findIntersections(rays[i][j]);
//						List<Point3D> rayIntersectionPoints2  = triangle2. findIntersections(rays[i][j]);
//
//						for (Point3D iPoint: rayIntersectionPoints)
//							intersectionPointsTriangle.add(iPoint);
//
//						for (Point3D iPoint: rayIntersectionPoints2)
//							intersectionPointsTriangle2.add(iPoint);
//					}
//				}
//
//				assertTrue(intersectionPointsTriangle. size() == 1);
//				assertTrue(intersectionPointsTriangle2.size() == 2);
//
//				System.out.println("Intersection Points:");
//				for (Point3D iPoint: intersectionPointsTriangle){
//					System.out.println(iPoint);
//				}
//				System.out.println("--");
//				for (Point3D iPoint: intersectionPointsTriangle2){
//					System.out.println(iPoint);
//				}
//
//			}

}

