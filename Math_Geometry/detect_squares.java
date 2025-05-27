class DetectSquares {
    HashMap<List<Integer>, Integer> map;

    public DetectSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0],point[1]);
        map.put(p, map.getOrDefault(p,0)+1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];

        for (List<Integer> p : map.keySet()) {
            int x = p.get(0), y = p.get(1);

            // Check if the points can form a square
            if (Math.abs(px - x) != Math.abs(py - y) || px == x || py == y) {
                continue;
            }

            // Calculate combinations for forming a square
            res += map.getOrDefault(Arrays.asList(x, py), 0) *
                   map.getOrDefault(Arrays.asList(px, y), 0) *
                   map.get(p);
        }

        return res;
    }
}


/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
