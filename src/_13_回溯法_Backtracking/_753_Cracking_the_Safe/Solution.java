class Solution {
    int n, k;
    
    public String crackSafe(int n, int k) {
        // time : O(n * k^n) 42.14%, k^n nodes in total, n branches in each node
        // space: O(n * k^n) 65.29%
        this.n = n;
        this.k = k;
        
        String starter = String.join("", Collections.nCopies(n, "0"));
        StringBuilder pwd = new StringBuilder(starter);
        
        Set<String> visited = new HashSet<>();
        visited.add(pwd.toString());
        int targetNumVisited = (int) Math.pow(k, n);
        
        crackSafeAfter(pwd, visited, targetNumVisited);
        return pwd.toString();
    }
    
    private boolean crackSafeAfter(StringBuilder pwd, Set<String> visited, int targetNumVisited) {
        if (visited.size() == targetNumVisited) {
            return true;
        }
        String lastDigits = pwd.substring(pwd.length() - n + 1, pwd.length());
        for (char ch = '0'; ch < '0' + k; ch++) {
            String curComb = lastDigits + ch;
            if (!visited.contains(curComb)) {
                visited.add(curComb);
                pwd.append(ch);
                if (crackSafeAfter(pwd, visited, targetNumVisited)) {
                    return true;
                }
                visited.remove(curComb);
                pwd.deleteCharAt(pwd.length() - 1);
            }
        }
        return false;
    }
    
}