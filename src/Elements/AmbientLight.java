package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class AmbientLight extends Light
{
    private  double ka;

    // ***************** Constructors ********************** //

    public AmbientLight()
    {
        super(new Color(255, 255, 255));
        this.ka=0.1;
    }

    public AmbientLight(AmbientLight aLight)
    {
        super(aLight.color);
        ka=0.1;
    }

    public AmbientLight(int r, int g, int b)
    {
        super(new Color(r, g, b));
        ka=0.1;
    }
    // ***************** Getters/Setters ********************** //

    public Color getColor()
    { return color;  }

    public void  setColor(Color mycolor)
    { color = mycolor; }

    public double getKa()
    { return ka;     }

    public void setKa(double kaa)
    {  ka=kaa;     }



    public Color getIntensity()
    {
        float r=(float) (color.getRed()*ka);
        if (r>255)
            r=255;
        float g=(float) (color.getGreen()*ka);
        if (g>255)
            g=255;
        float b=(float) (color.getBlue()*ka);
        if (b>255)
            b=255;
        return new Color((int)r,(int)g,(int)b );
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(ka);
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
        AmbientLight other = (AmbientLight) obj;
        if (Double.doubleToLongBits(ka) != Double.doubleToLongBits(other.ka))
            return false;
        return true;
    }


}
