package Geometries;

import java.awt.Color;
import java.util.ArrayList;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public abstract class Geometry
{
    private java.awt.Color emission;
    private Material material;
    public abstract Vector getNormal(Point3D p) ;
    public abstract ArrayList<Point3D> findIntersections(Ray ray);
    private double nshininess=1;
    //constructors
    public Geometry(java.awt.Color color1,Material mat)
    {
        super();
        emission = color1;
        material= new Material(mat);
    }
    public Geometry()
    {
        emission=new Color(0,0,0);
        material=new Material();
    }
    public Geometry(Geometry g)
    {
        emission=g.getEmission();
        material=new Material(g.getMaterial());
    }


    //getters and setters

    public double getnshininess()
    {
        return nshininess;
    }
    public void setnshininess(double  n)
    {
        this.nshininess=n;
    }
    public Material getMaterial()
    {
        return material;
    }
    public void setMaterial(Material material)
    {
        this.material = new Material(material);
    }
    public java.awt.Color getEmission()
    {
        return emission;
    }

    public void setEmission(java.awt.Color color)
    {
        emission = color;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emission == null) ? 0 : emission.hashCode());
        result = prime * result + ((material == null) ? 0 : material.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Geometry other = (Geometry) obj;
        if (emission == null) {
            if (other.emission != null)
                return false;
        } else if (!emission.equals(other.emission))
            return false;
        if (material == null) {
            if (other.material != null)
                return false;
        } else if (!material.equals(other.material))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Geometry [emission=" + emission + ", material=" + material + "]";
    }





}
