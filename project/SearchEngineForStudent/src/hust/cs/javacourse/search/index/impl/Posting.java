package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractPosting;

import java.io.*;
import java.util.*;

/**
 * <pre>
 * Posting是AbstractPosting对象的实现类.
 *      Posting对象代表倒排索引里每一项， 一个Posting对象包括:
 *          包含单词的文档id.
 *          单词在文档里出现的次数.
 *          单词在文档里出现的位置列表（位置下标不是以字符为编号，而是以单词为单位进行编号.
 *      必须实现下面二个接口:
 *          Comparable：可比较大小（按照docId大小排序）,
 *                      当检索词为二个单词时，需要求这二个单词对应的PostingList的交集,
 *                      如果每个PostingList按docId从小到大排序，可以提高求交集的效率.
 *          FileSerializable：可序列化到文件或从文件反序列化
 *  </pre>
 */
public class Posting extends AbstractPosting {
    /**
     * 缺省构造函数
     */
    public Posting(){
        super();
    }

    /**
     * 构造函数
     * @param docId ：包含单词的文档id
     * @param freq  ：单词在文档里出现的次数
     * @param positions   ：单词在文档里出现的位置
     */
    public Posting(int docId, int freq, List<Integer> positions){
        super(docId, freq, positions);
    }

    /**
     * 判断二个Posting内容是否相同
     * @param obj ：要比较的另外一个Posting
     * @return 如果内容相等返回true，否则返回false
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Posting) {
            Posting o = (Posting)obj;
            if(this.docId != o.docId || this.freq != o.freq) {
                return false;
            }
            if(this.positions.size() != o.positions.size()) {
                return false;
            }
            if(!this.positions.containsAll(o.positions) || !o.positions.containsAll(this.positions)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 返回Posting的字符串表示
     * @return 字符串
     */
    @Override
    public String toString() {
        return "docId: " + this.docId + "freq: " + this.freq +
                "\nPositions: " + this.positions.toString();
    }

    /**
     * 返回包含单词的文档id
     * @return ：文档id
     */
    @Override
    public int getDocId() {
        return this.docId;
    }

    /**
     * 设置包含单词的文档id
     * @param docId：包含单词的文档id
     */
    @Override
    public void setDocId(int docId) {
        this.docId = docId;
    }

    /**
     * 返回单词在文档里出现的次数
     * @return ：出现次数
     */
    @Override
    public int getFreq() {
        return this.freq;
    }

    /**
     * 设置单词在文档里出现的次数
     * @param freq:单词在文档里出现的次数
     */
    @Override
    public void setFreq(int freq) {
        this.freq = freq;
    }

    /**
     * 返回单词在文档里出现的位置列表
     * @return ：位置列表
     */
    @Override
    public List<Integer> getPositions() {
        return this.positions;
    }

    /**
     * 设置单词在文档里出现的位置列表
     * @param positions：单词在文档里出现的位置列表
     */
    @Override
    public void setPositions(List<Integer> positions) {
        this.positions = new ArrayList<Integer>();
        this.positions.addAll(positions);
    }

    /**
     * 比较二个Posting对象的大小（根据docId）
     * @param o： 另一个Posting对象
     * @return ：二个Posting对象的docId的差值
     */
    @Override
    public int compareTo(AbstractPosting o) {
        return this.docId - o.getDocId();
    }

    /**
     * 对内部positions从小到大排序
     */
    @Override
    public void sort() {
        Collections.sort(this.positions);
    }

    /**
     * 
     * @param in
     */
    @Override
    public void readObject(ObjectInputStream in) {
        try {
            this.docId = (Integer) in.readObject();
            this.freq = (Integer) in.readObject();
            Integer size = (Integer) in.readObject();
            for (int i = 0; i < size; i++)
                this.positions.add((Integer) in.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param out
     */
    @Override
    public void writeObject(ObjectOutputStream out) {
        try{
            out.writeObject(this.docId);
            out.writeObject(this.freq);
            out.writeObject(this.positions.size());
            for (Integer i : this.positions)
                out.writeObject(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
