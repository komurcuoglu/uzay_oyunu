
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Frame extends JFrame {
    public Frame() throws HeadlessException {



    }

    public static void main(String[] args)  {


        Frame frame=new Frame();

        frame.setResizable(false);

        frame.setFocusable(false);

        frame.setSize(800,600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Oyun oyun=new Oyun();

        oyun.requestFocus();

        oyun.addKeyListener(oyun);

        oyun.setFocusable(true);


        oyun.setFocusTraversalKeysEnabled(false);
        frame.add(oyun);
        oyun.setBackground(Color.BLACK);
        frame.setVisible(true);








        frame.add(oyun);




    }
}
