// При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
// 1. Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lab_5_4_1 {
    public static void main(String[] args) {
        String inFileName = "src/lab_5/4-1.java";
        String outFileName = "src/lab_5/4-1-modified.txt";
        StringBuilder res = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(inFileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = Pattern.compile("^\\s*(?<accessMod>public)\\s.+$").matcher(line);

                if (matcher.find()) {
                    res.append(line.substring(0, matcher.start("accessMod")) + "private" + line.substring(matcher.end("accessMod")));

                } else {
                    res.append(line);
                }

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