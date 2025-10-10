//Design a time-based key-value data structure that can store multiple values 
//for the same key at different time stamps and retrieve the key's value at a 
//certain timestamp. 
//
// Implement the TimeMap class: 
//
// 
// TimeMap() Initializes the object of the data structure. 
// void set(String key, String value, int timestamp) Stores the key key with 
//the value value at the given time timestamp. 
// String get(String key, int timestamp) Returns a value such that set was 
//called previously, with timestamp_prev <= timestamp. If there are multiple such 
//values, it returns the value associated with the largest timestamp_prev. If there 
//are no values, it returns "". 
// 
//
// 
// Example 1: 
//
// 
//Input
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4]
//, ["foo", 5]]
//Output
//[null, null, "bar", "bar", null, "bar2", "bar2"]
//
//Explanation
//TimeMap timeMap = new TimeMap();
//timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along 
//with timestamp = 1.
//timeMap.get("foo", 1);         // return "bar"
//timeMap.get("foo", 3);         // return "bar", since there is no value 
//corresponding to foo at timestamp 3 and timestamp 2, then the only value is at 
//timestamp 1 is "bar".
//timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along 
//with timestamp = 4.
//timeMap.get("foo", 4);         // return "bar2"
//timeMap.get("foo", 5);         // return "bar2"
// 
//
// 
// Constraints: 
//
// 
// 1 <= key.length, value.length <= 100 
// key and value consist of lowercase English letters and digits. 
// 1 <= timestamp <= 10⁷ 
// All the timestamps timestamp of set are strictly increasing. 
// At most 2 * 10⁵ calls will be made to set and get. 
// 
//
// Related Topics Hash Table String Binary Search Design 👍 5148 👎 698


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class TimeMap {
    private class Pair{
        private String value;
        private int timestamp;

        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Pair>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair newPair = new Pair(value, timestamp);
        if (!timeMap.containsKey(key)){
            List<Pair> newList = new ArrayList<>();
            newList.add(newPair);
            timeMap.put(key, newList);
        }else{
            timeMap.get(key).add(newPair);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)){
            return "";
        }
        List<Pair> pairList = timeMap.get(key);
        int left = 0, right = pairList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair midPair = pairList.get(mid);
            if (timestamp == midPair.timestamp) {
                return midPair.value;
            } else if (timestamp > midPair.timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0){
            return "";
        }else{
            return pairList.get(right).value;
        }
    }

    public static void main(String[] args){
        TimeMap tm = new TimeMap();
        tm.set("love", "high", 10);
        tm.set("love", "low", 20);
        System.out.println(tm.get("love", 15));

    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)
