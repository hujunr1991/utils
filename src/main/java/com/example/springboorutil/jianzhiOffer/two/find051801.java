package com.example.springboorutil.jianzhiOffer.two;

public class find051801 {
    public static void main(String[] args) {
        int [][] testarray = new int[4][4];
        testarray[0][0]=1;
        testarray[0][1]=2;
        testarray[0][2]=8;
        testarray[0][3]=9;
        testarray[1][0]=2;
        testarray[1][1]=4;
        testarray[1][2]=9;
        testarray[1][3]=12;
        testarray[2][0]=4;
        testarray[2][1]=7;
        testarray[2][2]=10;
        testarray[2][3]=13;
        testarray[3][0]=6;
        testarray[3][1]=8;
        testarray[3][2]=11;
        testarray[3][3]=15;
        System.out.println(find(testarray, 7));

        String str = null;
        String trim = str.trim();
        System.out.println(trim);

    }

    private static boolean find(int[][] testarray, int object) {
        int cloumn = testarray[0].length-1;
        int row = 0;
        while (row <testarray.length && cloumn >0) {
            if (testarray[row][cloumn] == object) {
                 return true;
            } else if (testarray[row][cloumn] > object) {
                cloumn--;
            } else {
                row++;
            }
        }
        return false;
    }
}
