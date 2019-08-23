import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       Solution s = new Solution();
       int[] nums = new int[n];

       for(int i=0;i<n;i++){
           nums[i] = sc.nextInt();
       }
       s.mergeSort(nums, 0, n-1);
       double calc_mean = s.findMean(nums);
       double calc_median = s.findMedian(nums);
       int calc_mode = s.findMode(nums);
       System.out.println(calc_mean);
       System.out.println(calc_median);
       System.out.println(calc_mode);
    }

    public void mergeSort(int[] nums, int l, int r){
        if ( r > l) {
            int mid = (l+r)/2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid+1, r);
            merge(nums, l, mid, r);
        }
    }

    public void merge(int[] nums, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++){
            left[i] = nums[l+i];
        }
        for(int j=0;j<n2;j++){
            right[j] = nums[m+1+j];
        }
        int i=0;
        int j=0;
        int k = l;

        while(i<n1 && j<n2) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < n1) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j < n2) {
            nums[k] = right[j];
            j++;
            k++;
        }

    }

    public double findMean(int[] nums) {
        double sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        double mean = Math.round((sum/nums.length) * 10) / 10.0;
        return mean;
    }

    public double findMedian(int[] nums){
        double median;
        if (nums.length % 2 == 0) {
            median = ((double)nums[nums.length/2] + (double)nums[nums.length/2 - 1])/2;
        }
        else {
            median = (double)nums[nums.length/2];
        }
        median = Math.round(median * 10) / 10.0;
        return median;
    }
    public int findMode(int[] nums) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        TreeSet<Integer> uniqueNums = new TreeSet<>();

        int freq = 1;
        int mode = nums[0];

        for(int i=0;i<nums.length;i++){
            if (!uniqueNums.contains(nums[i])) {
                int count = findFrequency(nums, nums.length, nums[i]);
                if (count > freq) {
                    freq = count;
                    mode = nums[i];
                } else if (count == freq) {
                    if (nums[i] < mode) {
                        mode = nums[i];
                    }
                }
                counts.put(nums[i],count);
            }
        }

        return mode;
    }

    public int findFrequency(int a[], int n, int x) 
    { 
        int count = 0; 
        for (int i=0; i < n; i++) 
            if (a[i] == x)  
            count++; 
        return count; 
    }
}

