package Renderer;//look ur email

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//import Elements.LightSource;
//import Geometries.FlatGeometry;
import Elements.LightSource;
import Geometries.FlatGeometry;
import Geometries.Geometry;
//import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
//import Primitives.Vector;
//import Scene.Scene;
//import Elements.Camera;

import Scene.Scene;

//import java.util.ArrayList;

import java.util.Set;
import Primitives.Ray;
import Primitives.Vector;
import Primitives.Point3D;
import Geometries.FlatGeometry;
import Geometries.Geometry;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import Elements.LightSource;

public class Render {

    Scene myScene;
    ImageWriter myImageWriter;
    private final int RECURSION_LEVEL =2;

    public Render(Scene myScene1, ImageWriter myImageWriter1) {
        super();
        this.myScene = new Scene(myScene1);
        this.myImageWriter = new ImageWriter(myImageWriter1);
    }

    public Render(Render myRender) {
        super();
        this.myScene = new Scene(myRender.getMyScene());
        this.myImageWriter = new ImageWriter(myRender.getMyImageWriter());
    }

    public Scene getMyScene() {
        return myScene;
    }

    public void setMyScene(Scene myScene1) {
        this.myScene = new Scene(myScene1);
    }

    public ImageWriter getMyImageWriter() {
        return myImageWriter;
    }

    public void setMyImageWriter(ImageWriter myImageWriter1) {
        this.myImageWriter = new ImageWriter(myImageWriter1);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((myImageWriter == null) ? 0 : myImageWriter.hashCode());
        result = prime * result + ((myScene == null) ? 0 : myScene.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Render other = (Render) obj;
        if (myImageWriter == null) {
            if (other.myImageWriter != null) {
                return false;
            }
        } else if (!myImageWriter.equals(other.myImageWriter)) {
            return false;
        }
        if (myScene == null) {
            if (other.myScene != null) {
                return false;
            }
        } else if (!myScene.equals(other.myScene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Render [myScene=" + myScene + ", myImageWriter=" + myImageWriter + "]";
    }

    public ImageWriter renderImage() throws Exception {
        for (int i = 0; i < myImageWriter.getHeight(); i++) {
            for (int j = 0; j < myImageWriter.getWidth(); j++) {
                List<Ray> rays;
                rays = myScene.getCamera().constructRayThroughPixel(myImageWriter.getNx(), myImageWriter.getNy(), j, i, myScene.getScreenDistance(), myImageWriter.getWidth(), myImageWriter.getHeight());
                Color avg = new Color(0);
                for (Ray r : rays) {
                    Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(r);

                    if (intersectionPoints.isEmpty()) {
                        avg = new Color(avg.getRed() + myScene.getBackground().getRed() / rays.size(),
                                avg.getGreen() + myScene.getBackground().getGreen() / rays.size(),
                                avg.getBlue() + myScene.getBackground().getBlue() / rays.size());
                    } else {
                        Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
                        // Get an iterator
                        Set<Entry<Geometry, Point3D>> set = closestPoint.entrySet();
                        // Get a set of the entries
                        Iterator<Entry<Geometry, Point3D>> t = set.iterator();
                        // Display elements
                        while (t.hasNext()) {
                            Map.Entry me = (Map.Entry) t.next();
                            Color tmp = calcColor((Geometry) me.getKey(), (Point3D) me.getValue(), r);
                            avg = new Color(avg.getRed() + tmp.getRed() / rays.size(),
                                    avg.getGreen() + tmp.getGreen() / rays.size(),
                                    avg.getBlue() + tmp.getBlue() / rays.size());
                            if(avg.getRed() == 0 || avg.getGreen() == 0 || avg.getBlue() == 0)
                                System.out.println(avg.getRed()+ " " + avg.getGreen() + " " + avg.getBlue());
                        }
                    }

                }

                myImageWriter.writePixel(j, i, avg);
            }
        }
        return myImageWriter;
    }

    private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray) {

        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);

        if (intersectionPoints.size() == 0) {
            return null;
        }

        Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
        Entry<Geometry, Point3D> entry = closestPoint.entrySet().iterator().next();
        return entry;

    }

    public void printGrid(int interval) {

        int height = myImageWriter.getHeight();
        int width = myImageWriter.getWidth();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i % interval == 0 || j % interval == 0) {
                    myImageWriter.writePixel(j, i, 255, 255, 255);
                }

            }
        }
    }

    public void writeToImage() {
        myImageWriter.writeToimage();
    }

    private Color calcColor(Geometry geometry, Point3D point, Ray ray) {
        return calcColor(geometry, point, ray, 0);
    }

    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) {

        if (level == RECURSION_LEVEL) {
            return new Color(0, 0, 0);
        }

        Color ambientLight = myScene.getAmbient().getIntensity();
        Color emissionLight = geometry.getEmission();

        Color inherentColors = addColors(ambientLight, emissionLight);

        Iterator<LightSource> lights = myScene.getLightsIterator();

        Color lightReflected = new Color(0, 0, 0);

        while (lights.hasNext()) {

            LightSource light = lights.next();

            if (!occluded(light, point, geometry)) {

                Color lightIntensity = light.getIntensity(point);//

                Color lightDiffuse = calcDiffusiveComp(geometry.getMaterial().getKd(),
                        geometry.getNormal(point),
                        light.getL(point),
                        lightIntensity);

                Color lightSpecular = calcSpecularComp(geometry.getMaterial().getKs(),
                        new Vector(point, myScene.getCamera().getP0()),
                        geometry.getNormal(point),
                        light.getL(point),
                        geometry.getnshininess(),
                        lightIntensity);
                lightReflected = addColors(lightDiffuse, lightSpecular);
            }
        }

        Color I0 = addColors(inherentColors, lightReflected);

        //**// Recursive calls
        // Recursive call for a reflected ray
        Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
        Entry<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
        Color reflected = new Color(0, 0, 0);
        if (reflectedEntry != null) {
            reflected = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay, level + 1);
            double kr = geometry.getMaterial().getKr();
            reflected = new Color((int) (reflected.getRed() * kr), (int) (reflected.getGreen() * kr), (int) (reflected.getBlue() * kr));
        }

        // Recursive call for a refracted ray
        Ray refractedRay = constructRefractedRay(geometry, point, inRay);
        Entry<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
        Color refracted = new Color(0, 0, 0);
        if (refractedEntry != null) {
            refracted = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay, level + 1);
            double kt = geometry.getMaterial().getKt();
            refracted = new Color((int) (refracted.getRed() * kt), (int) (refracted.getGreen() * kt), (int) (refracted.getBlue() * kt));
        }

        //**// End of recursive calls
        Color envColors = addColors(reflected, refracted);

        Color finalColor = addColors(envColors, I0);

        return finalColor;
    }

    private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay) {

        Vector normal = new Vector(geometry.getNormal(point));
        normal.scale(-2);
        point.add(normal.getHead());

        if (geometry instanceof FlatGeometry) {
            return new Ray(point, new Vector(inRay.getDirection()));
        } else {
            return new Ray(point, new Vector(inRay.getDirection()));
        }

    }

    private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay) {

        Vector l = new Vector(inRay.getDirection());
        l.normalize();

        normal.scale(-2 * l.dotProduct(normal));
        l.add(normal);

        Vector R = new Vector(l);
        R.normalize();

        point.add(normal.getHead());

        Ray reflectedRay = new Ray(point, R);

        return reflectedRay;
    }

    private boolean occluded(LightSource light, Point3D point, Geometry geometry) {

        Vector lightDirection = new Vector(light.getL(point));///new??
        lightDirection.scale(-1);
        lightDirection.normalize();

        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector.scale(2);
        geometryPoint.add(epsVector.getHead());

        Ray lightRay = new Ray(geometryPoint, lightDirection);
        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);

        // Flat geometry cannot self intersect
        if (geometry instanceof FlatGeometry) {
            intersectionPoints.remove(geometry);
        }

        for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
            if (entry.getKey().getMaterial().getKt() == 0) {
                return true;
            }
        }

        return false;

    }

    private Color calcSpecularComp(double ks, Vector v, Vector normal,
                                   Vector l, double shininess, Color lightIntensity) {

        v.normalize();
        normal.normalize();
        l.normalize();

        normal.scale(-2 * l.dotProduct(normal));
        l.add(normal);
        Vector R = new Vector(l);
        R.normalize();

        double k = 0;

        if (v.dotProduct(R) > 0) // prevents glowing at edges
        {
            k = ks * Math.pow(v.dotProduct(R), shininess);
        }

        return new Color((int) (lightIntensity.getRed() * k),
                (int) (lightIntensity.getGreen() * k),
                (int) (lightIntensity.getBlue() * k));
    }

    private Color calcDiffusiveComp(double kd, Vector normal,
                                    Vector l, Color lightIntensity) {

        normal.normalize();
        l.normalize();

        double k = Math.abs(kd * normal.dotProduct(l));

        return new Color((int) (lightIntensity.getRed() * k),
                (int) (lightIntensity.getGreen() * k),
                (int) (lightIntensity.getBlue() * k));
    }

    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = new Point3D(myScene.getCamera().getP0());
        Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();

        for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
            for (Point3D point : entry.getValue()) {
                double pointDistance = P0.distance(point);
                if (pointDistance < distance) {
                    minDistancePoint.clear();
                    minDistancePoint.put(entry.getKey(), new Point3D(point));
                    distance = pointDistance;
                }
            }
        }

        return minDistancePoint;

    }

    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {

        Iterator<Geometry> geometries = myScene.getGeometriesIterator();
        Map<Geometry, List<Point3D>> intersectionPoints = new HashMap();
        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            ArrayList<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);

            if (!geometryIntersectionPoints.isEmpty()) {
                intersectionPoints.put(geometry, geometryIntersectionPoints);
            }
        }

        return intersectionPoints;
    }

    private Color addColors(Color a, Color b) {

        int R = a.getRed() + b.getRed();
        if (R > 255) {
            R = 255;
        }

        int G = a.getGreen() + b.getGreen();
        if (G > 255) {
            G = 255;
        }

        int B = a.getBlue() + b.getBlue();
        if (B > 255) {
            B = 255;
        }

        Color I = new Color(R, G, B);

        return I;

    }

}

