// 2. Определить класс Вектор размерности n. Определить несколько конструкторов.
// Реализовать методы для вычисления модуля вектора, скалярного произведения, сложения, вычитания, умножения на константу.
// Объявить массив объектов. Написать метод, который для заданной пары векторов будет определять,
// являются ли они коллинеарными или ортогональными.

import java.util.Arrays;

class Lab1_2 {
    public static void main(String[] args) {
        double[] vector1 = {1, -1, 3};
        double[] vector2 = {1, 1, 0};

        Vector vector = new Vector(3);

        vector.add(new double[]{1, 2, 3});
        System.out.println(vector);

        vector.subtract(new double[]{1, 1, 1});
        System.out.println(vector);

        vector.multiply(10);
        System.out.println(vector);

        System.out.println(vector.scalarMultiply(new double[]{1, 4, 5}));

        System.out.println(vector.module());

        Vector[] matrix = {new Vector(3), new Vector(new double[]{3, 2, 1})};

        System.out.println(isCollinearOrOrthogonal(vector1, vector2));
        System.out.println(isCollinearOrOrthogonal(matrix[0].getVector(), matrix[1].getVector()));
    }

    public static boolean isCollinearOrOrthogonal(double[] lValue, double[] rValue) {
        return Vector.isCollinear(lValue, rValue) || Vector.isOrthogonal(lValue, rValue);
    }
}

class Vector {
    /**
     * Точность, с которой два числа считаются равными
     */
    private static final double epsilon = 10e-6;

    /**
     * Вектор
     */
    private double[] vector;

    /**
     * Создает вектор размерности n и заполняет его нулями
     * @param n - размерность вектора
     */
    Vector(int n) {
        this.vector = new double[n];
        for (int i = 0; i < n; i++) {
            this.vector[i] = 0;
        }
    }

    /**
     * Создает вектор, копируя переданный
     * @param vector - вектор, на основе которого необходимо создать новый
     */
    Vector(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    /**
     * Возвращает вектор
     */
    public double[] getVector() {
        return this.vector;
    }

    /**
     * Устанавливает вектор
     * @param vector - вектор, на основе которого необходимо создать новый
     */
    public void setVector(double[] vector) {
        if (this.vector == null) {
            this.vector = new double[vector.length];

        } else {
            if (this.vector.length != vector.length) {
                throw new UnsupportedOperationException("Векторы разной размерности");
            }
        }

        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    /**
     * Возвращает модуль вектора
     */
    public double module() {
        double sum = 0;
        for (double el : this.vector) {
            sum += Math.pow(el, 2);
        }

        return Math.sqrt(sum);
    }

    /**
     * Прибавляет к текущему вектору переданный
     * @param rValue - вектор, который нужно просуммировать с текущим
     */
    public double[] add(double[] rValue) {
        this.vector = Vector.add(this.vector, rValue);
        return this.vector;
    }

    /**
     * Вычитает из текущего вектора переданный
     * @param rValue - вектор, который нужно вычесть из текущего
     */
    public double[] subtract(double[] rValue) {
        this.vector = Vector.subtract(this.vector, rValue);
        return this.vector;
    }

    /**
     * Умножает текущий вектор на переданное число
     * @param k - число, на которое нужно умножить текущий вектор
     */
    public double[] multiply(double k) {
        this.vector = Vector.multiply(this.vector, k);
        return this.vector;
    }

    /**
     * Скалярно умножает текущий вектор на переданный
     * @param rValue - вектор, на который нужно умножить текущий
     */
    public double scalarMultiply(double[] rValue) {
        return Vector.scalarMultiply(this.vector, rValue);
    }

    /**
     * Складывает 2 переданных вектора
     *
     * @param lValue - 1 слагаемое
     * @param rValue - 2 слагаемое
     *
     * @throws UnsupportedOperationException - не совпадает размерность векторов
     */
    public static double[] add(double[] lValue, double[] rValue) throws UnsupportedOperationException {
        if (lValue.length != rValue.length) {
            throw new UnsupportedOperationException("Векторы разной размерности");
        }

        int n = lValue.length;
        double[] res = new double[n];

        for (int i = 0; i < n; i++) {
            res[i] = lValue[i] + rValue[i];
        }

        return res;
    }

    /**
     * Вычитает 2 переданных вектора
     *
     * @param lValue - уменьшаемое
     * @param rValue - вычитаемое
     *
     * @throws UnsupportedOperationException - не совпадает размерность векторов
     */
    public static double[] subtract(double[] lValue, double[] rValue) throws UnsupportedOperationException {
        if (lValue.length != rValue.length) {
            throw new UnsupportedOperationException("Векторы разной размерности");
        }

        int n = lValue.length;
        double[] res = new double[n];

        for (int i = 0; i < n; i++) {
            res[i] = lValue[i] - rValue[i];
        }

        return res;
    }
    /**
     * Умножает переданный вектор на переданное число
     *
     * @param vector - вектор, который необходимо умножить на переданное число
     * @param k - чсло, на которое необходимо умножить переданный вектор
     */

    public static double[] multiply(double[] vector, double k) {
        int n = vector.length;
        double[] res = new double[n];

        for (int i = 0; i < n; i++) {
            res[i] = vector[i] * k;
        }

        return res;
    }

    /**
     * Скалярно перемножает два вектора
     *
     * @param lValue - 1 множитель
     * @param rValue - 2 множитель
     *
     * @throws UnsupportedOperationException - не совпадает размерность векторов
     */
    public static double scalarMultiply(double[] lValue, double[] rValue) throws UnsupportedOperationException {
        if (lValue.length != rValue.length) {
            throw new UnsupportedOperationException("Векторы разной размерности");
        }

        int n = lValue.length;
        double res = 0;

        for (int i = 0; i < n; i++) {
            res += lValue[i] * rValue[i];
        }

        return res;
    }

    /**
     * Возвращает true, если переданные векторы коллинеарны друг другу
     *
     * @param lValue - 1 вектор
     * @param rValue - 2 вектор
     *
     * @throws UnsupportedOperationException - не совпадает размерность векторов
     */
    public static boolean isCollinear(double[] lValue, double[] rValue) throws UnsupportedOperationException {
        if (lValue.length != rValue.length) {
            throw new UnsupportedOperationException("Векторы разной размерности");
        }

        int n = lValue.length;

        if (n < 2) {
            return true;
        }

        double k;

        try {
            k = lValue[0] / rValue[0];

        } catch (ArithmeticException e) {
            k = 0;
        }

        for (int i = 1; i < n; i++) {
            double newK;

            try {
                newK = lValue[i] / rValue[i];

            } catch (ArithmeticException e) {
                newK = 0;
            }

            if (Math.abs(newK - k) > Vector.epsilon) {
                return false;
            }
        }

        return true;
    }

    /**
     * Возвращает true, если переданные векторы ортогональны друг другу
     *
     * @param lValue - 1 вектор
     * @param rValue - 2 вектор
     *
     * @throws UnsupportedOperationException - не совпадает размерность векторов
     */
    public static boolean isOrthogonal(double[] lValue, double[] rValue) {
        return Math.abs(Vector.scalarMultiply(lValue, rValue)) < Vector.epsilon;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.vector);
    }
}