// Создать приложение, удовлетворяющее требованиям, приведенным в задании. Аргументировать принадлежность классу
// каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().

// 8. Создать объект класса Пианино, используя класс Клавиша.
// Методы: настроить, играть на пианино, нажимать клавишу.

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

class Lab3_3_8 {
    public static void main(String[] args) {
        Piano piano = new Piano(new Key[]{
                new Key("do"),
                new Key("re"),
                new Key("mi"),
                new Key("fa"),
                new Key("sol"),
                new Key("lya"),
                new Key("si"),
        });

        piano.tune();

        try {
            System.out.println(piano.presKey(0));
            System.out.println(piano.presKey(1));
            System.out.println(piano.presKey(4));

        } catch (Exception err) {
            System.out.println("Так нельзя сыграть");
        }
    }
}

class Piano {
    protected Key[] keys;

    public Piano(Key[] keys) {
        this.keys = keys;
    }

    public String presKey(int num) throws Exception {
        if (num < 0 || num >= this.keys.length) {
            throw new Exception("Такой клавиши нет");
        }

        return this.keys[num].press();
    }

    public void tune() {
        Random random = new Random();

        for (int i = 0; i < this.keys.length - 1; i++) {
            boolean shouldSwap = random.nextBoolean();

            if (shouldSwap) {
                Key swap = this.keys[i];
                this.keys[i] = this.keys[i + 1];
                this.keys[i + 1] = swap;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Piano piano = (Piano) o;
        return Arrays.equals(keys, piano.keys);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(keys);
    }

    @Override
    public String toString() {
        return "Piano{" +
                "keys=" + Arrays.toString(keys) +
                '}';
    }
}

class Key {
    protected String sound;

    public Key(String sound) {
        this.sound = sound;
    }

    public String press() {
        return this.sound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Key key = (Key) o;
        return Objects.equals(sound, key.sound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sound);
    }

    @Override
    public String toString() {
        return "Клавиша воспроизводит звук" + this.sound;
    }
}