package ce1002.s103403513;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

/*
* This class manage the object in game.
*/

public class GameManager {
    private List<GameObject> objectList = new ArrayList<>(); //All the GameObject in game is store in this List.
    private Player player; // This is your player.
    private long lastUpdateTime = 0;
    private GraphicsContext gc;// This is what you need to draw on canvas.

    public GameManager(GraphicsContext gc){
        this.gc = gc; //Pass the GraphicsContext from canvas
        player = new Player();// Initialize the Player here
        objectList.add(player);// Add the Player to objectList
    }

    // Draw method, being called at Controller's animation timer.
    public void draw(long timestamp){
        final double elapsedSeconds = (timestamp - lastUpdateTime) / 1_000_000_000.0 ;
        final double deltaX = elapsedSeconds * player.getSpeed()*player.xDerection;
        final double deltaY = elapsedSeconds * player.getSpeed()*player.yDerection;
        player.move(deltaX,deltaY);
        for(GameObject obj:objectList){
            obj.draw(gc);
        }
        lastUpdateTime = timestamp;
    }

    public void movePlayerX(int x){
        player.xDerection = x;
    }
    public void movePlayerY(int y){
        player.yDerection = y;
    }

    //check every click on canvas if the GameObject is clicked or not.
    public void OnClick(MouseEvent event){
        for(GameObject obj:objectList){
            if(obj.isClick(event)){
                obj.OnClick ();
                break;
            }
        }
    }
}