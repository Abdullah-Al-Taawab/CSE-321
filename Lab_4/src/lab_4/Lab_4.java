/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */ 
class MyThread extends Thread{
    
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i = 0;i < 5;i++){
            System.out.println("This output is from "+ getName()+": "+i);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class MyThreadfromRunnable implements Runnable{
    @Override
    public void run(){
    }
}

public class Lab_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        MyThread mt = new MyThread("Rapheo 0");
        MyThread mt2 = new MyThread("Rapheo 2");
        MyThread mt3 = new MyThread("Rapheo 3");
        MyThread mt4 = new MyThread("Rapheo 4");
        
        //mt4.setPriority(Thread.MAX_PRIORITY);
        //mt2.setPriority(Thread.MIN_PRIORITY);
        
        //System.out.println(mt.getState());
        
        mt.start();
        mt2.start();
        mt3.start();
        mt4.start();
        
        try {
            mt.join();
            mt2.join();
            mt3.join();
            mt4.join(); 
        } catch (InterruptedException ex) {
            Logger.getLogger(Lab_4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!mt.isAlive()){
            System.out.println("dead");
        }

        System.out.println("Done");

        
        //Thread mtrunnable = new Thread(new MyThreadfromRunnable(), "Rapheo2");
        //mtrunnable.run();
        //mtrunnable.start();
        
        //System.out.println("Hello 2");
        //System.out.println(Thread.currentThread().getName());
        */
    } 
}

