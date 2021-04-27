import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TwoTuple<T1 extends Comparable, T2 extends Comparable> implements Comparable<TwoTuple<T1, T2>> {
    private T1 first;
    private T2 second;
    public TwoTuple(T1 f, T2 s) {
        this.first = f;
        this.second = s;
    }
    public T1 getterFirst() {
        return this.first;
    }
    public T2 getterSecond() {
        return this.second;
    }
    public void setterFirst(T1 f) {
        this.first = f;
    }
    public void setterSecond(T2 s) {
        this.second = s;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TwoTuple) {
            TwoTuple<T1, T2> o = (TwoTuple<T1, T2>)obj;
            if(this.first == o.first && this.second == o.second) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return this.first + " " + this.second;
    }
    public int compareTo(TwoTuple<T1, T2> o) {
        if(this.first.equals(o.first)) {
            return this.second.compareTo(o.second);
        } else {
            return this.first.compareTo(o.first);
        }
    }
    public static void main(String[] args) {
        TwoTuple<Integer,String> twoTuple1 = new TwoTuple<>(1, "ccc");
        TwoTuple<Integer,String> twoTuple2 = new TwoTuple<>(1, "bbb");
        TwoTuple<Integer,String> twoTuple3 = new TwoTuple<>(1, "aaa");
        TwoTuple<Integer,String> twoTuple4 = new TwoTuple<>(2, "ccc");
        TwoTuple<Integer,String> twoTuple5 = new TwoTuple<>(2, "bbb");
        TwoTuple<Integer,String> twoTuple6 = new TwoTuple<>(2, "aaa");
        List<TwoTuple<Integer,String>> list = new ArrayList<>();
        list.add(twoTuple1);
        list.add(twoTuple2);
        list.add(twoTuple3);
        list.add(twoTuple4);
        list.add(twoTuple5);
        list.add(twoTuple6);

        //测试equals，contains方法是基于equals方法结果来判断
        TwoTuple<Integer,String> twoTuple10 = new TwoTuple<>(1, "ccc"); //内容=twoTuple1
        System.out.println(twoTuple1.equals(twoTuple10)); //应该为true
        if(!list.contains(twoTuple10)){
            list.add(twoTuple10);  //这时不应该重复加入
        }

        //sort方法是根据元素的compareTo方法结果进行排序，课测试compareTo方法是否实现正确
        Collections.sort(list);


        for (TwoTuple<Integer, String> t: list) {
            System.out.println(t);
        }
	
        TwoTuple<TwoTuple<Integer,String >,TwoTuple<Integer,String >> tt1 = new TwoTuple<>(new TwoTuple<>(1,"aaa"),new TwoTuple<>(1,"bbb"));
        TwoTuple<TwoTuple<Integer,String >,TwoTuple<Integer,String >> tt2 = new TwoTuple<>(new TwoTuple<>(1,"aaa"),new TwoTuple<>(2,"bbb"));
        System.out.println(tt1.compareTo(tt2)); //输出-1
        System.out.println(tt1);
    }
}