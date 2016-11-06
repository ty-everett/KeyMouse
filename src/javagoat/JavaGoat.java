package javagoat;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JavaGoat implements KeyListener {
    
    int x, y, vx, vy;
    Robot r;
    
    public JavaGoat() throws AWTException{
        JFrame f = new JFrame();
        f.addKeyListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JLabel("JavaGoat"));
        f.setVisible(true);
        f.setAlwaysOnTop(true);
        f.requestFocus();
        r = new Robot();
        x=y=100;
        vx=vy=0;
        r.mouseMove(x, y);
        while(true){
            try{
                Thread.sleep(1000/30);
            }catch(InterruptedException e){}
            x=vx+x;
            y=vy+y;
            r.mouseMove(x+vx, y+vy);
            f.requestFocus();
        }
    }
    
    public static void main(String[] args) {
        try {
            new JavaGoat();
        } catch (AWTException ex) {}
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_END){
            vy = 10;
        }
        if(ke.getKeyCode() == KeyEvent.VK_HOME){
            vy = -10;
        }
        if(ke.getKeyCode() == KeyEvent.VK_DELETE){
            vx = -10;
        }
        if(ke.getKeyCode() == KeyEvent.VK_PAGE_DOWN){
            vx = 10;
        }
        if(ke.getKeyCode() == KeyEvent.VK_INSERT){
            r.mousePress(InputEvent.BUTTON1_MASK);
            try{Thread.sleep(50);}catch(Exception e){}
        }
        if(ke.getKeyCode() == KeyEvent.VK_PAGE_UP){
            r.mousePress(InputEvent.BUTTON2_MASK);
            try{Thread.sleep(50);}catch(Exception e){}
        }
       if(ke.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_END){
            vy = 0;
        }
        if(ke.getKeyCode() == KeyEvent.VK_HOME){
            vy = 0;
        }
        if(ke.getKeyCode() == KeyEvent.VK_DELETE){
            vx = 0;
        }
        if(ke.getKeyCode() == KeyEvent.VK_PAGE_DOWN){
            vx = 0;
        }
        if(ke.getKeyCode() == KeyEvent.VK_INSERT){
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        if(ke.getKeyCode() == KeyEvent.VK_PAGE_UP){
            r.mouseRelease(InputEvent.BUTTON2_MASK);
        }
    }
    
}
