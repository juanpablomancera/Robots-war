import java.awt.*;
import java.util.Scanner;

public class UserInterface {
    public final static int ROBOT_DESTROYED = 1;
    public final static int GOAL_ACHIEVED = 2;
    private final Scanner scanner;

    public UserInterface(){
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    /**
     * Prints the actual turn with all the robots info
     * @param robot robot of the current turn
     * */
    void showTurn(Robot robot){
        System.out.println("Turn of the robot " + robot.getName() + ". Actual Location: "+robot.getLocation()+". Goal square "+robot.getGoal()+".");
    }

    /**
     * Prints the movement options or to laid a mine
     * @return int of the selected option
     * */
    public int menu(Robot robot){
        System.out.print("1. Up (moves a square up)\n" +
                "2. Down (moves a square down)\n" +
                "3. Left (moves a square left)\n" +
                "4. Right (moves a square right)\n" +
                "5. Laid a mine (you have  "+robot.getRemainingMines()+" mines left)\n" +
                "Move: ");

        return scanner.nextInt();
    }

    /**
     * Returns the end of game message
     * @param message how the game has ended
     *                ROBOT_DESTROYED -> The robot has stepped on a mine
     *                GOAL_ACHIEVED -> The robot has reached the target
     * @param robot the robot that has finished the game
     * */
    public void message(int message, Robot robot){
        switch(message){
            case ROBOT_DESTROYED:
                System.out.println("¡¡Robot "+robot.getName()+" destroyed!! The robot has stepped on a mine in square "+  robot.getLocation()+"\n");
                break;
            case GOAL_ACHIEVED:
                System.out.println("Robot "+robot.getName()+": mission accomplished. The robot "+robot.getName()+" has reached the square "+robot.getGoal()+"\n");
                break;
        }
    }

    /**
     * Set one dimension of the board (height or width)
     * @param dimension which dimension you choose
     * @return int the choosen size
     * */
    public int getBoardDimension(String dimension){
        System.out.print(dimension + " of the board: " +
                "");
        return scanner.nextInt();
    }

    /**
     * Set one dimension of the board (height or width)
     * @param name which robot is (1 or 2)
     * @return string with the robots name
     * */
    public String getRobostNames(String name){
        System.out.print("Name of the robot "+ name +" : ");
        return scanner.next();
    }

}
