/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cmp;

import cmp.presentation.SimpleView;
import cmp.presentation.Controller;
import cmp.presentation.Model;

/**
 *
 * @author david
 */
public class Application {
    public static void main(String[] args) {
        try {
            SimpleView view = new SimpleView();
            Model model = new Model();
            Controller controller = new Controller(model, view);
            view.setVisible(true);
            
            //System.in.read(); //esto es para esperar hasta que el usuario haga enter
        } catch (Exception e) {
            System.out.print("\n\n\nERROR CON EL PROGRAMA!!!!");
            e.printStackTrace();
        }
    }
}
