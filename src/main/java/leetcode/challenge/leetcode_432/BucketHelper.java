package leetcode.challenge.leetcode_432;

public class BucketHelper {

    public static void insertBucketAfter(Bucket prevBucket, Bucket newBucket) {

        assert prevBucket != null;
        assert newBucket != null;

        Bucket nextBucket = prevBucket.next;
        prevBucket.next = newBucket;
        newBucket.prev = prevBucket;
        newBucket.next = nextBucket;
        if (nextBucket != null) {
            nextBucket.prev = newBucket;
        }
    }

    public static void removeBucket(Bucket currentBucket) {

        assert currentBucket != null;

        Bucket prevBucket = currentBucket.prev;
        Bucket nextBucket = currentBucket.next;
        if (prevBucket != null) {
            prevBucket.next = nextBucket;
        }

        if (nextBucket != null) {
            nextBucket.prev = prevBucket;
        }
    }
}
