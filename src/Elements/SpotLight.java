package Elements;

import java.awt.Color;

import Primitives.*;

public class SpotLight extends PointLight
{
    Vector direction;


// ***************** Constructors ********************** //

    public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector direction) {
        super(color, position, kc, kl, kq);
        this.direction = new Vector(direction);
        this.direction.normalize();
    }
    public SpotLight(SpotLight s)
    {
        super(s.color, s.position, s.kc, s.kl, s.kq);
        this.direction = new Vector(s.direction);
        this.direction.normalize();

    }
    public SpotLight()
    {
        super();
        this.direction = new Vector();

    }

    // ***************** Getters/Setters ********************** //
    public Vector getDirection()
    {
        return direction;
    }
    public void setDirection(Vector myDirection) {
        this.direction = new Vector (myDirection);
    }

    @Override
    public Color getIntensity(Point3D point) {

        Color pointColor = super.getIntensity(point);

        Vector l = getL(point);
        l.normalize();

        double k = Math.abs(direction.dotProduct(l));

        if (k > 1) k = 1;

        return new Color((int)(pointColor.getRed()   * k),
                (int)(pointColor.getGreen() * k),
                (int)(pointColor.getBlue()  * k));
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpotLight other = (SpotLight) obj;
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
        return "SpotLight [direction=" + direction + ", position=" + position + ", kc=" + kc + ", kl=" + kl + ", kq=" + kq
                + ", color=" + color + "]";
    }
}
