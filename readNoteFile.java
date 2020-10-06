package lang.view;

import javafx.beans.property.SimpleObjectProperty;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class readNoteFile {
public static String text="";
    private static Scanner sc;

    public static void openReadFile(){
        try{
            sc= new Scanner(new File("noteFile.txt"));
        }
        catch(Exception e){
            System.out.println("error");

        }
    }
    public static void readFile()
    {
        while(sc.hasNext()){
            String a =sc.next();
            text = text+a;
            System.out.printf("%s"+" ",a);

        }
    }
    public static void closeFile()
    {
        sc.close();
    }

}
