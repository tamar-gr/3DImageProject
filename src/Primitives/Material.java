package Primitives;

public class Material
{
    private double Kd; // Diffusion attenuation coefficient
    private double Ks; // Specular attenuation coefficient
    private double n;  // Refraction index
    private double Kr; //reflection
    private double Kt; //transparency

    public Material(double kd, double ks, double n)
    {
        this.Kd = kd;
        this.Ks = ks;
        this.Kr = 0;
        this.Kt = 0;
        this.n = n;
    }


    public Material(double kd, double ks, double n, double kr, double kt)
    {
        this.Kd = kd;
        this.Ks = ks;
        this.Kr = kr;
        this.Kt = kt;
        this.n = n;
    }

    public Material()
    {

        this.Ks = 1;
        this.Kd = 1;
        this.Kr = 0;
        this.Kt = 0;
        this.n = 1;
    }
    public Material(Material mat)
    {
        super();
        this.Ks = mat.Ks;
        this.Kd = mat.Kd;
        this.Kr = mat.Kr;
        this.Kt = mat.Kt;
        this.n = mat.n;
    }

    public double getKd()
    {
        return Kd;
    }
    public void setKd(double kd)
    {
        this.Kd = kd;
    }
    public double getKs()
    {
        return Ks;
    }
    public void setKs(double ks)
    {
        this.Ks = ks;
    }
    public double getKr()
    {
        return Kr;
    }
    public void setKr(double kr)
    {
        this.Kr = kr;
    }
    public double getKt()
    {
        return Kt;
    }
    public void setKt(double kt)
    {
        this.Kt = kt;
    }
    public double getN()
    {
        return n;
    }
    public void setN(double n)
    {
        this.n = n;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(Kd);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Ks);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(n);
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
        Material other = (Material) obj;
        if (Double.doubleToLongBits(Kd) != Double.doubleToLongBits(other.Kd))
            return false;
        if (Double.doubleToLongBits(Ks) != Double.doubleToLongBits(other.Ks))
            return false;
        if (Double.doubleToLongBits(n) != Double.doubleToLongBits(other.n))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Material [Kd=" + Kd + ", Ks=" + Ks + ", n=" + n + "]";
    }

}
