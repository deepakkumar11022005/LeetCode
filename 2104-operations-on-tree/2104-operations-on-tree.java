class LockingTree {
    int par[];
    int lock[];
    List<List<Integer>> adj=new ArrayList<>();
    public LockingTree(int[] parent) {
        par=parent;
        int n=parent.length;
        lock=new int[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=1;i<n;i++) adj.get(parent[i]).add(i);
        Arrays.fill(lock,-1);
    }
    
    public boolean lock(int num, int user) {
          if( lock[num]!=-1 ) return false;
          lock[num]=user; 
          return true;
    }
    
    public boolean unlock(int num, int user) {
          if(lock[num]==-1 || lock[num]!=user  ) return false;
          lock[num]=-1;
          return true;
    }
    public boolean checkParent(int node)
    {
        if(node==-1) return false;
        if(lock[node]!=-1) return true;
        if(checkParent(par[node])) return true;
        return false;
    }
    public boolean checkChild(int num)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(num);
        int countLockNode=0;
        while(!q.isEmpty())
        {
            int temp=q.poll();
            if(lock[temp]!=-1) countLockNode++;
            for(int i:adj.get(temp))
            {
                q.add(i);
            }
        }
        return 1>countLockNode;
    }
    public void makeChildUnlock(int num)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(num);
       
        while(!q.isEmpty())
        {
            int temp=q.poll();
            lock[temp]=-1;
            for(int i:adj.get(temp))
            {
                q.add(i);
            }
        }
        return;
    }
    public boolean upgrade(int num, int user) {
          if(lock[num]!=-1) return false;
          if(checkParent(num) || checkChild(num)) return false;
          makeChildUnlock(num);
          lock[num]=user;
          return true;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */