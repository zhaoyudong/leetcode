package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        List<Integer> result = new ArrayList<>();

        for (; ; ) {
            if (index1 == nums1.length || index2 == nums2.length) {
                break;
            }

            if(nums1[index1]==nums2[index2]){
                result.add(nums1[index1]);

                index1++;
                index2++;
            }else if(nums1[index1]<nums2[index2]){
                index1++;
            }else {
                index2++;
            }
        }

        int[] array = new int[result.size()];
        for(int i=0;i<result.size();i++){
            array[i] = result.get(i);
        }

        return array;
    }
}
