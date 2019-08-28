package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @author ly
 * @date 2019/6/20 14:33
 * 无重复字符的最长子串
 * 方法一：穷举所有可能出现的子串结果；用hashset过滤穷举出来的子串是否重复，
 * 方法二：滑动窗口法；定义两个指针，start和end，代表当前窗口的开始和结束位置，
 * 同样使用hashset,当窗口中出现重复的字符时，start++,没有重复时，end++,每次更新长度的最大值
 * 方法三：
 */
public class LongestSubstring {
    public static void main(String[] args) {
       longestSubstring_1();
        longestSubstring_2();
        String[] strs = {"2","10"};
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length()==s2.length()){
                    return s2.compareTo(s1);
                }else {
                    return (s2+s1).compareTo(s1+s2);
                }
            }
        });
    }

    private static void longestSubstring_2() {
        String s = "abcabcbb";
        int len = s.length();
        int start = 0;
        int end  = 0;
        int sublen = 0;
        HashSet<Character> set = new HashSet<>();
        while (start<len&&end<len){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }else {
                set.add(s.charAt(end++));
                sublen = sublen<(end-start)?(end-start):sublen;

            }
        }
    }

    private static void longestSubstring_1() {
        String str = "abcabcbb";
        int len =str.length();
        int sublen = 0;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<=len;j++){
                if(unique(str.substring(i,j))){
                    if((j-i)>sublen){
                        sublen = j-i;
                    }
                }
            }
        }
        System.out.println(sublen);

    }

    //判断一个字符串中是否有重复的字符串
    private static boolean unique(String substring) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i=0;i<substring.length();i++){
            Character ch = substring.charAt(i);
            if (hashSet.contains(ch)){
                return false;
            }
            hashSet.add(ch);
        }
        return  true;
    }
}
