class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>((a,b)-> b-a);
        minHeap=new PriorityQueue<>((a,b)-> a-b);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if((maxHeap.size()-minHeap.size())>1) {
            minHeap.add(maxHeap.poll());
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
                if(maxHeap.peek()>minHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
        }
        else{
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
                if(maxHeap.peek()>minHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }
    
    public double findMedian() {
        int size1=maxHeap.size();
        int size2=minHeap.size();
        // System.out.println(size1+" "+maxHeap +"  "+size2+" "+minHeap);
        if((size1+size2)%2==0){
            int a=0;
            int b=0;
            if(size1>0) a=maxHeap.peek();
            if(size2>0) b=minHeap.peek();
            return (double)(a+b)/2.0;
        }else{
            return size1>size2?(double)maxHeap.peek():(double)minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */