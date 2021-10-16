package org.example;

import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter three numbers: ");
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();

        int[][] mat1 = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                mat1[i][j] = random.nextInt(10);
                System.out.print(mat1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] mat2 = new int[m][k];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < k; ++j) {
                mat2[i][j] = random.nextInt(10);
                System.out.print(mat2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] res = new int[n][k];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < k; ++j){
                res[i][j] = 0;
                for (int r = 0; r < m; ++r){
                    res[i][j] += mat1[i][r] * mat2[r][j];
                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
