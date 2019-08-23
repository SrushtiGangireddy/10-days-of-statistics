
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Solution s = new Solution();
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] w = new int[n];

        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++){
            w[i] = sc.nextInt();
        }

        double mean = s.findWeightedMean(nums, w, n);

        System.out.println(mean);

    }

    public double findWeightedMean(int[] n, int[] w, int len) {
        double sum = 0;
        int weight_sum = 0;
        for(int i=0;i<len;i++) {
            sum += n[i]*w[i];
            weight_sum += w[i];
        }

        double mean = Math.round((sum/weight_sum) * 10) / 10.0;
        return mean;
    }
}

