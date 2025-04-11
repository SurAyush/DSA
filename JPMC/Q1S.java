package JPMC;
import java.util.*;
public class Q1S {
    public static void flipHorizontal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = m - 1; j < k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }

    public static void rotate90Clockwise(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        flipHorizontal(matrix);
        printMatrix(matrix);
    }

    public static void flipVertical(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<m;i++) {    //col
            for(int j=0,k=n-1;j<k;j++,k--) { //row
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }

        }
        
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    public static void rotate90CounterClockwise(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Flip vertically
        flipVertical(matrix);
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 0},
            {0, 1, 1},
            {0, 0, 1}
        };

        int degree = -180;
        boolean oppt = false;

        if(degree<0){
            oppt = true;
            degree *= -1;
        }

        boolean fliphor=true;
        boolean flipver=true;

        boolean isNegative = (degree < 0);
        degree = Math.abs(degree);

        int nor = (degree / 90) % 4; // Only relevant for 90, 180, 270, 360 degrees

        printMatrix(matrix);

        if (nor > 0) {
            for (int i = 0; i < nor; i++) {
                if (isNegative) {
                    rotate90CounterClockwise(matrix);
                } else {
                    rotate90Clockwise(matrix);
                }
            }
            printMatrix(matrix);
        }


        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        
        // System.out.println("Matrix after 90-degree Clockwise Rotation:");
        // printMatrix(matrix);

        // if(fliphor){
        //     flipHorizontal(matrix);
        // }

        // if (flipver){
        //     flipVertical(matrix);
        // }
        printMatrix(matrix);
    }
}
/*
1 2 3
4 5 6
7 8 9

T;
1 4 7
2 5 8
3 6 9

7 4 1
8 5 2
9 6 3
*/