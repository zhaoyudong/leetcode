package me.zhaoyudong;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1));
    }

    public int[] singleNumber2(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int[] result = new int[2];

        int highestOneBit = Integer.toBinaryString(xor).length() - 1;

        for (int num : nums) {
            //让掩码变为xxxxx1 & 0000001 == 1
            //或者XXXXX0 & 0000001 == 0
            if ((num >> highestOneBit & 1) == 1) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    public int singleNumber0(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    public int singleNumber(int[] nums) {
        int one=0, two=0, three;
        for (int num : nums) {
            //至少出现了2次（第一次出现0，第二次出现1，第三次出现1|0=1）
            two|=(one&num);
            //出现了%2次
            one = one^num;
            //是否出现达到三次,则为1，否则0
            three = two&one;
            //取反后&one，如果三次是0，将原值1置位0
            one = one&~three;
            //取反后&one，如果三次是0，将原值1置位0
            two = two&~three;
        }

        return one;
    }
}
