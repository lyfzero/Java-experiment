package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.*;
import hust.cs.javacourse.search.util.*;

import java.io.*;
import java.util.List;

/**
 * <pre>
 * IndexBuilder是索引构造器的实现类
 *      需要实例化一个具体对象完成索引构造的工作
 * </pre>
 */
public class IndexBuilder extends AbstractIndexBuilder {
    /**
     * 构造函数
     * @param docBuilder：文件构造器
     */
    public IndexBuilder(AbstractDocumentBuilder docBuilder){
        super(docBuilder);
    }

    /**
     * <pre>
     * 构建指定目录下的所有文本文件的倒排索引.
     *      需要遍历和解析目录下的每个文本文件, 得到对应的Document对象，再依次加入到索引，并将索引保存到文件.
     * @param rootDirectory ：指定目录
     * @return ：构建好的索引
     * </pre>
     */
    @Override
    public AbstractIndex buildIndex(String rootDirectory) {
        Index index = new Index();
        DocumentBuilder docBuilder = new DocumentBuilder();
        List<String> files = FileUtil.list(rootDirectory); //从文件夹构建
        for (String string : files) {
            index.addDocument(docBuilder.build(docId, string, new File(string)));
            docId++;
        }
        index.optimize();
        return index;
    }

}
