package edu.hebut.wang.sort;



import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 冒泡排序
 */
public class Bubble_Sort {

    public static void main(String[] args) {
        int[] A = createRandomArray(10000);
        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.toString(sort(A)));
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 生成随机数
     * @param size
     * @return
     */
    public static int[] createRandomArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = random.nextInt(size) + 1;
        }
        return array;
    }

    /**
     * 把最大的沉到最下
     * 改进1 ：flag 如果一趟循环没有交换，就提前退出
     * @param A
     * @return
     */
    public static int[] sort(int[] A) {

        int length = A.length;

        int flag;

        for (int i = length - 1; i >= 0; i--) {
            flag = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j+1]) {
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        return A;
    }

    public static int[] sortB(int[] A) {
        int length = A.length;
        for (int i = 0; i < length;i++) {
            for (int j = 1;j < length-i;j++) {
                if (A[j] < A[j-1]) {
                    int tmp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = tmp;
                }
            }
        }
        return A;
    }

}
