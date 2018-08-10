package edu.hebut.wang.sort;

import java.util.Arrays;

/**
 * 挖坑法
 *
 * 改进方法
 * 1、三数取中法
 * 上面的代码思想都是直接拿序列的最后一个值作为枢轴，如果最后这个值刚好是整段序列最大或者最小的值，那么这次划分就是没意义的。
 * 所以当序列是正序或者逆序时，每次选到的枢轴都是没有起到划分的作用。快排的效率会极速退化。 *
 * 所以可以每次在选枢轴时，在序列的第一，中间，最后三个值里面选一个中间值出来作为枢轴，保证每次划分接近均等。
 *
 * 2、直接插入
 * 由于是递归程序，每一次递归都要开辟栈帧，当递归到序列里的值不是很多时，我们可以采用直接插入排序来完成，从而避免这些栈帧的消耗。
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
