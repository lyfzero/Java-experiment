package homework.ch11_13.p4;
import java.lang.StringBuffer;
/**
 * 复合组件，包含子组件
 */
public class CompositeComponent extends Component {
    /**
     * 保存子组件,放在ComponentList里
     */
    protected ComponentList childs; 

    /**
     * 缺省构造函数
     */
    public CompositeComponent() { 
        super();
        this.childs = new ComponentList();
    }
    /**
     * 构造函数
     * @param id
     * @param name
     * @param price
     */
    public CompositeComponent(int id,
                              String name,
                              double price) {
        super(id, name, price);
        this.childs = new ComponentList();
    }
    @Override
    public double getPrice() {
        return calcPrice();
    }
    /**
     * 添加子组件，对于没有子组件的AtomicComponent如内存条，调用这个方法应该抛出UnsupportedOperationException.
     * @param component
     * @throws UnsupportedOperationException
     */
    @Override
    public void add(Component component) throws UnsupportedOperationException {
        // 相同的子组件不能重复加入
        if(!this.childs.contains(component)) {
            this.childs.add(component);
        }
    }
    /**
     * 删除子组件，对于没有子组件的AtomicComponent如内存条，调用这个方法应该抛出UnsupportedOperationException
     * @param component
     * @throws UnsupportedOperationException
     */
    @Override
    public void remove(Component component) throws UnsupportedOperationException {
        this.childs.remove(component);
    }
    /**
     * 计算组件的价格. 对于复合组件应该计算其子组件的价格之和.
     * @return 组件的价格
     */
    @Override
    public double calcPrice() {
        double res = 0;
        for(Component c : this.childs) {
            res += c.getPrice();
        }
        return res;
    }
    /**
     * 返回组件的迭代器,只需要用 childs 对象为参数构造一个CompositeIterator对象即可
     * 因为 childs 对象的类型是ComponentList,实现了自定义Iterator接口
     * @return 组件的迭代器
     */
    @Override
    public Iterator iterator() {
        return new CompositeIterator(this.childs);
    }
    /**
     * 返回组件的id，名称、价格
     * @return 组件的id，名称、价格组成描述字符串
     */
    @Override
    public String toString() {
        String indent = "";
        StringBuffer buf = new StringBuffer();
        buf.append("id: " + this.id + ", name: " + getName() + ", price: " + getPrice()).append("\n");
        if(this.childs.size() > 0) {
            buf.append(indent + "sub-components of" + getName() + ":").append("\n");
            for(Component c: this.childs) {
                buf.append(c.toString()).append("\n");
            }
        }
        return buf.toString();
    }
}
