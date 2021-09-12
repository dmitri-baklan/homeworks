package controller;

import model.Model;
import view.View;

public class Controller {
    public View view;
    public Model model;

    public Controller(View view,Model model){
        this.view = view;
        this.model = model;
    }


}
