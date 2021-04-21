package homework.ch11_13.p4;
import java.lang.UnsupportedOperationException;

/**
 * 原子组件类，不包含任何子组件
 */
public class AtomicComponent extends Component {
    private int id;
    private String name;
    private double price;
    /**
     * 缺省构造函数
     */
    public AtomicComponent() {
        super();
    }
    /**
     * 构造函数
     * @param id
     * @param name
     * @param price
     */
    public AtomicComponent(int id, 
                            String name, 
                            double price) { 
        super(id, name, price);
    }
    /**
     * 添加子组件，对于没有子组件的AtomicComponent如内存条，调用这个方法应该抛出UnsupportedOperati‌onException.
     * @param component 加入的组件
     * @throws UnsupportedOperationException
     */
    @Override
    public void add(Component component) throws UnsupportedOperationException { 
        // 相同的子组件不能重复加入
        throw new UnsupportedOperationException();
    }
    /**
     * 计算组件的价格。对于复合组件应该计算其子组件的价格之和
     * @return
     */
    @Override
    public double calcPrice() {
        return getPrice();
    }
    /**
     * 返回组件的迭代器，只需要返回一个NullIterator对象即可
     * @return 组件的迭代器
     */
    @Override
    public Iterator iterator() { 
        return new NullIterator();
    }
    /**
     * 删除子组件，对于没有子组件的AtomicComponent如内存条，调用这个方法应该抛出UnsupportedOperati‌onException
     * @param component 删除的组件
     * @throws UnsupportedOperationException
     */
    @Override
    public void remove(Component component) throws UnsupportedOperationException { 
        throw new UnsupportedOperationException();
    }
    
}
