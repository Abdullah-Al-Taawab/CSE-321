/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package lab_4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
class Will_print {

    int num = 1;

    public synchronized void first_Print() {
        for (int i = 0; i < 20; i++) {
            if (num > 10 && num <= 20) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Will_print.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + num);
            ++num;
        }
        notify();
    }

    public synchronized void second_Pirnt() {
        for (int i = 0; i < 10; i++) {
            if (num < 10 && num >= 20) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Will_print.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + num);
            ++num;
        }
        notify();
    }
}

class First_Thread extends Thread {

    Will_print wp;

    public First_Thread(String name, Will_print wp) {
        super(name);
        this.wp = wp;
    }

    @Override
    public void run() {
        wp.first_Print();
    }

}

class Second_Thread extends Thread {

    Will_print wp;

    public Second_Thread(String name, Will_print wp) {
        super(name);
        this.wp = wp;
    }

    @Override
    public void run() {
        wp.second_Pirnt();
    }
}

public class Task_1 {

    public static void main(String[] args) {
        Will_print wp = new Will_print();
        First_Thread ft = new First_Thread("First Thread", wp);
        Second_Thread st = new Second_Thread("Second Thread", wp);
        ft.start();
        st.start();
    }

}