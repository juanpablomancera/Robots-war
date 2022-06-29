import java.awt.*;
import java.util.Scanner;

public class UserInterface {
    public final static int ROBOT_DESTROYED = 1;
    public final static int GOAL_ACHIEVED = 2;
    private final Scanner scanner;

    public UserInterface(){
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    void showTurn(Robot robot){
        System.out.println("Turn of the robot " + robot.getName() + ". Actual Location: "+robot.getLocation()+". Goal square "+robot.getGoal()+".");
    }

    public int menu(Robot robot){
        System.out.print("1. Up (moves a square up)\n" +
                "2. Down (moves a square down)\n" +
                "3. Left (moves a square left)\n" +
                "4. Right (moves a square right)\n" +
                "5. Laid a mine (you have  "+robot.getRemainingMines()+" mines left)\n" +
                "Move: ");

        return scanner.nextInt();
    }

    public void message(int tipoMensaje, Robot robot){
        switch(tipoMensaje){
            case ROBOT_DESTROYED:
                System.out.println("¡¡Robot "+robot.getName()+" destroyed!! The robot has stepped on a mine in square "+  robot.getLocation()+"\n");
                break;
            case GOAL_ACHIEVED:
                System.out.println("Robot "+robot.getName()+": mission accomplished. The robot "+robot.getName()+" has reached the square "+robot.getGoal()+"\n");
                break;
        }
    }

    public int getBoardDimension(String dimension){
        System.out.print(dimension + " of the board: " +
                "");
        return scanner.nextInt();
    }

    public String getRobostNames(String nombres){
        System.out.print("Name of the robot "+nombres+" : ");
        return scanner.next();
    }

}
