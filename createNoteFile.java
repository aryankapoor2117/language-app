package lang.view;
import java.io.*;
import java.lang.*;
import java.util.*;

import static lang.Main.notesTextField;


public class createNoteFile {
    public static String notesText = "";
    public static File file = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\notesFile");
    static private Formatter f;
    public static String openNoteFile() throws IOException {

        notesText="";
        notesTextField.setText("");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int content;
            while ((content = fileInputStream.read()) != -1) {
                notesText = notesText + ((char) content);
            }
            return notesText;
        }
    }
        public static void writeFile(String editedText) throws IOException {

            try (FileWriter fileWriter = new FileWriter(file)){

                fileWriter.write(editedText);
                fileWriter.close();

            }

        }
public void flushNotes() throws IOException
{
    try(FileWriter fileWriter = new FileWriter(file)){
        notesTextField.setText("");
        fileWriter.flush();
        fileWriter.close();
    }
}
    }

