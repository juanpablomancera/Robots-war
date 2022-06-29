import java.awt.*;

public class CustomPoint extends Point {

    public CustomPoint(int x, int y){
        super(x,y);
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
