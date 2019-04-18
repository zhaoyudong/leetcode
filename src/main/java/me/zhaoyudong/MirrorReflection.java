package me.zhaoyudong;

public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int times = 0;
        for (; ; ) {
            times++;
            int height = times * q;
            if (height % p == 0) {
                int heightGrid = height / p;
                if (times % 2 == 0) {
                    if (heightGrid % 2 == 1) {
                        return 2;
                    }
                } else {
                    if (heightGrid % 2 == 1) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

}
