package guessnumber;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Number extends JFrame{
    
    private JTextField textField1, textField2;
    private JLabel label1, label2;
    private JButton button;
    private int rando;

    public Number (){
        
        super("Number Guessing (Type -1 to exit)");
        setLayout(new FlowLayout());
        
        Random guess = new Random();  //creates randomizing object called product
        rando = 1 + guess.nextInt(1000);

        label1 = new JLabel ("I have a number between 1 and 1000. Can you guess my number?");
        add(label1);
        
        label2 = new JLabel ("Please enter your first guess."); 
        label2.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(label2);
        
        textField2 = new JTextField( 4 ); //JTextField for input, 4 columns
        add(textField2);
        
        button = new JButton("Restart");  //makes Restart JButton
        add(button);
        
        TextFieldHandler handler = new TextFieldHandler(); //event handler object
        textField2.addActionListener(handler);
        button.addActionListener(handler);
        
        
    }
    
    private class TextFieldHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            
            String tfield = textField2.getText(); //next 2 lines put JTextField input into an int  
            int numberCheck = Integer.parseInt(tfield);
            
            String text;
         
           if(numberCheck == -1){ //if user wants to exit
               System.exit(numberCheck);
        
           }else if(numberCheck > 1000 || numberCheck < -1){ //check if the number is in range
               JOptionPane.showMessageDialog(null, String.format("Pick a number between 1 and 1000, dumbass!"));
               
               
           }else if(event.getSource() == textField2){  //user hits enter in the jtextfield 
                 
                if(numberCheck > rando){  //if the user guesses too high
                    text = String.format("Too High");
                    getContentPane().setBackground(Color.RED);
                }else if(numberCheck < rando){   //if the user guesses too low
                    text = String.format("Too Low");
                    getContentPane().setBackground(Color.CYAN);
                }else{ //if the user picks the correct answer
                    text = String.format("Correct!");   
                    getContentPane().setBackground(Color.LIGHT_GRAY);
                    textField2.setEditable(false);                                      
                }
                JOptionPane.showMessageDialog(null, text);
                
            }else if (event.getSource() == button){ //user hit reset button 
               
               textField2.setEditable(true); //makes textfield editable 
               
               Random newguess = new Random();  //new random number
               rando = 1 + newguess.nextInt(1000);
               textField2.setText("");  //clears textfield
               JOptionPane.showMessageDialog(null, String.format("Reset!")); 
           }    
            
           
        }
    }
}
