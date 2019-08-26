import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        Solution s = new Solution();
        s.mergeSort(nums, 0, n-1);

        int q2 = s.findMedian(nums);
        int[] l;
        int[] u;

        if (n%2 == 0) {
            int mid = n/2;
            l = new int[mid];
            u = new int[mid];
            for (int j=0; j<(mid); j++) {
                l[j] = nums[j];
            }
            int k = 0;
            for(int j=mid; j<n;j++){
                u[k++] = nums[j];
            }
        } else {
            int mid = n/2;
            l = new int[mid];
            u = new int[mid];
            for (int j=0;j<n/2;j++) {
                l[j] = nums[j];
            }
            int k=0;
            for(int j=n/2+1; j<n;j++){
                u[k++] = nums[j];
            }
        }

        int q1 = s.findMedian(l);
        int q3 = s.findMedian(u);
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }

    public int findMedian(int[] nums){
        int median;
        if (nums.length % 2 == 0) {
            median = ((int)nums[nums.length/2] + (int)nums[nums.length/2 - 1])/2;
        }
        else {
            median = (int)nums[nums.length/2];
        }
        return median;
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
}

