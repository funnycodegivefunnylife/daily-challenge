package leetcode.challenge.leetcode_432;

import java.util.HashMap;
import java.util.Map;

public class AllOne implements AllOneInterface {

    private Map<String, Bucket> keyBucketMap = new HashMap<>();
    private Bucket head;

    public AllOne() {
        head = new Bucket(0);
        head.prev = head;
        head.next = head;
    }

    public void inc(String key) {
        // case 1: key does not exist
        if (!keyBucketMap.containsKey(key)) {
            if (head.next.count != 1) {
                Bucket newBucket = new Bucket(1);
                BucketHelper.insertBucketAfter(head, newBucket);
                newBucket.keys.add(key);
                keyBucketMap.put(key, newBucket);
            }
            else {
                head.next.keys.add(key);
                keyBucketMap.put(key, head.next);
            }
        } else {
            Bucket currentBucket = keyBucketMap.get(key);
            if (currentBucket.next.count != currentBucket.count + 1) {
                Bucket newBucket = new Bucket(currentBucket.count + 1);
                BucketHelper.insertBucketAfter(currentBucket, newBucket);
                newBucket.keys.add(key);
                keyBucketMap.put(key, newBucket);
            } else {
                currentBucket.next.keys.add(key);
                keyBucketMap.put(key, currentBucket.next);
            }

            currentBucket.keys.remove(key);
            if (currentBucket.keys.isEmpty()) {
                BucketHelper.removeBucket(currentBucket);
            }
        }
    }

    public void dec(String key) {
        if (!keyBucketMap.containsKey(key)) {
            return;
        }

        Bucket currentBucket = keyBucketMap.get(key);

        currentBucket.keys.remove(key);

        if (currentBucket.count == 1) {
            keyBucketMap.remove(key);
        } else {
            if (currentBucket.prev.count != currentBucket.count - 1) {
                Bucket newBucket = new Bucket(currentBucket.count - 1);
                BucketHelper.insertBucketAfter(currentBucket.prev, newBucket);
                newBucket.keys.add(key);
                keyBucketMap.put(key, newBucket);
            } else {
                currentBucket.prev.keys.add(key);
                keyBucketMap.put(key, currentBucket.prev);
            }
        }

        if (currentBucket.keys.isEmpty()) {
            BucketHelper.removeBucket(currentBucket);
        }
    }

    public String getMaxKey() {
        return isEmpty() ? "" : head.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return isEmpty() ? "" : head.next.keys.iterator().next();
    }

    private boolean isEmpty() {
        return head == null || head == head.next;
    }
    
}




