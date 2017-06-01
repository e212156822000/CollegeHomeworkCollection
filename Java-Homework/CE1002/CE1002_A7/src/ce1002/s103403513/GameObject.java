package ce1002.s103403513;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
/*
* This class is the basic object in Game.
* It has the basic property for game object,
* such like position, width, height, image.
* It also has some basic method : draw, isclick, onclick,move.
*/
public abstract class GameObject  extends JComponent {
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected Image image;
    
	
    public GameObject(double x,double y,double width,double height,Image image){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void draw(GraphicsContext gc){
        gc.drawImage(image,x,y,width,height);
        //the position of the image, now it's drawn from x,y to x+width,y+height
        //and it's draw from the top left corner of the image.
    }
    public void move(double deltaX,double deltaY){
        //something missing here.
    	double oldX = x;
    	double oldY = y;
    	x = oldX + deltaX;
        y = oldY + deltaY;
    }
    //按到圖片了沒有
    public boolean isClick(MouseEvent event){
    	if( event.getX() <= x+width && event.getX() >= x  &&
    		event.getY() <= y+height && event.getY() >= y ){
    		return true;
    	}else return false;
    }
    public abstract void OnClick();
}
