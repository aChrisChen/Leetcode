package _12_堆_Heap.综合._870_Advantage_Shuffle;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Project Name: Leetcode
 * Package Name: _12_堆_Heap.综合._870_Advantage_Shuffle
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/30/20
 * Description: TODO
 */
public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b)->b[0]-a[0]);
        for (int i=0; i<B.length; i++) pq.add(new int[]{B[i], i});
        int lo=0, hi=A.length-1, res[] = new int[A.length];
        while(!pq.isEmpty()) res[pq.peek()[1]]=pq.poll()[0]<A[hi]?A[hi--]:A[lo++];
        return res;
    }
}
