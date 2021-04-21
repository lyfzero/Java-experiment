package homework.ch11_13.p4;

/**
 * 计算机组件的抽象类，任何一个具体的组件键盘、鼠标、主板、主机都是Component
 * 注意主机又由一些更小的Component组成，如内存条、CPU，这种组件为复合组件
 */
abstract public class Component {
    /**
     * 组件的唯一id
     */
    protected int id;        
    /**
     * 组件的名字
     */
    protected String name;  
    /**
     * 组件的价格 
     * */ 
    protected double price;  
    /**
     * 缺省构造函数
     */
    public Component() {  
    }
    /**
     * 构造函数
     * @param id
     * @param name
     * @param price
     */
    public Component(int id, 
                    String name, 
                    double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    /**
     * 获取组件id
     * @return
     */
    public int getId() {
        return this.id;
    }
    /**
     * 设置组件id
     * @param id
     */
    public void setId(int id) { 
        this.id = id;
    }
    /**
     * 获取组件名称
     * @return
     */
    public String getName() { 
        return this.name;
    }
    /**
     * 设置组件名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取组件价格
     * @return
     */
    public double getPrice() { 
        return this.price;
    }
    /**
     * 设置组件价格
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * 添加子组件，对于没有子组件的AtomicComponent如内存条，调用这个方法应该抛出UnsupportedOperati‌onException.相同的子组件不能重复加入
     * @param component
     * @throws UnsupportedOperationException
     */
    public abstract void add(Component component) throws UnsupportedOperationException;
    /**
     * 删除子组件，对于没有子组件的AtomicComponent如内存条，调用这个方法应该抛出UnsupportedOperati‌onException.
     * @param component
     * @throws UnsupportedOperationException
     */
    public abstract void remove(Component component) throws UnsupportedOperationException;

    /**
     * 计算组件的价格，对于复合组件应该计算其子组件的价格之和
     * @return
     */
    public abstract double calcPrice();
    /**
     * 返回组件的迭代器
     * @return
     */
    public abstract Iterator iterator();
    
    /**
     * 基于组件id判断二个组件对象是否相等
     */
    public boolean equals(Object obj) { 
        if(obj instanceof Component) {
            if(this.id == ((Component)obj).id) {
                return true;
            }
        }
        return false;
    }
    /**
     * 返回组件的信息
     */
    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", price: " + getPrice();
    }
}
