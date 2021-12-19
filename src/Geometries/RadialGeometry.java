package Geometries;

import java.awt.Color;

import Primitives.Material;

public abstract class RadialGeometry extends Geometry
{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "RadialGeometry [radius=" + radius + "]";
    }

    public RadialGeometry(double radius)
    {
        super();
        this.radius = radius;
    }
    public RadialGeometry(Color col,Material mat,double radius)
    {
        super(col,mat);
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        RadialGeometry other = (RadialGeometry) obj;
        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
            return false;
        return true;
    }

}
