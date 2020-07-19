package com.example.springboorutil.jianzhiOffer.two;

import java.util.Scanner;

public class Problem10_98 {

    /*
    统计二进制中1的个数
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        int count = 0;
//        while (i != 0) {
//            count++;
//            i = (i - 1) & i;
//        }
//        System.out.println(count);

        //补充二分查找法
        int n = scanner.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("递归式：" + binarySearch(arr, 0, arr.length, n));
        System.out.println("非递归式：" + bsearchWithoutRecursion(arr, n));
    }

    //递归
    private static int binarySearch(int[] arr, int low, int high, int n) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (n == arr[mid]) {
            return mid;
        } else if (n > arr[mid]) {
            return binarySearch(arr, mid + 1, high, n);
        } else if (n < arr[mid]) {
            return binarySearch(arr, low, mid - 1, n);
        }
        return -1;
    }

    //非递归
    private static int bsearchWithoutRecursion(int a[], int key) {
        int low = 0;
        int high = a.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
