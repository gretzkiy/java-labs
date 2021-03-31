// 3. В каждой строке найти слова, начинающиеся с гласной буквы.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lab_5_3_3 {
    public static void main(String[] args) {
        String inFileName = null;
        String outFileName = null;

        try {
            inFileName = args[1];
            outFileName = args[2];

        } catch (Exception e) {
            inFileName = "in3.txt";
            outFileName = "out3.txt";
        }

        StringBuilder res = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(inFileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                List<String> allMatches = new ArrayList<String>();
                Matcher m = Pattern.compile("\\b[aeiouyAEIIOUY].*?\\b").matcher(line);

                while (m.find()) {
                    res.append(m.group());
                    res.append(" ");
                }

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