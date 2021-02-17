// Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы
// в интервале значений от -n до n с помощью датчика случайных чисел.
// 1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).

import java.util.Random;
import java.util.Scanner;

class Lab2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = in.nextInt();

        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n) - n;
            }
        }

        printMatrix(matrix, "Сгенерированная матрица:");

        System.out.println("Введите k:");
        int k = in.nextInt();

        sortMatrixByColumn(matrix, k);

        printMatrix(matrix, "Отсортированная матрица:");
    }

    /**
     * Сортирует переданную матрицу по значениям переданного столбца
     *
     * @param matrix - матрица, которую необходимо отсортировать
     * @param k - столбец, по значениям которого необходимо отсортировать матрицу
     */
    protected static void sortMatrixByColumn(int[][] matrix, int k) {
        int i = 0, n = matrix.length;
        boolean hasSwaps = true;

        while (hasSwaps) {
            hasSwaps = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (matrix[j][k] > matrix[j + 1][k]) {
                    swapMatrixRows(matrix, j, j + 1);
                    hasSwaps = true;
                }
            }

            i++;
        }
    }

    /**
     * Переставляет i-ую и j-ую строки матрицы
     *
     * @param matrix - матрица, в которой необходимо переставить строки
     * @param i - индекс первой строки для перестановки
     * @param j - индекст второй строки для перестановки
     */
    protected static void swapMatrixRows(int[][] matrix, int i, int j) {
        int n = matrix[i].length;

        int[] tmpRow = new int[n];

        for (int t = 0; t < n; t++) {
            tmpRow[t] = matrix[i][t];
        }

        for (int t = 0; t < n; t++) {
            matrix[i][t] = matrix[j][t];
            matrix[j][t] = tmpRow[t];
        }
    }

    /**
     * Выводит матрицу в консоль
     *
     * @param matrix - матрица, которую нужно напечатать
     * @param title - заголовок, который нужно напечатать перед матрицей
     */
    protected static void printMatrix(int[][] matrix, String title) {
        int n = matrix.length;

        if (title != null) {
            System.out.println(title);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }

            System.out.println();
        }
    }
}