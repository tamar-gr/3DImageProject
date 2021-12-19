
/*package Tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import Scene.Scene;
import Geometries.*;
import Primitives.*;
import Renderer.ImageWriter;
import Renderer.Render;


public class RenderTest
{

	@Test
	public void test1() throws Exception
	{
		Scene s= new Scene();
		s.setScreenDistance(150);
		Coordinate a= new Coordinate(0);
		Coordinate b= new Coordinate(100);
		Coordinate c= new Coordinate(-100);
		Coordinate d= new Coordinate(-149);
		Coordinate e= new Coordinate(-150);
		//the sphere
		Point3D center = new Point3D(a,a,e);
		//Color c1= new Color(255,255,255);
		Sphere sph =new Sphere(50,center);

		// triangle 1
		Point3D p1 = new Point3D(b, a, d);
        Point3D p2 = new Point3D(a, b,d);
        Point3D p3 = new Point3D(b, b, d);
        Triangle t1 = new Triangle(p1, p2, p3);

        //triangle 2
        Point3D p11 = new Point3D(b, a, d);
        Point3D p22 = new Point3D(b, c, d);
        Point3D p33 = new Point3D(b, c, d);
        Triangle t2 = new Triangle(p11, p22, p33);

        //triangle 3

        Point3D p111 = new Point3D(c,a, d);
        Point3D p222 = new Point3D(a, b, d);
        Point3D p333 = new Point3D(c, b, d);
        Triangle t3 = new Triangle(p111, p222, p333);

        //triangle 4

        Point3D p1111 = new Point3D(c, a, d);
        Point3D p2222 = new Point3D(a, c, d);
        Point3D p3333 = new Point3D(c, c, d);
        Triangle t4 = new Triangle(p1111 ,p2222, p3333);

        s.AddGeometry(sph);
        s.AddGeometry(t1);
        s.AddGeometry(t2);
        s.AddGeometry(t3);
        s.AddGeometry(t4);

		ImageWriter image=new ImageWriter("image6",500,500,500,500);
		Render r= new Render(s, image);
		r.printGrid(50);
		r.renderImage();
		r.getMyImageWriter().writeToimage();


	}
	@Test
	public void test2()
	{
		ImageWriter w=new ImageWriter("new",500,500,1,1);
		for(int i=0;i<500;i++)
		{

			for(int j=0;j<500;j++)
			{
				if(i%50==0||j%50==0)
				{
					w.writePixel(i,j,255,255,255);
				}
			}
		}
		w.writeToimage();

	}

}*/

package Tests;


import java.awt.Color;

import org.junit.Test;

import Elements.SpotLight;
import Geometries.*;

import Scene.Scene;

import Primitives.*;
import Renderer.ImageWriter;
import Renderer.Render;

public class RenderTest
{

    @Test
    public void basicRendering1()  throws Exception
    {

        Scene scene = new Scene();
        scene.setScreenDistance(145);
        Sphere sph=new Sphere(50, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-150)));
        scene.AddGeometry(sph);
        Triangle triangle = new Triangle(new Point3D( new Coordinate(103), new Coordinate(0.0), new Coordinate(-150)),
                new Point3D(  new Coordinate(0.0), new Coordinate(103), new Coordinate(-150)),
                new Point3D( new Coordinate(103), new Coordinate(103), new Coordinate(-150)));

        Triangle triangle2 = new Triangle(new Point3D(new Coordinate(103), new Coordinate(0.0), new Coordinate(-150)),
                new Point3D(new Coordinate(0.0), new Coordinate(-103), new Coordinate(-150)),
                new Point3D(new Coordinate(103), new Coordinate(-103), new Coordinate(-150)));

        Triangle triangle3 = new Triangle(new Point3D(new Coordinate(-103), new Coordinate(0.0), new Coordinate(-150)),
                new Point3D(  new Coordinate(0.0), new Coordinate(103), new Coordinate(-150)),
                new Point3D(new Coordinate(-103), new Coordinate(103), new Coordinate(-150)));

        Triangle triangle4 = new Triangle(new Point3D(new Coordinate(-103), new Coordinate(0.0), new Coordinate(-150)),
                new Point3D(  new Coordinate(0.0),  new Coordinate(-103), new Coordinate(-150)),
                new Point3D(new Coordinate(-103), new Coordinate(-103), new Coordinate(-150)));



        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);
        scene.AddGeometry(triangle3);
        scene.AddGeometry(triangle4);


        ImageWriter imageWriter = new ImageWriter("RenderTest1", 500, 500, 500, 500);
        //scene.getCamera().setP0(new Point3D(0,0,200));
        Render render = new Render( new Scene(scene),imageWriter);

        render.renderImage();
        render.printGrid(50);
        render.getMyImageWriter().writeToimage();
    }

    @Test
    public void basicRendering2()  throws Exception
    {
        Scene scene1 = new Scene();
        scene1.setScreenDistance(50);
        scene1.AddGeometry(new Sphere(40., new Point3D(100,100 , -150)));
        scene1.AddGeometry(new Sphere(50., new Point3D(-100, 100, -0)));
        Triangle triangle5 = new Triangle(new Point3D(50, 50, 0),
                new Point3D(  50,-50  , -100),
                new Point3D(120, -50, -100));
        Triangle triangle6 = new Triangle(new Point3D(50,50 , -100),
                new Point3D(  120,50  , -100),
                new Point3D(120, -50, -100));
        Triangle triangle7 = new Triangle(new Point3D(50,50 , -100),
                new Point3D(  120,50  , -100),
                new Point3D(85, 70, -100));

        Triangle triangle8 = new Triangle(new Point3D(83,-20 , -100),
                new Point3D(  180,-200 , -100),
                new Point3D(15, -200, -100));
        Triangle triangle9 = new Triangle(new Point3D(-20,-10 , -12),
                new Point3D(  -17,-12  ,-12),
                new Point3D(-14, -20, -12));

        Triangle triangle10 = new Triangle(new Point3D(-14,-20 , -10),
                new Point3D(  -11,-10  , -10),
                new Point3D(-8, -20, -10));
        Triangle triangle13 = new Triangle(new Point3D(-10,-20 , -10),
                new Point3D(  -7,-10  , -10),
                new Point3D(-4, -20, -10));
        Triangle triangle11 = new Triangle(new Point3D(-8,-20 , -10),
                new Point3D(  -5,-10  , -10),
                new Point3D(-2, -20, -10));
        Triangle triangle12 = new Triangle(new Point3D(-2,-20 , -10),
                new Point3D(  1,-10  , -10),
                new Point3D(4, -20, -10));
        scene1.AddGeometry(triangle5);
        scene1.AddGeometry(triangle6);
        scene1.AddGeometry(triangle7);
        scene1.AddGeometry(triangle8);
        scene1.AddGeometry(triangle9);
        scene1.AddGeometry(triangle10);
        scene1.AddGeometry(triangle11);
        scene1.AddGeometry(triangle12);
        scene1.AddGeometry(triangle13);
        ImageWriter imageWriter1 = new ImageWriter("RenderTest2", 500, 500, 500, 500);


        Render render1 = new Render( new Scene(scene1),imageWriter1);

        render1.renderImage();
        render1.printGrid(100);
        render1.getMyImageWriter().writeToimage();
    }

    @Test
    public void basicRendering3()  throws Exception
    {
        Scene s= new Scene();
        s.setScreenDistance(150);
        Material a=new Material();
        //the sphere
        Point3D center = new Point3D (0.0,0.0,-150.0);
        Sphere sph =new Sphere(Color.gray,a,50,center);

        // triangle 1
        Point3D p1 = new Point3D(100.0, 0.0, -149.0);
        Point3D p2 = new Point3D(0.0, 100.0, -149.0);
        Point3D p3 = new Point3D(100.0, 100.0, -149.0);
        Triangle t1 = new Triangle(Color.gray,a, p1, p2, p3);

        //triangle 2
        Point3D p11 = new Point3D(100.0, 0.0, -149.0);
        Point3D p22 = new Point3D(0.0, -100.0, -149.0);
        Point3D p33 = new Point3D(100.0, -100.0, -149.0);
        Triangle t2 = new Triangle(Color.green,a, p11, p22, p33);

        //triangle 3

        Point3D p111 = new Point3D(-100.0, 0.0, -149.0);
        Point3D p222 = new Point3D(0.0, 100.0, -149.0);
        Point3D p333 = new Point3D(-100.0, 100.0, -149.0);
        Triangle t3 = new Triangle(Color.red,a, p111, p222, p333);

        //triangle 4

        Point3D p1111 = new Point3D(-100.0, 0.0, -149.0);
        Point3D p2222 = new Point3D(0.0, -100.0, -149.0);
        Point3D p3333 = new Point3D(-100.0, -100.0, -149.0);
        Triangle t4 = new Triangle(Color.blue,a, p1111, p2222, p3333);

        s.AddGeometry(sph);
        s.AddGeometry(t1);
        s.AddGeometry(t2);
        s.AddGeometry(t3);
        s.AddGeometry(t4);

        ImageWriter image=new ImageWriter("new",500,500,500,500);

        Render r= new Render(new Scene(s), image);
        r.renderImage();
        r.printGrid(50);
        r.getMyImageWriter().writeToimage();
    }

}



