package edu.hebut.wang.sort;

import java.util.Arrays;

/**
 * 挖坑法
 */
public class Quick_Sort2 {

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

    /**
     *
     * @param A 数组
     * @param left 左起始点
     * @param right 右起始点
     * @return 枢轴的位置
     */
    public static int partSort(int A[], int left, int right) {
        int key = A[left];
        while (left < right) {
            while (left < right && A[right] >= key) {
                right--;
            }
            A[left] = A[right];
            while (left < right && A[left] <= key) {
                left++;
            }
            A[right] = A[left];
        }
        A[left] = key;
        return left;
    }

}
