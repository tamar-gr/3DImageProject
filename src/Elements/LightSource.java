package Elements;


import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public interface LightSource{

    public abstract Color getIntensity(Point3D point);
    public abstract Vector getL(Point3D point); // light to point vector

}


