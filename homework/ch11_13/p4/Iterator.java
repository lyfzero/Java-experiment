package homework.ch11_13.p4;
/**
 * 迭代器接口，用于遍历组件树里的每一个组件 注意这不是java.util.Iterator接口
 */
public interface Iterator {
    /**
     * 是否还有元素
     * @return 如果元素还没有迭代完，返回true;否则返回false
     */
    boolean hasNext();
    /**
     * 获取下一个组件
     * @return 下一组件
     */
    Component next();
}
