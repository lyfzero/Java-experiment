package hust.cs.javacourse.search.query.impl;

import hust.cs.javacourse.search.index.AbstractTerm;
import hust.cs.javacourse.search.index.impl.Posting;
import hust.cs.javacourse.search.index.impl.PostingList;
import hust.cs.javacourse.search.query.AbstractHit;
import hust.cs.javacourse.search.query.AbstractIndexSearcher;
import hust.cs.javacourse.search.query.Sort;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  IndexSearcher是检索具体实现的实现类
 * </pre>
 */
public class IndexSearcher extends AbstractIndexSearcher {
    /**
     * 从指定索引文件打开索引，加载到index对象里. 一定要先打开索引，才能执行search方法
     * @param indexFile ：指定索引文件
     */
    @Override
    public void open(String indexFile) {
        this.index.load(new File(indexFile));
    }

    /**
     * 根据单个检索词进行搜索
     * @param queryTerm ：检索词
     * @param sorter ：排序器
     * @return ：命中结果数组
     */
    @Override
    public AbstractHit[] search(AbstractTerm queryTerm, Sort sorter) {
        PostingList postingList = (PostingList) index.search(queryTerm);
        if(postingList==null)   return new Hit[0];   ;
        AbstractHit[] hits = new Hit[postingList.size()];
        for(int i=0;i<postingList.size();i++){
            Posting curPosting = (Posting) postingList.get(i);
            hits[i] = new Hit(curPosting.getDocId(),index.getDocName(curPosting.getDocId()));
            hits[i].getTermPostingMapping().put(queryTerm,curPosting);
            hits[i].setScore(sorter.score(hits[i]));
        }
        sorter.sort(Arrays.asList(hits));
        return hits;
    }

    /**
     *
     * 根据二个检索词进行搜索
     * @param queryTerm1 ：第1个检索词
     * @param queryTerm2 ：第2个检索词
     * @param sorter ：    排序器
     * @param combine ：   多个检索词的逻辑组合方式
     * @return ：命中结果数组
     */
    @Override
    public AbstractHit[] search(AbstractTerm queryTerm1, AbstractTerm queryTerm2, Sort sorter, LogicalCombination combine) {
        PostingList postingList1= (PostingList) index.search(queryTerm1);
        PostingList postingList2= (PostingList) index.search(queryTerm2);
        List<AbstractHit> abstractHitList = new ArrayList<>();
        if(combine == LogicalCombination.AND){
            if(postingList1==null||postingList2==null)  return new Hit[0];
            for(int i=0;i<postingList1.size();i++){
                Posting curPosting1 = (Posting) postingList1.get(i);
                int curDocId = curPosting1.getDocId();
                int index2 = postingList2.indexOf(curDocId);
                if(index2!=-1) {
                    Posting curPosting2 = (Posting) postingList2.get(index2);
                    Hit curHit = new Hit(curDocId,index.getDocName(curDocId));
                    curHit.getTermPostingMapping().put(queryTerm1,curPosting1);
                    curHit.getTermPostingMapping().put(queryTerm2,curPosting2);
                    curHit.setScore(sorter.score(curHit));
                    abstractHitList.add(curHit);
                }
            }
        }
        else{
            if(postingList1==null)  return search(queryTerm2,sorter);
            if(postingList2==null)  return search(queryTerm1,sorter);
            for(int i=0;i<postingList1.size();i++){
                Posting curPosting1 = (Posting) postingList1.get(i);
                int curDocId = curPosting1.getDocId();
                int index2 = postingList2.indexOf(curDocId);
                Hit curHit = new Hit(curDocId,index.getDocName(curDocId));
                if(index2==-1) {
                    curHit.getTermPostingMapping().put(queryTerm1,curPosting1);
                }
                else{
                    Posting curPosting2 = (Posting) postingList2.get(index2);
                    curHit.getTermPostingMapping().put(queryTerm1,curPosting1);
                    curHit.getTermPostingMapping().put(queryTerm2,curPosting2);
                }
                curHit.setScore(sorter.score(curHit));
                abstractHitList.add(curHit);
            }
            for(int i=0;i<postingList2.size();i++){
                Posting curPosting2 = (Posting) postingList1.get(i);
                int curDocId = curPosting2.getDocId();
                int index1 = postingList1.indexOf(curDocId);
                if(index1==-1){
                    Hit curHit = new Hit(curDocId,index.getDocName(curDocId));
                    curHit.getTermPostingMapping().put(queryTerm2,curPosting2);
                    curHit.setScore(sorter.score(curHit));
                    abstractHitList.add(curHit);
                }
            }
        }
        sorter.sort(abstractHitList);
        AbstractHit[] res = new AbstractHit[abstractHitList.size()];
        return abstractHitList.toArray(res);
    }

}
