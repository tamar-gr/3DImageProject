
package Tests;

import java.awt.Color;

import org.junit.Test;

import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class RecursiveTest {


    @Test
    public void recursiveTest()  throws Exception{

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));
        sphere.getMaterial().setKt(0.5);
        scene.AddGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.setnshininess(20);
        sphere2.setEmission(new Color(100, 20, 20));
        sphere2.getMaterial().setKt(0);
        scene.AddGeometry(sphere2);

        scene.AddLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(new Point3D(2, 2, -3))));

        ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.writeToImage();

    }


    @Test
    public void recursiveTest2()  throws Exception{

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));
        sphere.getMaterial().setKt(0.5);
        scene.AddGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
        sphere2.setnshininess(20);
        sphere2.setEmission(new Color(100, 20, 20));
        sphere2.getMaterial().setKt(0);
        scene.AddGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  200,  200, -375));

        Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1500, -1500, -1500));

        triangle.setEmission(new Color(20, 20, 20));
        triangle2.setEmission(new Color(20, 20, 20));
        triangle.getMaterial().setKr(1);
        triangle2.getMaterial().setKr(0.5);
        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);

        scene.AddLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                0, 0.00001, 0.000005, new Vector(new Point3D(-2, -2, -3))));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void recursiveTest3()  throws Exception{

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));
        sphere.getMaterial().setKt(0.5);
        scene.AddGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(0, 0, -1000));
        sphere2.setnshininess(20);
        sphere2.setEmission(new Color(100, 20, 20));
        sphere2.getMaterial().setKt(0);
        scene.AddGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle2 = new Triangle(new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        triangle.setEmission(new Color(20, 20, 20));
        triangle2.setEmission(new Color(20, 20, 20));
        triangle.getMaterial().setKr(1);
        triangle2.getMaterial().setKr(0.5);
        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);

        scene.AddLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                0, 0.00001, 0.000005 ,new Vector(new Point3D(-2, -2, -3))));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.writeToImage();

    }

}

