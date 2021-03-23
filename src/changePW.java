import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class changePW extends JFrame
    {
        private JTextField password, ID, checkPassword, result;

        private JPanel panel;

//        final int FRAME_WIDTH = 100;
//        final int FRAME_HEIGHT = 100;



        public changePW ()
        {

            super("Password Checker");

           // setSize(300, 300);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panel = new JPanel();
            panel.setLayout(null);


            JLabel userId = new JLabel("Enter User ID"); //label- User Id
            userId.setBounds(250, 50, 100, 30);
            ID = new JTextField(12);//                  txt
            ID.setBounds(270, 90, 50,30);

            JLabel pw = new JLabel("Enter Password");//    label- Password
            pw.setBounds(90,190,200,30);
            password= new JPasswordField();//            txt
            password.setBounds(300, 190, 290,30);

            JLabel chkPW = new JLabel("Check Password");// label- Check Password
            chkPW.setBounds(90,230, 200,30);
            checkPassword = new JPasswordField();//        txt
            checkPassword.setBounds(300, 230, 290, 30 );

            JButton bttn = new JButton("Check Password Validity");//Button
            bttn.setBounds(190, 300, 250, 30);

            result = new JTextField();//                 txt
            result.setBounds(30, 350, 500,30);


            add(userId);
            add(ID);
            add(pw);
            add(password);
            add(chkPW);
            add(checkPassword);
            add(bttn);
            add(result);

            bttn.addActionListener(new ActionListener()
            {


                @Override
                public void actionPerformed(ActionEvent e) // when bttn is clicked
                {
                    String passwords = password.getText();
                   // String loginID= ID.getText();
                    String chkPW= checkPassword.getText();

                    int numUpperCase=0;
                    int numLowerCase=0;
                    int numDigit=0;
                    int numSpecial=0;
System.out.println(passwords);

                    for (int i =0; i< passwords.length(); i++)
                    {
                        char c = passwords.charAt(i);

                        if(c>='A' && c<='Z'){
                            numUpperCase++;
                        }else if(c>='a' && c<='z'){
                            numLowerCase++;
                        }else if(c>='0' && c<='9'){
                            numDigit++;
                        }else{
                            numSpecial++;
                        }
                    }



                    if (oldPWList().contains(password))
                    {
                        result.setText( passwords+ "Can not use old Password");   //Both passwords have to be the same
                    }
                    else if (!passwords.equals(chkPW))
                    {

                        result.setText(passwords +"," +chkPW+ ": Not Matching");//make sure diff from prev 10 pw
                    }
                    else if (passwords.length() <10 )
                    {
                        result.setText(passwords+"Password Needs at least 10 chars");//atleast 10 chars
                    }
                    else if (numUpperCase < 1 )
                    {
                        result.setText(passwords+"At least ONE char should be Upper Case");//ONE uppercase
                    }
                    else if ( numLowerCase < 2)
                    {
                        result.setText(passwords+" At least TWO chars should be Lower Case");//TWO lowercase
                    }
                    else if ( numSpecial< 1 )
                    {
                        result.setText(passwords+" At least ONE special char should be used");//ONE Special Char
                    }
                    else if ( numDigit < 1 )
                    {
                        result.setText( passwords+" At least ONE digit should be used");//One digit
                    }
                    else
                    {
                        result.setText("Accepted");// Accepted
                    }
                }
            });
            panel.add(bttn);
           JLabel header= new JLabel();
            panel.add(header);
            this.add(panel);
        }



        private ArrayList<String> oldPWList()
        {
            File list = new File ( "oldPW.txt");
            Scanner read;
            String line = "";
            ArrayList<String> password = new ArrayList<>();
            try
            {
                read= new Scanner(list);
                while (read.hasNextLine())
                {
                    line= read.nextLine();
                    password.add(line);
                }
                return password;
            }
            catch (FileNotFoundException e)
            {
                System.out.println("File not found  ");
            }
            return password;
        }



    public static void main(String[] args)
    {
        changePW frame = new changePW();
        frame.setSize(600,400);
        frame.setVisible(true);
    }
    }




