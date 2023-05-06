package com.team1.ce216project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;
import java.util.Scanner;

public class ConvertToFiles {
    public static void replaceLines(String fileName) throws FileNotFoundException {
        if(fileName.contains("eng-ell")){
            replaceLinesForEll(fileName);
        }
        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file;
            file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
            StringBuilder inputBuffer = new StringBuilder();
            String line;
            String nextline = null;

            if (!(line = file.readLine()).equals("Formatted by Dictoff")) {
                inputBuffer.append("Formatted by Dictoff");
                inputBuffer.append('\n');
                while ((line = file.readLine()) != null) {
                    if (line.contains("/")) {
                        inputBuffer.append(line);
                        inputBuffer.append('\n');
                        nextline = file.readLine();
                        if (!nextline.contains(".")) {
                            nextline = "1." + nextline;
                        }
                        inputBuffer.append(nextline);
                        inputBuffer.append('\n');
                    } else {
                        inputBuffer.append(line);
                        inputBuffer.append('\n');
                    }


                }
                file.close();

                // write the new string with the replaced line OVER the same file
                FileOutputStream fileOut = new FileOutputStream(fileName);
                OutputStreamWriter writer = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);
                writer.write(inputBuffer.toString());
                writer.close();

            } }catch(Exception e){
                e.printStackTrace();
            }

    }

    public static void replaceLinesForEll(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));

        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file;
            file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
            StringBuilder inputBuffer = new StringBuilder();
            String line;
            if ((file.readLine()).equals("Formatted by Dictoff")) {
                return;
            }
                while (sc.hasNext()) {
                    line = sc.nextLine();
                    if(!line.isEmpty()) {
                        inputBuffer.append(line);
                        inputBuffer.append('\n');
                    }


                }
                file.close();

                // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream(fileName);
            OutputStreamWriter writer = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);
            writer.write(inputBuffer.toString());
            writer.close();

             }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void fixBlank(String fileName) throws FileNotFoundException {
        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file;
            file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
            StringBuilder inputBuffer = new StringBuilder();
            String line;
            while ((line = file.readLine()) != null) {
                if (!line.equals("")) {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');

                }
            }
            file.close();

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream(fileName);
            OutputStreamWriter writer = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);
            writer.write(inputBuffer.toString());
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
