// Создать приложение, удовлетворяющее требованиям, приведенным в задании. Аргументировать принадлежность классу
// каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().

// 5. Создать объект класса Дом, используя классы Окно, Дверь.
// Методы: закрыть на ключ, вывести на консоль количество окон, дверей.

import java.util.Arrays;
import java.util.Objects;

class Lab3_3_5 {
    public static void main(String[] args) {
        Window win = new Window(300, 300);
        Door door = new Door("green");

        House house = new House(new Door[]{door}, new Window[]{win});
        house.open();
        System.out.println(house.isLocked);
        house.lock();
        System.out.println(house.isLocked);
    }
}

interface Openable {
    boolean open();
    boolean close();
}

class House {
    protected Door[] doors;
    protected Window[] windows;

    protected boolean isLocked = true;

    public House(Door[] doors, Window[] windows) {
        this.doors = doors;
        this.windows = windows;
    }

    public Door[] getDoors() {
        return doors;
    }

    public Window[] getWindows() {
        return windows;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean open() {
        if (this.isLocked) {
            this.isLocked = false;
            return true;
        }

        return false;
    }

    public boolean lock() {
        if (this.isLocked) {
            return false;
        }

        this.isLocked = true;
        return true;
    }

    public void printDoorsAndWindowsCount() {
        System.out.println("Windows: " + this.windows.length);
        System.out.println("Doors: " + this.doors.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        House house = (House) o;
        return Arrays.equals(doors, house.doors) && Arrays.equals(windows, house.windows);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(doors);
        result = 31 * result + Arrays.hashCode(windows);
        return result;
    }

    @Override
    public String toString() {
        return "House{" +
                "doors=" + Arrays.toString(doors) +
                ", windows=" + Arrays.toString(windows) +
                ", isLocked=" + isLocked +
                '}';
    }
}

class Door implements Openable {
    protected String color;

    protected boolean isOpened;

    public Door(String color) {
        this.isOpened = false;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean open() {
        if (this.isOpened) {
            return false;
        }

        this.isOpened = true;
        return true;
    }

    @Override
    public boolean close() {
        if (this.isOpened) {
            this.isOpened = false;
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Door door = (Door) o;
        return color.equals(door.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Door{" +
                "color='" + color + '\'' +
                ", isOpened=" + isOpened +
                '}';
    }
}

class Window implements Openable {
    protected double width;
    protected double height;

    protected boolean isOpened;

    public Window(double width, double height) {
        this.isOpened = false;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return this.height;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    @Override
    public boolean open() {
        if (this.isOpened) {
            return false;
        }

        this.isOpened = true;
        return true;
    }

    @Override
    public boolean close() {
        if (this.isOpened) {
            this.isOpened = false;
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Window window = (Window) o;
        return Double.compare(window.width, width) == 0 && Double.compare(window.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Window{" +
                "width=" + width +
                ", height=" + height +
                ", isOpened=" + isOpened +
                '}';
    }
}
