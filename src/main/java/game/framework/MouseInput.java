package game.framework;

import game.window.Game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mouse controller in the menus
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class MouseInput implements MouseListener {
    
    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    /**
     * if mouse is clicked in definite area(button)
     * switches menus or going to the play mode
     * @param e mouse event object
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        switch (Game.state) {
            case MENU:
                //Play button
                if(mx >= 305 && mx <= 495 ){
                    if(my >= 250 && my <= 299){
                        Game.state = Game.STATE.GAME;
                    }
                }   // help button
                if(mx >= 305 && mx <= 495){
                    if(my >= 350 && my <= 399){
                        Game.state = Game.STATE.HELP;
                    }
                }   //quit button
                if(mx >= 305 && mx <= 495){
                    if(my >= 450 && my <= 499){
                        System.exit(0);
                    }
                }   break;
            case HELP:
                if(mx >= 305 && mx <= 495){
                    if(my >= 550 && my <= 599){
                        Game.state = Game.STATE.MENU;
                    }
                }   break;
            case GAMEOVER:
                if(mx >= 305 && mx <= 495){
                    if(my >= 550 && my <= 599){
                        Game.state = Game.STATE.MENU;
                    }
                }   break;
            case PAUSE:
                if(mx >= 305 && mx <= 495){
                    if(my >= 500 && my <= 559){
                        Game.state = Game.STATE.GAME;
                    }
                }   break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
    
}
