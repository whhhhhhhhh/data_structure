package edu.hebut.wang.sort;

import java.util.Arrays;

/**
 * 左右指针法
 */
public class Quick_Sort1 {

    public static void main(String[] args) {
        int[] A = {4, 1, 3, 0, 2, 5, 9, 8, 6, 7};
        System.out.println(Arrays.toString(sort(A,0,A.length-1)));
    }
    public static int[] sort(int A[], int left, int right) {
        if(left >= right)//表示已经完成一个组
        {
            return A;
        }
        int index = partSort(A,left,right);//枢轴的位置
        sort(A,left,index - 1);
        sort(A,index + 1,right);
        return A;
    }

    public static int partSort(int A[], int left, int right) {
        int keyP = left;
        int key = A[left];
        while(left < right) {
            while (left < right && A[right] >= key ) {
                right --;
            }
            while (left < right && A[left] <= key ) {
                left ++;
            }
            swap(A,left,right);
        }
        swap(A,keyP,right);
        return left;
    }

    public static int[] swap(int[] A, int left, int right) {
        int tmp;
        tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
        return A;
    }



}
