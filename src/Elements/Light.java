package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public abstract class Light
{
    protected Color color;

    public Light()
    {
        this.color = new Color(255,255,255);
    }
    public Light (Color other)
    {
        this.color = new Color(other.getRed(), other.getGreen(),other.getBlue());
    }

    public Light(Light other)
    {
        this.color = new Color(other.color.getRed(), other.color.getGreen(),other.color.getBlue());
    }
    public Color getColor()
    {
        return color;
    }
    public void setColor(Color color)
    {
        this.color = new Color(color.getRed(),color.getGreen(),color.getBlue());
    }

    public  Color getIntensity(){return color;};
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Light other = (Light) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        return true;
    }

}

