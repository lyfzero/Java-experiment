package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleFilter;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;
import hust.cs.javacourse.search.util.Config;

import java.io.IOException;

/**
 * <pre>
 * 抽象类AbstractTermTupleFilter类型是AbstractTermTupleStream的子类,里面包含另一个
 * AbstractTermTupleStream对象作为输入，并对输入的AbstractTermTupleStream进行过滤,
 * 例如过滤掉所有停用词（the，is are...)对应的三元组
 *
 * 其具体子类需要重新实现next方法以过滤掉不需要的单词对应的三元组.同时可以实现多个不同的过滤器
 * 完成不同的过滤功能，多个过滤器可以形成过滤管道.
 * </pre>
 */
public class LengthTermTupleFilter extends AbstractTermTupleFilter {
    /**
     * 构造函数
     * @param input：Filter的输入，类型为AbstractTermTupleStream
     */
    public LengthTermTupleFilter(AbstractTermTupleStream input){
        super(input);
    }

    /**
     * 过滤掉过长或者过短的单词
     */
    @Override
    public AbstractTermTuple next() {
        AbstractTermTuple curTermTuple= input.next();
        if(curTermTuple==null)  
            return null;
        int length = curTermTuple.term.getContent().length();
        while(length< Config.TERM_FILTER_MINLENGTH||length>Config.TERM_FILTER_MAXLENGTH){
            curTermTuple = input.next();
            if(curTermTuple==null)  
                return null;
            length = curTermTuple.term.getContent().length();
        }
        return curTermTuple;
    }
}
