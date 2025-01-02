import java.util.*;
class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for(int i:nums)pq.add(i);
    int i=1;
    while(i<nums.length){
        nums[i]=pq.poll();
        i+=2;
    }
    i=0;
    while(i<nums.length){
        nums[i]=pq.poll();
        i+=2;
    }


    }
}