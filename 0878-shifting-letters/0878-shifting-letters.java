import java.util.*;
class Solution {
    public String shiftingLetters(String s, int[] nums) {
        char arr[]=s.toCharArray();
        int m=nums.length;

        int sum=0;
        for(int i=m-1;i>=0;i--)
        {
            sum=(sum+nums[i])%26;
            arr[i]=(char)(((arr[i]+sum-97)%26)+97);
        }
        return new String(arr);
    }
}