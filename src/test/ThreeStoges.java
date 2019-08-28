package test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ly
 * @date 2019/6/25 10:12
 * 在可变对象的基础上构造不可变类
 */
public class ThreeStoges {
    private final Set<String > stoges = new HashSet<String>();
    public ThreeStoges(){
        stoges.add("Moe");
        stoges.add("Larry");
        stoges.add("curly");
    }

    public boolean isStoges(String name){
        return stoges.contains(name);
    }
}
