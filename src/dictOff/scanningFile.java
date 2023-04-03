package dictOff;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class scanningFile {
    public static ArrayList<String> readFile(String fileName, String word){
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" /");

                if(arr[0].equals(word)){
                    String s = br.readLine();

                    while (isNumeric(Character.toString(s.charAt(0)))){
                        arrayList.add(s);
                        s = br.readLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static void add(String s, String word, VBox vBox, Text vocbText){
        for(int i=0; i<readFile(s,word).size();i++){
            vocbText = new Text(readFile(s,word).get(i));
            vocbText.setFont(Font.font("Times New Roman", FontPosture.REGULAR,15));
            vBox.getChildren().add(vocbText);
        }

    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
