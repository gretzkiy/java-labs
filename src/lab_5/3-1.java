// 1. В каждой строке найти и удалить заданную подстроку.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Lab_5_3_1 {
    public static void main(String[] args) {
        String inFileName = null;
        String outFileName = null;
        String substrToRemove = null;

        try {
            inFileName = args[1];
            outFileName = args[2];
            substrToRemove = args[3];

        } catch (Exception e) {
            inFileName = "in1.txt";
            outFileName = "out1.txt";
            substrToRemove = "test";
        }

        StringBuilder res = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(inFileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                res.append(line.replaceAll(substrToRemove, ""));
                res.append("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out = new PrintWriter(outFileName);
            out.print(res);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}