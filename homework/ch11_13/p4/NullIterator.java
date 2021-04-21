package homework.ch11_13.p4;
/**
 * 空迭代器，这个迭代器的hasNext()方法永远返回false, next()方法永远返回null
 * 用于AtomicComponent，因为AtomicComponent没有子组件，.因此AtomicComponent的iterator方法应该返回NullIterator的实例
 */
public class NullIterator implements Iterator {
    /**
     * 缺省构造函数
     */
    public NullIterator() {

    }
    /**
     * 是否还有元素
     * @return 永远返回false
     */
    @Override
    public boolean hasNext() { 
        return false;
    }
    /**
     * 获取下一个组件
     * @return 永远返回 null
     */
    @Override
    public Component next() { 
        return null;
    }
}
