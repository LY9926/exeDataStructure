import java.util.ArrayList;
import java.util.Arrays;

public class Main

{
    public static void main(String[] args) {
        merge();
    }

    public static int[][] merge() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int  len = intervals.length;
        if(intervals==null||len<2){
            return intervals;
        }
        int start[] = new int[len];
        int end[] = new int[len];
        for(int i=0;i<len;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        ArrayList<int[]> res = new ArrayList<>();

        for(int i=0,j=0;i<len;i++){
            if(i==len-1||start[i+1]>end[i]){
                int[] temp = new int[2];
                temp[0]= start[j] ;
                temp[1]= end[i] ;
                j=i+1;
                res.add(temp);
            }
        }
        int[][] arr = new int[res.size()][2];
        return res.toArray(arr);

    }
}
