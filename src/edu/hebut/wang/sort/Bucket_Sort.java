package edu.hebut.wang.sort;

/**
 * 桶排序
 */
public class Bucket_Sort {

    public static void main(String[] args) {
        int[] A = {4, 1, 1, 0, 5, 5, 9, 8, 5, 7};
        sort(A,9);
    }

    public static void sort(int[] unsorted, int maxNumber) {
        int[] sorted = new int[maxNumber+1];
        for (int i = 0; i < unsorted.length; i++) {
            sorted[unsorted[i]]++;
        }
        for (int i = 0; i < sorted.length; i++) {
            while (sorted[i] > 0) {
                System.out.println(i);
                sorted[i]--;
            }
        }
    }

}
