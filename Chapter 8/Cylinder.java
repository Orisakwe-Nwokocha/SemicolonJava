public class Cylinder {
    private int radius = 1;
    private int height = 1;

    public void setRadius(int radius) {
        if (radius < 1) throw new IllegalArgumentException("radius must be a positive number");
        this.radius = radius;       
    }    
    
    public void setHeight(int height) {
        if (height < 1) throw new IllegalArgumentException("height must be a positive number");
        this.height = height;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public int getHeight() {
        return height;
    }
    
    public double cylinderVolume() {
        return Math.PI * (getRadius() * getRadius() * getHeight());
    }

}