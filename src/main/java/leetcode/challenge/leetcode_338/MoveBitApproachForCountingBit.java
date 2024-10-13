package leetcode.challenge.leetcode_338;

public class MoveBitApproachForCountingBit implements ICountingBit{
    @Override
    public int[] countBits(int num) {

        int arrayBits[] = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while (temp > 0) {
                count += temp & 1;
                temp >>= 1;
            }
            arrayBits[i] = count;
        }

        return arrayBits;
    }
}
