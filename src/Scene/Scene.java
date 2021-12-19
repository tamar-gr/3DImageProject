package Scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import Geometries.Geometry;
import Elements.AmbientLight;
import Elements.Camera;
import Elements.Light;
import Elements.LightSource;
public class Scene
{
    private String name;
    private Color background;
    private ArrayList<Geometry> geometries;
    private Camera camera;
    private double screenDistance;
    private AmbientLight ambient;
    private ArrayList <LightSource> lights=new ArrayList<LightSource>();

    public Scene()
    {
        super();
        this.name = "";
        this.background=new Color(0,0,0);
        this.geometries = new ArrayList<Geometry>();
        this.camera = new Camera();
        this.screenDistance = 100;
        this.ambient=new AmbientLight();
    }
    public Scene (Scene myScene)
    {
        super();
        this.name = myScene.name;
        this.background = new Color(myScene.background.getRed(),myScene.background.getGreen(),myScene.background.getBlue());
        setGeometries(myScene.geometries);
        setCamera(myScene.camera);
        this.screenDistance = myScene.screenDistance;
        this.ambient=new AmbientLight(myScene.getAmbient());
        this.lights=new ArrayList<LightSource>(myScene.lights);
    }
    public Scene(String name, Color background, ArrayList<Geometry> geometries, Camera camera, double screenDistance,AmbientLight ambient1,ArrayList <LightSource> lights1) {
        super();
        this.name = name;
        this.background = new Color(background.getRed(),background.getGreen(),background.getBlue());
        setGeometries(geometries);
        setCamera(camera);
        this.screenDistance = screenDistance;
        //this.ambient=new AmbientLight (ambient1);
        this.ambient=new AmbientLight (ambient1);
        this.lights=new ArrayList<LightSource>(lights1);
    }
    public AmbientLight getAmbient()
    {
        return ambient;
    }
    public void setAmbient(AmbientLight ambient)
    {
        this.ambient = new AmbientLight(ambient);
    }
    public ArrayList<LightSource> getLights()
    {
        return lights;
    }
    public void setLights(ArrayList<LightSource> lights)
    {
        this.lights=new ArrayList<LightSource>(lights);
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Color getBackground()
    {
        return background;
    }
    public void setBackground(Color background1)
    {
        this.background = new Color(background.getRed(),background.getGreen(),background.getBlue());


    }
    public Camera getCamera()
    {
        return camera;
    }
    public void setCamera(Camera cam)
    {

        this.camera =new Camera(cam);
    }
    public double getScreenDistance()
    {
        return screenDistance;
    }
    public void setScreenDistance(double screenDistance)
    {
        this.screenDistance = screenDistance;
    }
    public ArrayList<Geometry> getGeometries()
    {
        return geometries;
    }
    public void setGeometries(ArrayList<Geometry> geometry)
    {
        this.geometries = new ArrayList<Geometry>(geometry);


    }
    public void AddLight(LightSource a)
    {
        this.lights.add(a);
    }
    public Iterator<LightSource> getLightsIterator()
    {
        return lights.iterator();
    }

    public void AddGeometry (Geometry geo)
    {
        this.geometries.add(geo);
    }

    public Iterator<Geometry>getGeometriesIterator()
    {
        return geometries.iterator();

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ambient == null) ? 0 : ambient.hashCode());
        result = prime * result + ((background == null) ? 0 : background.hashCode());
        result = prime * result + ((camera == null) ? 0 : camera.hashCode());
        result = prime * result + ((geometries == null) ? 0 : geometries.hashCode());
        result = prime * result + ((lights == null) ? 0 : lights.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(screenDistance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Scene other = (Scene) obj;
        if (ambient == null) {
            if (other.ambient != null)
                return false;
        } else if (!ambient.equals(other.ambient))
            return false;
        if (background == null) {
            if (other.background != null)
                return false;
        } else if (!background.equals(other.background))
            return false;
        if (camera == null) {
            if (other.camera != null)
                return false;
        } else if (!camera.equals(other.camera))
            return false;
        if (geometries == null) {
            if (other.geometries != null)
                return false;
        } else if (!geometries.equals(other.geometries))
            return false;
        if (lights == null) {
            if (other.lights != null)
                return false;
        } else if (!lights.equals(other.lights))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(screenDistance) != Double.doubleToLongBits(other.screenDistance))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Scene [name=" + name + ", background=" + background + ", geometries=" + geometries + ", camera=" + camera
                + ", screenDistance=" + screenDistance + "]";
    }

}
