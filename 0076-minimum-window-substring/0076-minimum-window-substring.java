class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int total_t_count = 0;
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            total_t_count++;
        }
        // System.out.println(map);
        int n = s.length();
        int left = 0;
        int right = 0;
        int minIndex = Integer.MAX_VALUE;
        int startIndex = 0;
        int count = 0;
        if(n<total_t_count ) return "";
        // if(s.equals(t)) return t;
        while (left < n) {
            if (count < total_t_count && right < n) {
                char temp = s.charAt(right);
                //   System.out.println(temp);
                if (map.containsKey(temp)) {
                    if (map.get(temp) > 0) {
                        count++;
                      
                    }
                    map.put(temp, map.get(temp) - 1);
                } else {
                    map.put(temp, -1);
                }
                right++;
                //  System.out.println(map);
                // System.out.println(count+" "+s.substring(left, right + 1));
            } else if (left <=right && count == total_t_count) {
                // right--;
               
                if (minIndex > right - left  ) {
                    minIndex = right - left ;
                    startIndex = left;
                    // System.out.println(s.substring(left, right)+" jckjadcn   "+minIndex +"  "+left);
                }
                // System.out.println(s.substring(left,right));
                char temp = s.charAt(left);
                if (map.containsKey(temp)) {
                    if (map.get(temp) < 0) {
                        map.put(temp, map.get(temp) + 1);
                    } else {
                        map.put(temp, map.get(temp) + 1);
                        count--;
                    }
                }
                left++;
            }
            else break;
        }
        return minIndex==Integer.MAX_VALUE?"": s.substring(startIndex,startIndex+minIndex);
    }
}