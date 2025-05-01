package leetcode.challenge.leetcode_1352;

import java.util.Map;

class ProductOfNumbers {
    private Map<Integer, Integer> product;
    private int size;

    public ProductOfNumbers() {
        product = new java.util.HashMap<>();
        size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            product.clear();
            size = 0;
            return;
        }
        int lastProduct = size == 0 ? 1 : product.get(size);
        product.put(++size, lastProduct * num);
    }

    public int getProduct(int k) {
        if (k > size) {
            return 0;
        }

        int lastProduct = product.get(size);
        int firstProduct = product.getOrDefault(size - k, 1);

        return lastProduct / firstProduct;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
