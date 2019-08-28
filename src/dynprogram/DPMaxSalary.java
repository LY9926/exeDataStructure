package dynprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly
 * @date 2019/6/10 20:47
 */

class Job{
    int start;
    int end;
    int payment;

    public Job(int start, int end, int payment) {
        this.start = start;
        this.end = end;
        this.payment = payment;
    }
}
public class DPMaxSalary {
    public static void main(String[] args) {
        int startArr[] = {1,3,0,4,3,5,6,8};
        int endArr[] = {4,5,6,7,8,9,10,11};
        int payArr[] = {5,1,8,4,6,3,2,4};
        int len = startArr.length;
        List<Job> jobs = new ArrayList<>();
        for (int i=0;i<len;i++){
                jobs.add(new Job(startArr[i],endArr[i],payArr[i]));
        }

        int []opt = new int[len] ;
        int []pre = new int[len];
        //1.求得pre[] 即完成当前任务时前面可完成的任务
        pre[0] = -1;
        for (int i=1;i<len;i++){
            pre[i] = -1; //不能做任何一个工作;
            int start = jobs.get(i).start;
            for (int j=i-1;j>=0;j--){
                if(jobs.get(j).end<=start){
                    pre[i] = j;
                    break;
                }
            }
        }
        opt[0] = jobs.get(0).payment;

        for (int i=1;i<len;i++){
            int pay1 = opt[i-1];
            int pay2;
            if(opt[i-1]>(pre[i]==-1?jobs.get(i).payment:jobs.get(i).payment+opt[pre[i]])){
                opt[i] = pay1;

            }else {
                opt[i] = pre[i]==-1?jobs.get(i).payment:jobs.get(i).payment+opt[pre[i]];
            }
        }
        System.out.println(opt[7]);

        for (int i=0;i<len;i++){
            System.out.println("第"+i+"步的收益为：" +opt[i]);
        }




    }
}
