import javax.swing.*;//java swing framework
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] functioButton=new JButton[8];
    JButton addButton,subButton,mButton,divButton;
    JButton decButton,equButton,delButton,clrButton;
    JPanel panel;

    Font myFont=new Font("Ink Free",Font.BOLD,30);

    Double num1,num2,result;
    char operator;

    Calculator()
    {
        //initiating window on screen
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,550);
        frame.setLayout(null);
        

        //creating a textfield
        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //making buttons objects and labelling them
        addButton=new JButton("+");
        subButton=new JButton("-");
        mButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("delete");
        clrButton=new JButton("clear");

        //adding all the buttons to the array declared above
        functioButton[0]=addButton;
        functioButton[1]=subButton;
        functioButton[2]=mButton;
        functioButton[3]=divButton;
        functioButton[4]=decButton;
        functioButton[5]=equButton;
        functioButton[6]=delButton;
        functioButton[7]=clrButton;

        //adding action listener and setting font for all function buttons
        for(int i=0;i<8;i++)
        {
            functioButton[i].addActionListener(this);
            functioButton[i].setFont(myFont);
            functioButton[i].setFocusable(false);

        }

        //instantiating and adding action listener to number buttons 
        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));//labelling the button
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        //instantiating panel to hold the buttons
        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.GRAY);

        //adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);//adding textfield to frame
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        Calculator calculator=new Calculator();

    }
    @Override
    public void actionPerformed(ActionEvent e) {//executes when the buttons are pressed
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton)
            {
                textField.setText(textField.getText().concat("."));
            }
            if(e.getSource()==addButton)
            {
                
                num1=Double.parseDouble(textField.getText());
                operator='+';
                textField.setText("");
            }
            if(e.getSource()==subButton)
            {
                
                num1=Double.parseDouble(textField.getText());
                operator='-';
                textField.setText("");
            }
            if(e.getSource()==mButton)
            {
                
                num1=Double.parseDouble(textField.getText());
                operator='*';
                textField.setText("");
            }
            if(e.getSource()==divButton)
            {
                num1=Double.parseDouble(textField.getText());
                operator='/';
                textField.setText("");
            }
            if(e.getSource()==equButton)
            {
                
                num2=Double.parseDouble(textField.getText());
                //now performing math the = is clicked
                switch(operator){
                    case '+':
                    result=num1+num2;
                    break;

                    case '-':
                    result=num1-num2;
                    break;

                    case '*':
                    result=num1*num2;
                    break;

                    case '/':
                    result=num1/num2;
                    break;
                }
                textField.setText(String.valueOf(result));
                num1=result;
            }
            if(e.getSource()==clrButton)
            {
                textField.setText("");
            }
            if(e.getSource()==delButton) {
                String string = textField.getText();
                textField.setText("");
                for(int i=0;i<string.length()-1;i++) {
                    textField.setText(textField.getText()+string.charAt(i));
                }
            }
    }
}