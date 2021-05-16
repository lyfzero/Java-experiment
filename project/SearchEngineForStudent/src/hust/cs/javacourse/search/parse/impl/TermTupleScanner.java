package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.index.AbstractTerm;
import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.index.impl.Term;
import hust.cs.javacourse.search.index.impl.TermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleScanner;
import hust.cs.javacourse.search.util.StringSplitter;

import java.io.*;
import java.util.*;

import static hust.cs.javacourse.search.util.Config.STRING_SPLITTER_REGEX;

/**
 * <pre>
 *     AbstractTermTupleScanner是AbstractTermTupleStream的抽象子类，即一个具体的TermTupleScanner对象就是
 *     一个AbstractTermTupleStream流对象，它利用java.io.BufferedReader去读取文本文件得到一个个三元组TermTuple.
 *
 *     其具体子类需要重新实现next方法获得文本文件里的三元组
 * </pre>
 */
public class TermTupleScanner extends AbstractTermTupleScanner {
    protected Queue<AbstractTermTuple> termTuples = new LinkedList<>();

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
        try{
            String Line = input.readLine();
            int pos = 0;
            while(Line!=null){
                Line = Line.trim();        //删除首尾字符
                Line = Line.toLowerCase(); //转小写
                StringSplitter splitter = new StringSplitter();
                splitter.setSplitRegex(STRING_SPLITTER_REGEX);
                List<String> words = splitter.splitByRegex(Line); //完成划分后的多个单词
                for(String word:words){
                    AbstractTermTuple termTuple = new TermTuple();
                    AbstractTerm term = new Term();
                    term.setContent(word);
                    termTuple.term = term;
                    termTuple.curPos = pos++;
                    termTuples.add(termTuple);
                }
                Line = input.readLine();
            }
            if(termTuples.isEmpty()) return null;
            else return termTuples.poll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
