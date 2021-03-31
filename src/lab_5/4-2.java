// При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
// 2. Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

import java.io.*;
import java.util.Scanner;

class Lab_5_4_2 {
    public static void main(String[] args) {
        String inFileName = "src/lab_5/4-2.java";
        String outFileName = "src/lab_5/4-2-modified.txt";
        StringBuilder res = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(inFileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                res.append(new StringBuilder(line).reverse());
                res.append("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            File outFile = new File(outFileName);
            FileWriter fileWriter = new FileWriter(outFile);

            fileWriter.write(res.toString());
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}