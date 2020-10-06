package lang.view;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lang.Main;


import javax.xml.soap.Text;
import java.io.IOException;

import static lang.Main.notesTextField;
//import static lang.view.createNoteFile.flushNotes;
import static lang.view.createNoteFile.notesText;
import static lang.view.createNoteFile.writeFile;



public class notesPageController {
    private Main main;
    public Button notesSaveButton;




    public createNoteFile g = new createNoteFile();
    public readNoteFile a = new readNoteFile();
    @FXML
public void saveNotesData() throws IOException{
       // g.openNoteFile();
       // g.addRecords();
        //g.closeRecord();
        writeFile(notesTextField.getText());
        main = new Main();
        main.showStartView();


    }
    public void openNotesData() throws IOException{
        a.openReadFile();
        a.readFile();
        a.closeFile();


    }
}
