// Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы
// в интервале значений от -n до n с помощью датчика случайных чисел.
// 9. Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.

import java.util.Random;
import java.util.Scanner;

class Lab2_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n:");
        int n = in.nextInt();

        float[][] matrix = new float[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextFloat() * 2 * n - n;
            }
        }

        printMatrix(matrix, "Сгенерированная матрица:");

        updateMatrix(matrix);

        printMatrix(matrix, "Измененная матрица:");
    }

    /**
     * Изменяет матрицу в соответствии с заданием
     * @param matrix - матрица, которую необходимо изменить
     */
    protected static void updateMatrix(float[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            float mean = getMeanValue(matrix[i]);

            for (int j = 0; j < n; j++) {
                matrix[i][j] -= mean;
            }
        }
    }

    /**
     * Возвращает среднее арифметическое элементов переданного массива
     * @param arr - массив для поиска среднего арифметического его элементов
     */
    protected static float getMeanValue(float[] arr) {
        float sum = 0;

        for (float el : arr) {
            sum += el;
        }

        return sum / arr.length;
    }

    /**
     * Выводит матрицу в консоль
     *
     * @param matrix - матрица, которую нужно напечатать
     * @param title - заголовок, который нужно напечатать перед матрицей
     */
    protected static void printMatrix(float[][] matrix, String title) {
        int n = matrix.length;

        if (title != null) {
            System.out.println(title);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("%10.3f", matrix[i][j]);
            }

            System.out.println();
        }
    }
}