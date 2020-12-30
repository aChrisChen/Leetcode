class Solution {
    public int eatenApples(int[] apples, int[] days) {
        // time: O(nlogn) 30.74%
        // space: O(n) 37.67%
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < apples.length || !map.isEmpty(); i++) {
            // add available apple
            if (i < apples.length) {
                int expiry = i + days[i];
                map.put(expiry, map.getOrDefault(expiry, 0) + apples[i]);
            }
            // remove expired apple
            while (!map.isEmpty() && (map.firstEntry().getKey() <= i || map.firstEntry().getValue() == 0)) {
                map.pollFirstEntry();
            }
            // eat
            if (!map.isEmpty()) {
                res++;
                int latestExpiry = map.firstEntry().getKey();
                map.put(latestExpiry, map.get(latestExpiry) - 1);
            }
        }
        return res;
    }

    // 写法二
    public int eatenApples2(int[] apples, int[] days) {
        // time: O(nlogn), 42.80%
        // space: O(n), 53.54
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < apples.length || !pq.isEmpty(); i++) {
            if (i < apples.length) {
                pq.offer(new int[]{apples[i], i + days[i]});
            }
            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res++;
                int[] cur = pq.poll();
                cur[0]--;
                if (cur[0] > 0) {
                    pq.offer(cur);
                }
            }
        }
        return res;
    }
}


