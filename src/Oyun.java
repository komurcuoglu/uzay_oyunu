import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

public class Oyun extends JPanel implements KeyListener, ActionListener {
    Timer timer=new Timer(5,this);
    private int gecensure;
    private int harcananates;
    private int atesdirY=1;
    private BufferedImage image;
    private int X=0;
    private int dirX=20;
    private ArrayList<Ates> atesler=new ArrayList<Ates>();
    private int topX=0;
    private int dirtopX=2;
    private int vuruldu;




    public Oyun()  {

        try {
            image =ImageIO.read(new FileImageInputStream(new File("src/uzaygemisi.png"))) ;
        } catch (IOException e) {
            e.printStackTrace();
        }


timer.start();


    }
public boolean control(){
        for (Ates ates: atesler) {
            if (new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle( topX,0,20,20))){

                return true;

            }


        }
        return false;
}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.drawImage(image,X, 490, image.getWidth() / 10, image.getHeight() / 10, this);
        g.fillOval(topX,0,20,20);
        for (Ates ates:atesler){
            if (ates.getY()<0){
                atesler.remove(ates);
            }
        }
        g.setColor(Color.blue);
        for (Ates ates:atesler){
          g.fill3DRect(ates.getX(),ates.getY(),10,20,false);
        }
        if (control()){
            timer.stop();
            String s="Geçen Süre:"+gecensure/1000.0+"\n"+"Harcanan Ateş:"+harcananates;
            JOptionPane.showInternalMessageDialog(new JPanel(),s);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();
        if (c==KeyEvent.VK_A){


            if (X<=0){
                X=0;
            }
            else { X-=dirX;

            }
        }
        else if (c==KeyEvent.VK_D){

            if (X>=720){
                X=720;

            }
            else { X+=dirX;

            }

        }
        if (c==KeyEvent.VK_SHIFT){
            atesler.add(new Ates(X+15,470));
        harcananates++;


        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
gecensure+=5;
for (Ates ates: atesler){
    ates.setY(ates.getY()-atesdirY);
}

        topX+=dirtopX;
        if (topX>=790){
            dirtopX=-dirtopX;
        }
        if (topX<=0){
            dirtopX=-dirtopX;
        }
        repaint();
    }


    @Override
    public void repaint() {
        super.repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}

