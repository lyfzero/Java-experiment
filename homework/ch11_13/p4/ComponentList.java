package homework.ch11_13.p4;
import java.util.ArrayList;
/**
 * Component对象的容器类，用于保存复合组件的子组件.从ArrayList派生，实现了自定义Iterator接口
 * 定义这个类是为了实现组件树的CompositeIterator.由于是从ArrayList派生，因此继承了ArrayList的所有方法
 */
public class ComponentList extends ArrayList<Component> implements Iterator {
    /**
     * 记录自定义迭代器当前迭代的位置
     */
    private int position = 0; 
    public ComponentList() {

    }
    @Override
    /**
     * 是否还有元素
     * @return 如果元素还没有迭代完，返回true;否则返回false
     */
    public boolean hasNext() { 
        if(this.position >= this.size()) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 获取下一个组件
     * @return 下一个组件
     */
    @Override
    public Component next() { 
        if(hasNext()) {
            Component c = this.get(this.position);
            this.position++;
            return c;
        } else {
            return null;
        }
    }
}
