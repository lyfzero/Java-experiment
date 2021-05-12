package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractPostingList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * PostingList是AbstractPostingList的实现类.
 *      PostingList对象包含了一个单词的Posting列表.
 *      必须实现下面接口:
 *          FileSerializable：可序列化到文件或从文件反序列化.
 * </pre>
 */
public class PostingList extends AbstractPostingList implements FileSerializable{
    /**
     * 添加Posting,要求不能有内容重复的posting
     * @param posting：Posting对象
     */
    @Override
    public void add(AbstractPosting posting) {
        // TODO
    }

    /**
     * 获得PosingList的字符串表示
     * @return ： PosingList的字符串表示
     */
    @Override
    public String toString() {
        // TODO
    }

    /**
     * 添加Posting列表,,要求不能有内容重复的posting
     * @param postings：Posting列表
     */
    @Override
    public void add(List<AbstractPosting> postings) {
        // TODO
    }

    /**
     * 返回指定下标位置的Posting
     * @param index ：下标
     * @return： 指定下标位置的Posting
     */
    @Override
    public AbstractPosting get(int index) {
        // TODO
    }

    /**
     * 返回指定Posting对象的下标
     * @param posting：指定的Posting对象
     * @return ：如果找到返回对应下标；否则返回-1
     */
    @Override
    public int indexOf(AbstractPosting posting) {
        // TODO
    }

    /**
     * 返回指定文档id的Posting对象的下标
     * @param docId ：文档id
     * @return ：如果找到返回对应下标；否则返回-1
     */
    @Override
    public int indexOf(int docId) {
        // TODO
    }

    /**
     * 是否包含指定Posting对象
     * @param posting： 指定的Posting对象
     * @return : 如果包含返回true，否则返回false
     */
    @Override
    public boolean contains(AbstractPosting posting) {
        // TODO
    }

    /**
     * 删除指定下标的Posting对象
     * @param index：指定的下标
     */
    @Override
    public void remove(int index) {
        // TODO
    }

    /**
     * 删除指定的Posting对象
     * @param posting ：定的Posting对象
     */
    @Override
    public void remove(AbstractPosting posting) {
        // TODO
    }

    /**
     * 返回PostingList的大小，即包含的Posting的个数
     * @return ：PostingList的大小
     */
    @Override
    public int size() {
        return this.list.size();
    }

    /**
     * 清除PostingList
     */
    @Override
    public void clear() {
        // TODO
    }

    /**
     * PostingList是否为空
     * @return 为空返回true;否则返回false
     */
    @Override
    public boolean isEmpty() {
        // TODO
    }

    /**
     * 根据文档id的大小对PostingList进行从小到大的排序
     */
    @Override
    public void sort() {
        // TODO
    }

    /**
     * 
     * @param out
     */
    @Override
    public void writeObject(ObjectOutputStream out) {
        // TODO
    }

    /**
     * 
     * @param in
     */
    @Override
    public void readObject(ObjectInputStream in) {
        // TODO
    }
}
