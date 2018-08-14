package edu.hebut.wang.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Merge_Sort {

    public static void main(String[] args) {
        int[] arr = Bubble_Sort.createRandomArray(100000);
        sort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] A, int start, int end, int[] tmp) {
        if (start < end) {
            int mid = (start + end)/2;
            sort(A,start,mid, tmp);
            sort(A,mid + 1, end, tmp);
            merge(A,start,mid,end, tmp);
        }
    }

    public static void merge(int[] A, int start, int mid, int end, int[] tmp) {
        //第一个有序子序列起始位置
        int i = start;
        //第二个有序子序列起始位置
        int j = mid + 1;
        //临时数组起始位置
        int k = 0;

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
