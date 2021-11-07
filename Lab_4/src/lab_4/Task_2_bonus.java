/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package lab_4;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Method;

/**
 *
 * @author 
 */
class Divisorz extends Thread {

    int start;
    int end;
    int num_of_div = 0;
    int num = 0;

    public Divisorz(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int x = 0;
        for (int i = start; i <= end; i++) {
            x = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    x++;
                }
                if (num_of_div < x) {
                    num_of_div = x;
                    num = i;
                }
            }
        }
    }

    public int getNum() {
        return num;
    }

    public int getNumofDiv() {
        return num_of_div;
    }
}

public class Task_2_bonus {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Divisorz d1 = new Divisorz(1, 10000);
        Divisorz d2 = new Divisorz(10001, 20000);
        Divisorz d3 = new Divisorz(20001, 30000);
        Divisorz d4 = new Divisorz(30001, 40000);
        Divisorz d5 = new Divisorz(40001, 50000);
        Divisorz d6 = new Divisorz(50001, 60000);
        Divisorz d7 = new Divisorz(60001, 70000);
        Divisorz d8 = new Divisorz(70001, 80000);
        Divisorz d9 = new Divisorz(80001, 90000);
        Divisorz d10 = new Divisorz(90001, 100000);
        //run
        long st_run = System.currentTimeMillis();
        d1.run();
        d2.run();
        d3.run();
        d4.run();
        d5.run();
        d6.run();
        d7.run();
        d8.run();
        d9.run();
        d10.run();
        long end_run = System.currentTimeMillis();
        long run_time = end_run - st_run;
        System.out.println("Thread.run elapsed time: " + run_time);
        //start
        long st_start = System.currentTimeMillis();
        d1.start();
        d2.start();
        d3.start();
        d4.start();
        d5.start();
        d6.start();
        d7.start();
        d8.start();
        d9.start();
        d10.start();
        try {
            d1.join();
            d2.join();
            d3.join();
            d4.join();
            d5.join();
            d6.join();
            d7.join();
            d8.join();
            d9.join();
            d10.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Task_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        long end_ofstart = System.currentTimeMillis();
        long start_time = end_ofstart - st_start;
        System.out.println("Thread.start elapsed time: " + start_time);
        int max = 0;
        int num = 0;
        int[] arr_num = new int[10];
        int[] arr_num_div = new int[10];
        arr_num[0] = d1.getNum();
        arr_num_div[0] = d1.getNumofDiv();
        arr_num[1] = d2.getNum();
        arr_num_div[1] = d2.getNumofDiv();
        arr_num[2] = d3.getNum();
        arr_num_div[2] = d3.getNumofDiv();
        arr_num[3] = d4.getNum();
        arr_num_div[3] = d4.getNumofDiv();
        arr_num[4] = d5.getNum();
        arr_num_div[4] = d5.getNumofDiv();
        arr_num[5] = d6.getNum();
        arr_num_div[5] = d6.getNumofDiv();
        arr_num[6] = d7.getNum();
        arr_num_div[6] = d7.getNumofDiv();
        arr_num[7] = d8.getNum();
        arr_num_div[7] = d8.getNumofDiv();
        arr_num[8] = d9.getNum();
        arr_num_div[8] = d9.getNumofDiv();
        arr_num[9] = d10.getNum();
        arr_num_div[9] = d10.getNumofDiv();
        for (int i = 0; i < 10; i++) {
            if (max < arr_num_div[i]) {
                max = arr_num_div[i];
                num = arr_num[i];
            }
        }

        System.out.println("The number is: " + num);
        System.out.println("Number of divisors: " + max);
    }
}
