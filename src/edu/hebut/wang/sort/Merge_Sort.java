package edu.hebut.wang.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Merge_Sort {

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end)/2;
            sort(A,start,mid);
            sort(A,mid + 1, end);
            merge(A,start,mid,end);
        }
    }

    public static void merge(int[] A, int start, int mid, int end) {
        //第一个有序子序列起始位置
        int i = start;
        //第二个有序子序列起始位置
        int j = mid + 1;
        //临时数组起始位置
        int k = 0;
        //生成临时数组
        int[] tmp = new int[A.length];

        while (i <= mid && j <= end) {
            if (A[i] < A[j]) {
                tmp[k++] = A[i++];
            } else {
                tmp[k++] = A[j++];
            }
        }
        //将左边剩余元素填充进tmp中
        while(i <= mid){
            tmp[k++] = A[i++];
        }
        //将右序列剩余元素填充进tmp中
        while(j <= end){
            tmp[k++] = A[j++];
        }

        k = 0;

        while (start <= end) {
            A[start++] = tmp[k++];
        }

    }

}
