package dictOff;

import java.io.*;
import java.util.Formatter;

public class ConvertToFiles {
    public static void replaceLines(String fileName) {
        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file;
            file = new BufferedReader(new FileReader(fileName));
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
                fileOut.write(inputBuffer.toString().getBytes());
                fileOut.close();

            } }catch(Exception e){
                e.printStackTrace();
            }

    }
}
