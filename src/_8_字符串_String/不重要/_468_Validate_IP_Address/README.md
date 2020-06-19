题目链接: [468. Validate IP Address](https://leetcode.com/problems/validate-ip-address/)

思路：
1. 验证是否是 IPv4 或 IPv6
- 验证的时候
    - 分成 整体和每个field两部分来验证
    - 如果都不是，返回 Neither

注意：
1. string 在 split 的 时候可以指定 pattern 和 limit，比如 s="boo:and:foo"
- 如果limit > 0，那么pattern最多被用 limit - 1次，分层 limit个部分
    - s.split(“:”, 2) ---> {“boo”, “and:foo”}
- 如果 limit = 0，那么pattern会被用无限次，末尾的””会被去掉
    - s.split(“o”, 0) ----> { "b", "", ":and:f", "", "" } 末尾有两个“”
- 如果 limit < 0，那么pattern会被用无限次，末尾的””不会去掉
    - s.split(“o”, -2) ----> { "b", "", ":and:f" }
