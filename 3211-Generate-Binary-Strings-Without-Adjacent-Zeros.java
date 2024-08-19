class Solution {
    List<String> s=new ArrayList<>();
    public List<String> validStrings(int n) {
        create("",n);
        return s;
    }
    public void create(String str,int n){
        if(str.length()>=n){
            s.add(str);
            return;
        }
        if(str.isEmpty()|| str.charAt(str.length()-1)=='1')
        create(str+'0',n);
        create(str+'1',n);
    }
}
// class Solution {
//     public List<String> validStrings(int n) {
//         int arr[]=new int[n];
//         for(int i=0;i<n;i++)
//         arr[i]=i;
//         List<String> res=new ArrayList<>();

//         subset(arr,0,res,new ArrayList<>());
//         return res;
//     }
//     public void subset(int arr[],int i,List<String> res,ArrayList<Integer> ds){
//         if(i>=arr.length){
//              int c[]=new int[arr.length];
//             for(Integer k:ds){
//             c[k]=1;
//             }
//             String s=Arrays.stream(c)
//                               .mapToObj(String::valueOf)
//                               .collect(Collectors.joining(""));
//             if(!s.contains("00"))
//             res.add(s);
//             return;
//         }
//         ds.add(arr[i]);
//         subset(arr,i+1,res,ds);
//         ds.remove(ds.size()-1);
//         subset(arr,i+1,res,ds);
//     }
// }