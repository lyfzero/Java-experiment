package hust.cs.javacourse.search.parse.impl;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * <pre>
 *     AbstractTermTupleScanner是AbstractTermTupleStream的抽象子类，即一个具体的TermTupleScanner对象就是
 *     一个AbstractTermTupleStream流对象，它利用java.io.BufferedReader去读取文本文件得到一个个三元组TermTuple.
 *
 *     其具体子类需要重新实现next方法获得文本文件里的三元组
 * </pre>
 */
public abstract class TermTupleScanner extends AbstractTermTupleStream {
    /**
     * 缺省构造函数
     */
    public TermTupleScanner(){

    }

    /**
     * 构造函数
     * @param input：指定输入流对象，应该关联到一个文本文件
     */
    public TermTupleScanner(BufferedReader input){
        super(input);
    }

    /**
     * 
     * @return
     */
    @Override
    public AbstractTermTuple next() {
        // TODO
    }


}
