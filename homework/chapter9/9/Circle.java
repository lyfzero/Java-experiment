public class Circle {
    private double radius; 
    public static int count = 0;
    public Circle(double r){
        radius = r;
        count++;
    }
    public Circle(){
        this(1.0);
    }
    public static void main(String[] args) 
    {
        Circle c1 = new Circle ();
        Circle c2 = new Circle (15.0);
        c1.count++;
        c2.count++;
        Circle.count++;
        System.out.println("count ="+ count);
    }
}