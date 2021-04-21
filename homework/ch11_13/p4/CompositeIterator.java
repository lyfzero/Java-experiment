package homework.ch11_13.p4;

import java.util.List;
import java.util.ArrayList;

/**
 * 复合迭代器, 用于复合组件的迭代
 */
public class CompositeIterator implements Iterator {
    /**
     * 保存遍历到的每个节点的迭代器的列表
     */
    protected List<Iterator> iterators = new ArrayList<Iterator>(); 
    /**
     * 构造函数
     * @param iterator 要迭代的组件树的根节点的迭代器
     */
    public CompositeIterator(Iterator iterator) {
        this.iterators.add(iterator);
    }
    /**
     * 是否还有元素
     * @return 如果元素还没有迭代完，返回true; 否则返回false
     */
    @Override
    public boolean hasNext() {
        // 如果迭代器列表里还有迭代器
        if(iterators.size() > 0) {
            Iterator it = this.iterators.get(0); // 取出队列里的第一个迭代器
            if(!it.hasNext()) { // 如果这个迭代器已经迭代完毕
                this.iterators.remove(0); // 从列表中删除这个迭代器
                return hasNext(); // 递归调用 hasNext
            } else {
                return true;
            }
        } else {
            return false; // 迭代器列表为空，说明所有元素迭代完毕
        }
    }
    /**
     * 获取下一个组件
     * @return 下一个组件
     */
    public Component next() {
        if(hasNext()) {
            // 取出队列里第一个迭代器
            Iterator it = iterators.get(0);
            // 从这个迭代器取出下一个组件
            Component c = it.next();
            this.iterators.add(c.iterator());
            return c;
        } else {
            return null;
        }
    }
}
