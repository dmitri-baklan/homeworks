package controller;

import view.View;
import java.util.Scanner;
import model.*;
import model.entity.*;


public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        InputNoteNoteBook inputNoteNoteBook = new InputNoteNoteBook(view, sc);
        inputNoteNoteBook.InputNote();

        Note note = createNote(inputNoteNoteBook);
        view.printMessage(note.firstName," ", note.login);

    }

    private Note createNote(InputNoteNoteBook inputNoteNoteBook){
        Note note;
        while(true){
            try{
                note = new Note(inputNoteNoteBook.getFirstName(),
                        inputNoteNoteBook.getLogin());
                break;
            }
            catch(NotUniqeLoginException e){
                e.printStackTrace();
                inputNoteNoteBook.InputLoginData();
            }

        }
        return note;
    }

}
