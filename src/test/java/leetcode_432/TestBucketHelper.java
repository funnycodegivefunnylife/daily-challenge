package leetcode_432;

import leetcode.challenge.leetcode_432.Bucket;
import leetcode.challenge.leetcode_432.BucketHelper;
import org.junit.jupiter.api.Test;

public class TestBucketHelper {
    //    public static void insertBucketAfter(Bucket prevBucket, Bucket newBucket) {
    @Test
    public void testInsertBucketAfter() {
        // Test case 1
        Bucket prevBucket = new Bucket(1);
        Bucket newBucket = new Bucket(2);
        BucketHelper.insertBucketAfter(prevBucket, newBucket);
        assert prevBucket.getNext() == newBucket;
        assert newBucket.getPrev() == prevBucket;
        assert newBucket.getNext() == null;
        assert prevBucket.getPrev() == null;
    }

    // public static void removeBucket(Bucket currentBucket)
    @Test
    public void testRemoveBucket() {
        // Test case 1
        Bucket prevBucket = new Bucket(1);
        Bucket currentBucket = new Bucket(2);
        Bucket nextBucket = new Bucket(3);
        BucketHelper.insertBucketAfter(prevBucket, currentBucket);
        BucketHelper.insertBucketAfter(currentBucket, nextBucket);
        BucketHelper.removeBucket(currentBucket);
        assert prevBucket.getNext() == nextBucket;
        assert nextBucket.getPrev() == prevBucket;
    }
}
