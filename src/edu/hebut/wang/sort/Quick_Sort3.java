package edu.hebut.wang.sort;


import edu.hebut.wang.datastructure.Stack;

import java.util.Arrays;

/**
 * 非递归快速排序
 * 递归的算法主要是在划分子区间，如果要非递归实现快排，只要使用一个栈来保存区间就可以
 */
public class Quick_Sort3 {

    private static Stack<Integer> stack = new Stack<>();

    public static int[] sort(int A[], int left, int right) {
        stack.push(left);
        stack.push(right);//后入的right，所以要先拿right
        while(!stack.empty())//栈不为空
        {
            right = stack.pop();
            left = stack.pop();

            int index = Quick_Sort1.partSort(A,left,right);
            if((index - 1) > left)//左子序列
            {
                stack.push(left);
                stack.push(index - 1);
            }
            if((index + 1) < right)//右子序列
            {
                stack.push(index + 1);
                stack.push(right);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {4,7,2,1,5,6,3};
        System.out.println(Arrays.toString(sort(A,0,A.length-1)));
    }

}
