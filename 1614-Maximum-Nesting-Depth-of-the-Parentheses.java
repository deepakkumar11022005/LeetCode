class Solution {
    public int maxDepth(String s) {
        Stack<Character> l=new Stack<>();
        for(char c:s.toCharArray()){
            if(c==')'|| c=='(')
            l.push(c);
        }
        Stack<Character> res=new Stack<>();
        int max=0;
         System.out.println(l);
        while(!l.isEmpty()){
            if(l.pop()==')'){
                res.add(')');
                
            }
            else{
               
                // l.pop();
                max=Math.max(res.size(),max);
                 res.pop();
                // res.clear();
            }
        }
       
        return max;
    }
}