package edu.hebut.wang.sort;

/**
 * 直接选择排序
 */
public class Selection_Sort{

    public static void main(String[] args) {
        int[] A = {4,7,2,1,5,6,3};
        float a = 3.14F;
    }

    public static int[] sort(int[] A) {

        int length = A.length;
        int tmp;

        for (int i = 0; i < length; i++) {
            int minPosition = findMin(A,i,length);

            if (i != minPosition) {
                tmp = A[i];
                A[i] = A[minPosition];
                A[minPosition] = tmp;
            }

        }
        return A;

    }

    private static int findMin(int[] A, int start, int end) {

        int min = start;

        for (int i = start + 1; i < end; i++) {
            if (A[i] < A[min] ) {
                min = i;
            }
        }
        return min;
    }

}
