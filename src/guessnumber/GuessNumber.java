package guessnumber;

import javax.swing.JFrame;

public class GuessNumber {

    
    public static void main(String[] args) {
       
        Number myFrame = new Number();   //creates myFrame object of class Number
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exits when you close
        myFrame.setSize(400, 120);  //window size
        myFrame.setLocationRelativeTo ( null );  //centered
        myFrame.setVisible(true);  //so you can see it
        
        
    }

}
