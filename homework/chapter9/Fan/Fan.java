public class Fan {
    static final int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public void setSpeed(int sp) {
        this.speed = sp;
    }
    public int getSpeed() {
        return this.speed;
    }
    public void setOn(boolean o) {
        this.on = o;
    }
    public boolean getOn() {
        return this.on;
    }
    public void setRadius(double r) {
        this.radius = r;
    }
    public double getRadius() {
        return this.radius;
    }
    public void setColor(String c) {
        this.color = c;
    }
    public String getColor() {
        return this.color;
    }
    public String toString() {
        String res;
        if(this.on) {
            res = "fan: speed " + this.speed;
        } else {
            res = "fan is off";
        }
        res += ", color " + this.color + ", radius " + this.radius;
        return res;
    }
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
