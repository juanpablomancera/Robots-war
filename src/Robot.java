import java.awt.*;

public class Robot {
    public final static int UP = 1;
    public final static int DOWN = 2;
    public final static int LEFT = 3;
    public final static int RIGHT = 4;

    CustomPoint location, goal;
    int remainingMines;
    String name;
    CustomPoint boardDimension;

    /**
     * Robot constructor
     * */
    public Robot(String name, CustomPoint initialLocation, CustomPoint goal, CustomPoint boardDimension){
        this.name = name;
        this.location = initialLocation;
        this.goal = goal;
        this.boardDimension = boardDimension;
        remainingMines = 10;
    }

    /**
     * Moves the robot in the indicated direction
     * @param movement where the robot is moving to
     * @return boolean: true if it has moved succesfully
     * */
    public boolean move(int movement){
        switch (movement){
            case UP:
                if (validHeight(location.y + 1)) {
                    location.y++;
                    return true;
                } else
                    return false;
            case DOWN:
                if (validHeight(location.y-1)) {
                    location.y--;
                    return true;
                } else
                    return false;
            case LEFT:
                if (validWidth(location.x - 1)) {
                    location.x--;
                    return true;
                } else
                    return false;
            case RIGHT:
                if (validWidth(location.x + 1)) {
                    location.x++;
                    return true;
                } else
                    return false;
        }
        return false;
    }

    /**
     * Checks if the width exists in the array (see move())
     * @param width target width
     * @return boolean: true if exists
     * */
    private boolean validWidth(int width) {
        return (width >= 0) && (width < boardDimension.x);
    }

    /**
     * Checks if the height exists in the array (see move())
     * @param height target width
     * @return boolean: true if exists
     * */
    private boolean validHeight(int height) {
        return (height >= 0) && (height < boardDimension.y);
    }

    /**
     * Laids a mine in the robots position
     * @return boolean: true if it successfully laids the mine
     * */
    public boolean laidMine(){
        if (remainingMines > 0) {
            remainingMines--;
            return true;
        } else
            return false;
    }

    public CustomPoint getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }

    public int getRemainingMines(){
        return remainingMines;
    }

    public CustomPoint getGoal(){
        return goal;
    }

    public void setLocation(CustomPoint location) {
        this.location = location;
    }

    public void setGoal(CustomPoint goal) {
        this.goal = goal;
    }
}

