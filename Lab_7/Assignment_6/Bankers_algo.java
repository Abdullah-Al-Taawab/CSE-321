/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Bankers_algo {

    static BufferedReader b1;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        b1 = new BufferedReader(new FileReader("E:\\CSE\\1CSE_Labs\\CSE 321 Lab\\Lab_7\\data.txt"));
        int row = Integer.parseInt(b1.readLine());
        int column = Integer.parseInt(b1.readLine()); 
        String[] process = new String[row];
        int[][] max = new int[row][column];
        int[][] allocation = new int[row][column];
        int[][] need = new int[row][column];
        int[][] available = new int[row + 1][column];
        LinkedList<Integer> track = new LinkedList<Integer>();

        process = load_process(process);
        max = load_max(max);

        for (int i = 0; i < row; i++) {
            String s = b1.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            for (int j = 0; j < column; j++) {
                allocation[i][j] = Integer.parseInt(st.nextToken());
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        print_need(need);

        String s = b1.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        int counter = 0;
        while (st.hasMoreTokens()) {
            available[0][counter] = Integer.parseInt(st.nextToken());
            counter++;
        }
        counter = 0;
        int i = 0;
        while (true) {
            i = i % row;
            boolean flag = true;
            for (int j = 0; j < column; j++) {
                if (need[i][j] <= available[counter][j]) {
                } else {
                    flag = false;
                    break;
                }
                if (flag && j == (column - 1) && !track.contains(i)) {
                    for (int k = 0; k < column; k++) {
                        available[counter + 1][k] = available[counter][k] + allocation[i][k];
                    }
                    track.addLast(i);
                    counter++;
                }
            }
            if (track.size() == row) {
                break;
            }
            i++;
        }

        print_safe_sequence(process, track);
        print_available_changes(available);
    }

    private static String[] load_process(String[] process) throws IOException {
        int a = 65; // ascii of A
        for (int x = 0; x < process.length; x++) {
            process[x] = Character.toString((char) (a + x));
        }
        return process;
    }

    private static int[][] load_max(int[][] max) throws IOException {
        for (int i = 0; i < max.length; i++) {
            String m = b1.readLine();
            StringTokenizer mt = new StringTokenizer(m, " ");
            for (int j = 0; j < max[0].length; j++) {
                max[i][j] = Integer.parseInt(mt.nextToken());
            }
        }
        return max;
    }

    private static void print_need(int[][] need) {
        System.out.print("Need Matrix");
        for (int i = 0; i < need.length; i++) {
            System.out.println();
            for (int j = 0; j < need[0].length; j++) {
                System.out.print(need[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    private static void print_safe_sequence(String[] process, LinkedList<Integer> track) {
        System.out.println("Safe Sequence:");
        for (int i = 0; i < track.size(); i++) {
            System.out.print(process[track.get(i)] + " ");
        }
        System.out.println();
    }

    private static void print_available_changes(int[][] available) {
        System.out.println("Change in available resource matrix:");
        for (int i = 1; i < available.length; i++) {
            if (i != 1) {
                System.out.println();
            }
            for (int j = 0; j < available[0].length; j++) {
                System.out.print(available[i][j] + " ");
            }
        }
        System.out.println();
    }
}
