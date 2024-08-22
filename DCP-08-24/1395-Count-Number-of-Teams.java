class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
             
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        count++;
                    }
       
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

// class Solution {
//     int c = 0;

//     public int numTeams(int[] nums) {

//         solve( nums, 0, new ArrayList<>());

//         return c;
//     }

//     public boolean checka(List<Integer> l) {
//         for (int i = 1; i < 3; i++) {
//             if (l.get(i - 1) < l.get(i)) {
//                 return false;
//             }

//         }
//         return true;
//     }

//     public boolean checkb(List<Integer> l) {
//         for (int i = 1; i < 3; i++) {
//             if (l.get(i - 1) > l.get(i)) {
//                 return false;
//             }

//         }
//         return true;
//     }

//     public void solve( int[] nums, int index, ArrayList<Integer> ds) {
//         if (index >= nums.length) {
//             if (ds.size() >= 3) {
//                 if (checka(ds) || checkb(ds))
//                     c++;
//             }
//             return;
//         }
//         if (ds.size() == 3) {
//            if (ds.size() >= 3) {
//                 if (checka(ds) || checkb(ds))
//                     c++;
//             }
//             return;
//         }

//         ds.add(nums[index]);
//         solve( nums, index + 1, ds);
//         ds.remove(ds.size() - 1);
//         solve( nums, index + 1, ds);
//     }
// }