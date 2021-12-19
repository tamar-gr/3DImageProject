package Elements;

import java.util.ArrayList;
import java.util.List;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Camera {

    Point3D p0;
    Vector vUp;
    Vector vToward;
    Vector vRight;

    public Camera(Point3D p0, Vector vUp, Vector vToward) {

        super();
        this.p0 = new Point3D(p0);
        this.vUp = new Vector(vUp);
        this.vToward = new Vector(vToward);
        this.vRight = this.vUp.crossProduct(this.vToward);
        this.vUp = this.vToward.crossProduct(this.vRight);
        this.vUp.normalize();
        this.vToward.normalize();
        this.vRight.normalize();
    }

    public Camera() {
        super();
        this.p0 = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(10));
        this.vUp = new Vector(new Point3D(new Coordinate(1.0), new Coordinate(0.0), new Coordinate(0.0)));
        this.vToward = new Vector(new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1.0)));
        this.vRight = this.vUp.crossProduct(this.vToward);

    }

    public Camera(Camera cam) {
        super();
        this.p0 = new Point3D(cam.getP0());
        this.vUp = new Vector(cam.getvUp());
        this.vToward = new Vector(cam.getvToward());
        this.vRight = new Vector(cam.getvRight());
    }

    public Point3D getP0() {
        return p0;
    }

    public void setP0(Point3D p00) {
        this.p0 = new Point3D(p00);
    }

    public Vector getvUp() {
        return vUp;
    }

    public void setvUp(Vector vUp1) {
        this.vUp = new Vector(vUp1);
    }

    public Vector getvToward() {
        return vToward;
    }

    public void setvToward(Vector vToward1) {
        this.vToward = new Vector(vToward1);
    }

    public Vector getvRight() {
        return vRight;
    }

    public void setvRight(Vector vRight1) {
        this.vRight = new Vector(vRight1);
    }

    public List<Ray> constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight)
            throws Exception {

        List<Ray> lst = new ArrayList();
        Vector vToward1 = new Vector(this.vToward);
        vToward1.scale(screenDist);
        Point3D Pc = new Point3D(this.p0);
        Pc.add(vToward1.getHead());

        // Calculating x-y ratios
        double Rx = screenWidth / Nx;
        double Ry = screenHeight / Ny;

        // Calculating P - the intersection point
        Vector vRight1 = new Vector(vRight.getHead());
        Vector vUp1 = new Vector(vUp.getHead());

        vRight1.scale(((x - (Nx / 2.0)) * Rx + 0.5 * Rx));
        vUp1.scale(((y - (Ny / 2.0)) * Ry + 0.5 * Ry));
        vRight1.substract(vUp1);
        Pc.add(vRight1.getHead());
        Vector dir = new Vector(new Point3D(p0), Pc);
        dir.normalize();

        Point3D Pc1 = new Point3D(Pc);
        Point3D Pc2 = new Point3D(Pc);
        Point3D Pc3 = new Point3D(Pc);
        Point3D Pc4 = new Point3D(Pc);
        Pc1.add(new Point3D(Rx / 2, Ry / 2, 0));
        Pc2.add(new Point3D(-Rx / 2, Ry / 2, 0));
        Pc3.add(new Point3D(Rx / 2, -Ry / 2, 0));
        Pc4.add(new Point3D(-Rx / 2, -Ry / 2, 0));
        lst.add(new Ray(Pc, dir));
        lst.add(new Ray(Pc1, dir));
        lst.add(new Ray(Pc2, dir));
        lst.add(new Ray(Pc3, dir));
        lst.add(new Ray(Pc4, dir));
        return lst;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((p0 == null) ? 0 : p0.hashCode());
        result = prime * result + ((vRight == null) ? 0 : vRight.hashCode());
        result = prime * result + ((vToward == null) ? 0 : vToward.hashCode());
        result = prime * result + ((vUp == null) ? 0 : vUp.hashCode());
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
        Camera other = (Camera) obj;
        if (p0 == null) {
            if (other.p0 != null) {
                return false;
            }
        } else if (!p0.equals(other.p0)) {
            return false;
        }
        if (vRight == null) {
            if (other.vRight != null) {
                return false;
            }
        } else if (!vRight.equals(other.vRight)) {
            return false;
        }
        if (vToward == null) {
            if (other.vToward != null) {
                return false;
            }
        } else if (!vToward.equals(other.vToward)) {
            return false;
        }
        if (vUp == null) {
            if (other.vUp != null) {
                return false;
            }
        } else if (!vUp.equals(other.vUp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Camera [p0=" + p0 + ", vUp=" + vUp + ", vToward=" + vToward + ", vRight=" + vRight + "]";
    }

}
