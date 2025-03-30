class Solution {
    public void parition(int arr[],int low,int high)
    {
        if(low<high)
        {
            int mid=(low+high)/2;
            parition(arr,low,mid);
            parition(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public void merge(int arr[],int low,int mid,int high)
    {
        int i=low;
        int j=mid+1;
        int k=0;
        int temp[]=new int[high-low+1];

        while(i<=mid && j<=high)
        {
            if(arr[i]<=arr[j])
            {
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid)
        {
             temp[k++]=arr[i++];
        }
        while(j<=high)
        {
             temp[k++]=arr[j++];
        }
        for(int l=0;l<temp.length;l++)
        arr[l+low]=temp[l];
    }
    public int[] sortArray(int[] nums) {
        parition(nums,0,nums.length-1);
        return nums;
    }
}