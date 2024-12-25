class Solution {
   public static String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();

        String res[]=path.split("/");
        for(String r:res){
            if(r.equals("") || r.equals("."))
                continue;
            else if (r.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push("/"+r);
        }
        
        if(stack.isEmpty())
            return "/";
        return String.join("",stack);
    }
}