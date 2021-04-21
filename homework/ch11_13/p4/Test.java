package homework.ch11_13.p4;
/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 1
        Component computer = ComponentFactory.create();
        System.out.println(computer);
        // 2
        System.out.println("id: " + computer.getId() + ", name: " + computer.getName() + ", price: " + computer.getPrice());
        Iterator it = computer.iterator();
        while(it.hasNext()) {
            Component c = it.next();
            System.out.println("id: " + c.getId() + ", name:" + c.getName() + ", price: " + c.getPrice());
        }
        
    }
}
