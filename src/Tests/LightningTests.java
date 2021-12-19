package Tests;
import java.awt.Color;

import org.junit.Test;

import Elements.Camera;
import Elements.PointLight;
import Elements.SpotLight;
import Geometries.*;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class LightningTests {

    @Test
    public void emmissionTest() throws Exception {

        Scene scene = new Scene();

        scene.AddGeometry(new Sphere(50, new Point3D(0.0, 0.0, -149), new Color(255, 0, 0)));

        Triangle triangle = new Triangle(new Point3D(100, 0, -149),
                new Point3D(0, 100, -149),
                new Point3D(100, 100, -149),
                new Color(0, 255, 0));

        Triangle triangle2 = new Triangle(new Point3D(100, 0, -149),
                new Point3D(0, -100, -149),
                new Point3D(100, -100, -149),
                new Color(0, 0, 255));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -149),
                new Point3D(0, 100, -149),
                new Point3D(-100, 100, -149),
                new Color(255, 255, 0));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149),
                new Point3D(0, -100, -149),
                new Point3D(-100, -100, -149),
                new Color(255, 0, 255));
        triangle.setEmission(new Color(250,0,0));
        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);
        scene.AddGeometry(triangle3);
        scene.AddGeometry(triangle4);
        scene.setScreenDistance(150);
        ImageWriter imageWriter = new ImageWriter("Emission test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        render.getMyImageWriter().writeToimage();
    }

    @Test
    public void pointLightTest1() throws Exception, Exception, Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));
        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000),
                new Color(0, 0, 0));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000),
                new Color(0, 0, 0));

        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);

        scene.AddLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005));

        ImageWriter imageWriter = new ImageWriter("Point test 1", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.getMyImageWriter().writeToimage();
    }

    @Test
    public void spotTest1() throws Exception//moodle
    {
        Scene scene = new Scene();
        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000), new Color(0, 0, 0));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000), new Color(0, 0, 0));
        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);
        scene.AddLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005, new Vector(new Point3D(-2, -2, -3))));

        ImageWriter imageWriter = new ImageWriter("Spot test 1", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.getMyImageWriter().writeToimage();

    }
    @Test
    public void pointLightTest2() throws Exception//moodle
    {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));
        scene.AddGeometry(sphere);
        scene.AddLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                0, 0.00001, 0.000005));
        ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        render.getMyImageWriter().writeToimage();

    }

    @Test
    public void spotLightTest2()  throws Exception//moodle
    {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));
        scene.AddGeometry(sphere);
        scene.AddLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0, 0.00001, 0.000005, new Vector(new Point3D(2, 2, -3))));
        ImageWriter imageWriter = new ImageWriter("spot test 2", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        render.getMyImageWriter().writeToimage();

    }

    @Test
    public void shadowTest() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));

        scene.AddGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000));

        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);

        scene.AddLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005,new Vector(new Point3D(-2, -2, -3))));

        ImageWriter imageWriter = new ImageWriter("shadow test 1", 500, 500, 500, 500);

        Render render = new Render(scene,imageWriter);

        render.renderImage();
        render.getMyImageWriter().writeToimage();

    }

    @Test
    public void spotLightTest3() throws Exception{

        Scene scene = new Scene();
        scene.setScreenDistance(210);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));
        scene.AddGeometry(sphere);
        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));

        triangle.setEmission(new Color(0, 0, 100));
        triangle.setnshininess(4);
        scene.AddGeometry(triangle);

        scene.AddLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(new Point3D(2, 2, -3))));
        ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.getMyImageWriter().writeToimage();

    }
    @Test
    public void shadowTest1() throws Exception {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));

        scene.AddGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000));

        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);

        scene.AddLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005, new Vector(new Point3D(-2, -2, -3))));

        ImageWriter imageWriter = new ImageWriter("shadow test 2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.writeToImage();

    }





    @Test
    public void shadowTest2() throws Exception {

        Scene scene = new Scene();
        scene.setScreenDistance(210);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setnshininess(20);
        sphere.setEmission(new Color(0, 0, 100));
        scene.AddGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000));

        scene.AddGeometry(triangle);
        scene.AddGeometry(triangle2);

        scene.AddLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005, new Vector(new Point3D(-2, -2, -3))));

        ImageWriter imageWriter = new ImageWriter("shadow test 3", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.getMyImageWriter().writeToimage();

    }
}
