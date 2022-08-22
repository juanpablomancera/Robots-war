public class Board {
    private Robot[][] table;

    /**
     * Creates a two-dimensional array (Robot array) with the given
     * dimensions and calls initialzieBoard()
     * @param width width of the board
     * @param height height of the board
     * */
    public Board(int width, int height){
        table = new Robot[width][height];
        initializeBoard();
    }

    /**
     * Initialises all the board to null
     * */
    private void initializeBoard(){
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[0].length; j++)
                table[i][j] = null;
    }

    /**
     * Puts a mine in the location of the robot
     * @param robot the mine-laying robot
     * */
    public void putMine(Robot robot){
        table[robot.getLocation().x][robot.getLocation().y] = robot;
        System.out.println("The Robot "+robot.getName()+" has lead a mine in "+robot.getLocation());
    }

    /**
     * Checks if there is a mine in the robot's position
     * @param robot
     * @return boolean : if there's a mine -> true
     * */
    public boolean containsAntiRobotMine(Robot robot){
        Robot mina = table[robot.getLocation().x][robot.getLocation().y];
        if (mina != null)
            return !mina.getName().equals(robot.getName());
        else
            return false;
    }

    /**
     * Checks if there is an adjacent mine because a mine
     * can only be laid if there is no mine in the vicinity.
     * @param robot
     * @return boolean: if there is an adjacent mine -> true
     * */
    public boolean adjacentMine(Robot robot) {
        if (    (getSquareContent(robot.getLocation().x + 1,robot.getLocation().y) != null) ||
                (getSquareContent(robot.getLocation().x - 1,robot.getLocation().y) != null) ||
                (getSquareContent(robot.getLocation().x,robot.getLocation().y-1) != null) ||
                (getSquareContent(robot.getLocation().x,robot.getLocation().y+1) != null))
            return true;
        return false;
    }

    /**
     * Returns the content of the array position specified by the parameters.
     * @param x x-coordinate
     * @param y y-coordinate
     * @return Null if the position is empty.
     *         If there is a mine, reference from the robot
     *         that dropped it off
     * */
    public Robot getSquareContent(int x, int y) {
        if ((x < 0) || (x >= table.length) || (y < 0) || (y >= table[0].length))
            return null;
        return table[x][y];
    }

}
