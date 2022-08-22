import java.awt.*;

public class CustomPoint extends Point {

    public CustomPoint(int x, int y){
        super(x,y);
    }

    /**
     * Modify how the robot's position looks to make it more beautiful.
     * */
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
