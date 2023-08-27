package org.example.pepcoding.nados;

public class PrintZ {
    public static void main(String[] args) {
        // Write your code here
        char[][] mtx = new char[5][5];
        for(int j = 0; j < 5; j++){
            mtx[0][j] = '*';
            System.out.print("*");
        }

        int count = 3;

        for(int i = 1; i < 4; i++){
            System.out.println();
            for(int j = 0; j < 5; j++){
                mtx[i][j] = ' ';
                System.out.print(" ");
                if(j == count){
                    mtx[i][j] = '*';
                    System.out.println("*");
                    count--;
                }
            }
        }

        for(int j = 0; j < 5; j++){
            mtx[4][j] = '*';
            System.out.print("*");
        }

//        for(int i = 0; i < mtx.length; i++){
//            for(int j = 0; j < mtx.length; j++){
//                System.out.print(mtx[i][j]);
//            }
//        }
    }
}
