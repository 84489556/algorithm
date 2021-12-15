package com.demo.algorithm.run;

import java.util.Arrays;

public class Tanxin {
    //贪心算法 找出数组中 递增顺序最长

    public static int[] arr1 = new int[]{1, 2, 3, 2, 3, 4, 3, 4, 5, 6, 7};
    public static int[] arr2 = new int[]{5, 5, 10};

    public static int[] arr3 = new int[]{5, 5, 10,20,2,4};

    public static void main(String[] args) {
        System.out.println("第一题：" + findLength(arr1));
        System.out.println("第二题：" + change(arr2));
        System.out.println("第三题：" + sanjiaoxing(arr3));
    }


    public static int findLength(int[] nums) {
        int start = 0;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            //如果当前的角标的值 <=   下一个脚本的值
            if (nums[i] <= nums[i - 1]) {
                //记录下来最新的角标的值
                start = i;
            }
            //记录下最长递增序列，Math.max()  对比两个数的大小。
            //max：已经记录的最长的长度
            //i-start+1：当前此阶段的长度
            max = Math.max(max, i - start + 1);
        }
        return max;
    }


    public static boolean change(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            //如果顾客拿了一个5块的过来买了，就直接在5元张数上+1
            if (bill == 5) {
                five++;
                //如果拿了一个10元的过来了，就找回5元，10元+1
            } else if (bill == 10) {
                five++;
                ten--;
            } else {
                //如果拿了20的来了，有两种找零方案，
                //1 找零  1张10元+1张5元
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                    //如果10元的不够1张，就看5元够不够3张
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    //找不开零钱不卖
                    return false;
                }
            }
        }
        return true;
    }


    public static int sanjiaoxing(int[] a) {
        //先对数组进行排序
        Arrays.sort(a);

        //从末尾开始找，找到顺数第3个角标。
        for (int i = a.length - 1; i >= 2; i--) {
            //如果 （倒数第2个值 + 倒数第3个值） > （最后一个值）  就符合三角定义 a+b > c
            if (a[i - 1] + a[i - 2] > a[i]) {
                //把（倒数第2个值）+ （倒数第3个值） + （倒数第1个值） = 三角形的周长
                return a[i - 1] + a[i - 2] + a[i];
            }
        }

        //没找到合适的条件
        return -1;
    }


}
