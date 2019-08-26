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
           nums[i] = sc.nextInt();
       }
       Solution s = new Solution();
       double mean = s.findMean(nums);

       ArrayList<Double> squaredDiffs = new ArrayList<Double>();

       for(int i=0;i<n;i++){
           squaredDiffs.add(Math.pow((mean-nums[i]),2));
       }

        double squaredDiffMean = s.findMean2(squaredDiffs);
        double stdDev = Math.round((Math.sqrt(squaredDiffMean)) * 10) / 10.0;
        System.out.println(stdDev);

    }

    public double findMean(int[] nums) {
        double sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        double mean = Math.round((sum/nums.length) * 10) / 10.0;
        return mean;
    }

    public double findMean2(ArrayList<Double> nums) {
        double sum = 0;
        for(Double d: nums){
            sum += d;
        }
        double mean = Math.round((sum/nums.size()) * 10) / 10.0;
        return mean;
    }
}

