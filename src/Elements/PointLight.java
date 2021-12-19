package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class PointLight extends Light implements LightSource
{

    Point3D position;
    protected double kc;
    protected double kl;
    protected double kq;

    public PointLight()
    {
        super();
        this.position = new Point3D();
        this.kc = 0;
        this.kl = 0;
        this.kq = 0;
    }
    public PointLight(Color color, Point3D position1, double kc1, double kl1, double kq1) {
        super(color);
        this.position = new Point3D(position1);
        this.kc = kc1;
        this.kl = kl1;
        this.kq = kq1;
    }
    public PointLight(PointLight p)
    {
        super(p.color);
        this.position = new Point3D(p.position);
        this.kc = p.kc;
        this.kl = p.kl;
        this.kq = p.kq;
    }
    // ***************** Getters/Setters ********************** //
    public Point3D getPosition()
    {
        return position;
    }
    public void setPosition(Point3D position)
    {
        this.position = new Point3D(position);
    }
    public double getKc()
    {
        return kc;
    }
    public void setKc(double kc)
    {
        this.kc = kc;
    }
    public double getKl()
    {
        return kl;
    }
    public void setKl(double kl)
    {
        this.kl = kl;
    }
    public double getKq()
    {
        return kq;
    }
    public void setKq(double kq) {

        this.kq = kq;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(kc);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(kl);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(kq);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((position == null) ? 0 : position.hashCode());
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
        PointLight other = (PointLight) obj;
        if (Double.doubleToLongBits(kc) != Double.doubleToLongBits(other.kc))
            return false;
        if (Double.doubleToLongBits(kl) != Double.doubleToLongBits(other.kl))
            return false;
        if (Double.doubleToLongBits(kq) != Double.doubleToLongBits(other.kq))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "PointLight [position=" + position + ", kc=" + kc + ", kl=" + kl + ", kq=" + kq + ", color=" + color
                + "]";
    }
    @Override
    public Color getIntensity(Point3D point)
    {

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        double d = position.distance(point);

        double k = 1/(kc + kl*d + kq*Math.pow(d, 2));

        if (k > 1) k = 1;

        return new Color((int)(r * k),
                (int)(g * k),
                (int)(b * k));

    }

    @Override
    public Vector getL(Point3D point)
    {
        Vector vec1= new Vector(point);
        Vector vec2= new Vector(position);
        vec1.substract(vec2);
        return vec1;

    }

}

