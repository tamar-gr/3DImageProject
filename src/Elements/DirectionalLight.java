package Elements;

import java.awt.Color;

import Primitives.*;
public class DirectionalLight extends Light implements LightSource
{

    Vector direction;

    // ***************** Constructors ********************** //
    public DirectionalLight()
    {
        super();
        this.direction = new Vector ();
    }
    public DirectionalLight(Color color, Vector direction)
    {
        super(color);
        this.direction = new Vector (direction);
    }
    public DirectionalLight(DirectionalLight d)
    {
        super(d.color);
        this.direction = new Vector (d.direction);
    }

    // ***************** Getters/Setters ********************** //
    public Vector getDirection() {
        return direction;
    }
    public void setDirection(Vector direction) {
        this.direction = new Vector(direction);
    }

// ***************** Administration  ******************** //

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
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
        DirectionalLight other = (DirectionalLight) obj;
        if (direction == null) {
            if (other.direction != null)
                return false;
        } else if (!direction.equals(other.direction))
            return false;
        return true;
    }
    @Override
    public String toString()
    {
        return "DirectionalLight [direction=" + direction + ", color=" + color + "]";
    }
    @Override
    public Vector getL(Point3D point)
    {
        return new Vector(getDirection());

    }
    @Override
    public Color getIntensity(Point3D p)
    {
        return getIntensity();
    }



}
