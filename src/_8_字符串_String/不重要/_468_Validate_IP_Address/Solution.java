package _8_字符串_String.不重要._468_Validate_IP_Address;

/**
 * Project Name: Leetcode
 * Package Name: _8_字符串_String.不重要._468_Validate_IP_Address
 * File Name: Solution
 * Creator: Jipeng Chen
 * Date: 6/19/20
 * Description: finish
 */
public class Solution {
    public String validIPAddress(String IP) {
        // time: O(n) 95.54%
        // space: O(n) 78.97%
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP.toUpperCase())) { // 变成uppercase，因为有a或者A
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        // step1: check # of fields
        String[] fields = IP.split("\\.", -1); // use limiter -1 to including the ending "" if exists
        if (fields.length != 4) return false;
        // step2: check each field
        for (String field : fields) {
            if (field.isEmpty() || field.length() > 3) return false;
            for (int i = 0; i < field.length(); i++) {
                if (!Character.isDigit(field.charAt(i))) {
                    return false;
                }
            }
            int num = Integer.valueOf(field);
            if (!String.valueOf(num).equals(field) || num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }
    private boolean isIPv6(String IP) {
        // step1: check # of fields
        String[] fields = IP.split("\\:", -1); // use limiter -1 to including the ending "" if exists
        if (fields.length != 8) return false;
        // step2: check each field
        for (String field : fields) {
            if (field.isEmpty() || field.length() > 4) return false;
            for (int i = 0; i < field.length(); i++) {
                char ch = field.charAt(i);
                if (!Character.isDigit(ch) && (ch < 'A' || ch > 'F')) {
                    return false;
                }
            }
        }
        return true;
    }

}
