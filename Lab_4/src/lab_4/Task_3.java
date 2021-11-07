/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

/**
 *
 * @author 
 */
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Task_3
        extends RecursiveTask<Integer> {

    int start, end;
    int[] arr;

    private int partion(int start, int end,
            int[] arr) {

        int i = start, j = end;

        int pivote = new Random()
                .nextInt(j - i)
                + i;

        int t = arr[j];
        arr[j] = arr[pivote];
        arr[pivote] = t;
        j--;

        while (i <= j) {

            if (arr[i] <= arr[end]) {
                i++;
                continue;
            }

            if (arr[j] >= arr[end]) {
                j--;
                continue;
            }

            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            j--;
            i++;
        }
        t = arr[j + 1];
        arr[j + 1] = arr[end];
        arr[end] = t;
        return j + 1;
    }

    public Task_3(int start, int end, int[] arr) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (start >= end) {
            return null;
        }

        int pt = partion(start, end, arr);

        Task_3 left
                = new Task_3(start, pt - 1, arr);

        Task_3 right
                = new Task_3(pt + 1, end, arr);

        left.fork();
        right.compute();

        left.join();

        return null;
    }

    public static void main(String args[]) {
        int n = 7;
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        ForkJoinPool pool
                = ForkJoinPool.commonPool();
        pool.invoke(
                new Task_3(
                        0, n - 1, arr));
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
