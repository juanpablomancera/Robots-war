public class Board {
    private Robot[][] table;

    public Board(int width, int height){
        table = new Robot[width][height];
        initializeBoard();
    }

    private void initializeBoard(){
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[0].length; j++)
                table[i][j] = null;
    }

    public void putMine(Robot robot){
        table[robot.getLocation().x][robot.getLocation().y] = robot;
        System.out.println("The Robot "+robot.getName()+" has lead a mine in "+robot.getLocation());
    }

    public boolean containsAntiRobotMine(Robot robot){
        Robot mina = table[robot.getLocation().x][robot.getLocation().y];
        if (mina != null)
            return !mina.getName().equals(robot.getName());
        else
            return false;
    }

    public boolean adjacentMine(Robot robot) {
        if (    (getSquareContent(robot.getLocation().x + 1,robot.getLocation().y) != null) ||
                (getSquareContent(robot.getLocation().x - 1,robot.getLocation().y) != null) ||
                (getSquareContent(robot.getLocation().x,robot.getLocation().y-1) != null) ||
                (getSquareContent(robot.getLocation().x,robot.getLocation().y+1) != null))
            return true;
        return false;
    }

    public Robot getSquareContent(int x, int y) {
        if ((x < 0) || (x >= table.length) || (y < 0) || (y >= table[0].length))
            return null;
        return table[x][y];
    }

}
