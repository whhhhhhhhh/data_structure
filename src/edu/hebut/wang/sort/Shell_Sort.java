package edu.hebut.wang.sort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 希尔排序
 * 按照增量把数组分割成几个部分，分别进行插入排序
 */
public class Shell_Sort {

    public static void main(String[] args) {
        int[] A = Bubble_Sort.createRandomArray(10000);
        System.out.println(Arrays.toString(sort(A)));
    }

//    public static int[] sort(int[] A) {
//
//        int length = A.length;
//
//        for (int D = length/2; D > 0; D/=2){
//            for (int i = D; i < length; i++) {
//                int tmp = A[i];
//                int j;
//                for (j = i; j >= D && A[j-D] > tmp; j-=D) {
//                    A[j] = A[j-D];
//                }
//                A[j] = tmp;
//            }
//        }
//        return A;
//
//    }

    public static int[] sort(int[] A) {
        int length = A.length;
        //遍历增量
        for (int gap = length/2; gap > 0; gap /= 2) {
            //分组,一共有gap个组
            for (int i = 0; i < gap; i++) {
                //对分组进行排序
                group_sort(A,length,i,gap);
            }
        }
        return A;
    }

    private static void group_sort(int[] A, int length, int i, int gap) {
        //直接插入排序
        for (int j = i + gap; j < length; j += gap) {
            if (A[j] < A[j - gap]) {
                int tmp = A[j];
                int k = j - gap;
                while (k >= 0 && A[k] > tmp) {
                    A[k + gap] = A[k];
                    k -= gap;
                }
                //循环最后减去了gap要加上
                A[k + gap] = tmp;
            }

        }

    }

}
