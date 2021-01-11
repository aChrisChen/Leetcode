class Solution {
    // 法一
    public int maximumGain(String s, int x, int y) {
        // time: O(n) 42.24%
        // space: O(n) 33.87%
        StringBuilder sb = new StringBuilder(s);
        if (x > y) {
            return remove(sb, "ab", x) + remove(sb, "ba", y);
        }
        return remove(sb, "ba", y) + remove(sb, "ab", x);
    }
    
    private int remove(StringBuilder sb, String pattern, int point) {
        int i = 0, res = 0;
        for (int j = 0; j < sb.length(); j++) {
            sb.setCharAt(i++, sb.charAt(j)); // i是要比j提前一位的，是下一轮要被赋值的idx
            if (i > 1 && sb.charAt(i-2) == pattern.charAt(0) && sb.charAt(i-1) == pattern.charAt(1)) {
                i -= 2; // 检查是否有新的组合，比如 bbaa，i=3是发现中间的ba，然后i-2=1，从这开始检查和赋值
                res += point;
            }
        }
        sb.setLength(i);
        return res;
    }

    // 法二
    public int maximumGain2(String s, int x, int y) {
        // time: O(n) 34.94%
        // space: O(n) 22.46%
        Stack<Character> stack = new Stack<>(), stack2 = new Stack<>();
        char first = (x > y) ? 'a' : 'b', second = (x > y) ? 'b' : 'a';
        int larger = Math.max(x, y), smaller = Math.min(x, y);
        int res = 0;
        // step1: remove substring with larger point
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && ch == second) {
                stack.pop();
                res += larger;
            } else {
                stack.push(ch);
            }
        }
        // step2: remove another
        while (!stack.isEmpty()) { // 单纯的便利stack中的剩余字母，利用stack2存储当前可用的
            char ch = stack.pop();
            if (!stack2.isEmpty() && stack2.peek() == first && ch == second) {
                stack2.pop();
                res += smaller;
            } else {
                stack2.push(ch);
            }
        }
        return res;
    }
}