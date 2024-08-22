class Solution {
    public int findComplement(int num) {
         String s=Integer.toString(num,2);
        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        if(ch[i]=='1')
        ch[i]='0';
        else
        ch[i]='1';
        return Integer.parseInt( new String(ch),2);
    }
}