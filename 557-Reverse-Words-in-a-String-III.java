class Solution {
    public String reverseWords(String s) {
        String arr[]=s.split(" ");
        for(int i=0;i<arr.length;i++)
        arr[i]=(new StringBuffer(arr[i]).reverse()).toString();
        return String.join(" ", arr);

    }
}