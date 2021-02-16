// 4. Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом.

import java.util.Scanner;

class Lab1_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пароль:");
        String password = in.nextLine();

        Vault vault = new Vault("qwerty");

        if (vault.canOpen(password)) {
            System.out.println("Хранилище можно открыть");

        } else {
            System.out.println("Хранилище нельзя открыть");
        }
    }
}

/**
 * Хранилище
 */
class Vault {
    /**
     * Пароль от хранилища
     */
    private String password;

    Vault() {}

    Vault(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Возвращает true, если хранилище можно открыть переданным паролем
     * @param password - пароль для проверки возможности открытия хранилища
     */
    public boolean canOpen(String password) {
        if (this.password == null) {
            // Если пароль не установлен, то можно открыть в любом случае
            return true;
        }

        return this.password.equals(password);
    }
}
