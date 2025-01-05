class Node{
    boolean end=false;
    Node arr[]=new Node[26];
}
class Solution {
    private Node root;
    int row[]={1,-1,0,0};
    int col[]={0,0,1,-1};
     int n;
        int m;
    public Solution(){
        root=new Node();
    }
    public void insert(String s){
        Node temp=root;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            int ind=s.charAt(i)-'a';
            if(temp.arr[ind]==null){
                temp.arr[ind]=new Node();
            }
            temp=temp.arr[ind];
        }
        temp.end=true;
    }
    public void dfs(Node root,char[][] board,int a,int b,StringBuilder temp,Set<String> res, boolean vis[][]){
        if(root==null) return;
        if(root.end)
        {
            res.add(temp.toString());
            // return;
        }
        vis[a][b]=true;
        for(int i=0;i<4;i++)
        {
            int r=row[i]+a;
            int c=col[i]+b;
            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && root.arr[board[r][c]-'a']!=null)
            {
                temp.append(board[r][c]);
                dfs(root.arr[board[r][c]-'a'],board,r,c,temp,res,vis);
                temp.deleteCharAt(temp.length()-1);

            }
        }
        vis[a][b]=false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String s:words)
        insert(s);
          n=board.length;
          m=board[0].length;
        Set<String> res=new HashSet<>();
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                
                if(root.arr[board[i][j]-'a']!=null)
                {
                    dfs(root.arr[board[i][j]-'a'],board,i,j,new StringBuilder(""+board[i][j]),res,vis);
                }
            }
        }
        return new ArrayList<>(res);
    }
}