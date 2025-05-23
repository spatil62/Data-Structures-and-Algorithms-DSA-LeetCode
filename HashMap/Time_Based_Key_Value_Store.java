public class TimeMap {

    private Map<String, List<List<Object>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(Arrays.asList(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        List<List<Object>> values = store.get(key);
        int left = 0, right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ts = (int) values.get(mid).get(1);
            if (ts <= timestamp) {
                result = (String) values.get(mid).get(0);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
