class Solution {
    public int myAtoi(String s) {
         
        int sum = 0;
        s = s.trim();
          if (s.length() == 0)
            return 0;
        boolean minus = false;
        int i = 0;
        if (s.charAt(0) == '-') {
            minus = true;
            i = 1;
        }
        else if (s.charAt(0) == '+') {
            i = 1;
        }

        for (; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';
                if (sum > (Integer.MAX_VALUE - digit) / 10) {
                    return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                sum = sum * 10 + (digit);
            } else
                break;
        }
        if (minus)
            sum *= -1;
        return sum;
    }
}