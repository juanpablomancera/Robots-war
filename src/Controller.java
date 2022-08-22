import java.awt.*;

public class Controller {
    private UserInterface ui;
    private Robot[] robots;
    private Board board;


    /**
     * Initialise the data for the game:
     * - Creates the board with the dimensions that the player has entered
     * - Creates the two robots with the names the players has entered
     * */
    void initialize() {
        ui = new UserInterface();
        int height, width;
        width = ui.getBoardDimension("Width");
        height = ui.getBoardDimension("Height");
        robots = new Robot[2];
        robots[0] = new Robot(ui.getRobostNames("1"), new CustomPoint(0, 0), new CustomPoint(width - 1, height - 1), new CustomPoint(width, height));
        robots[1] = new Robot(ui.getRobostNames("2"), new CustomPoint(width - 1, height - 1), new CustomPoint(0, 0), new CustomPoint(width, height));

        board = new Board(width, height);
    }

    /**
     * The whole logic of the game
     * */
    void robotsWar() {
        int turn = -1;
        boolean endedGame = false;
        /**
         * Loop that closes when the game ends
         * */
        while (!endedGame) {
            turn = (turn + 1) % 2;
            System.out.println("---------------------------------------");
            ui.showTurn(robots[turn]);
            /**The player chooses the movement*/
            int option = ui.menu(robots[turn]);

            /**
             * If it's possible, it moves the robot, otherwise you lose the turn.
             * */
            if (robots[turn].move(option)){}
            else if (option >=1 && option <= 4){
                System.out.println("You have left the board and missed the turn");
            }

            /**
             * If there is a mine in the new position, the player looses and the game ends
             * */
            if (board.containsAntiRobotMine(robots[turn])) {
                ui.message(UserInterface.ROBOT_DESTROYED, robots[turn]);
                endedGame = true;
            }

            /**
             * The player has chosen to leave a mine. It is only possible if it
             * is not from the exit point and there is not already an adjacent mine.
             * */
            if ((option == 5) && (robots[turn].getRemainingMines() > 0)) {
                if (board.adjacentMine(robots[turn])){
                    System.out.println("A mine cannot be laid as there is already one in an adjoining mine.");
                }
                else if
                (turn == 0 && robots[turn + 1].getGoal().equals(robots[turn].getLocation()) && !board.adjacentMine(robots[turn]) ||
                                (turn == 1 && robots[turn - 1].getGoal().equals(robots[turn].getLocation()) && !board.adjacentMine(robots[turn]))) {
                    System.out.println("A mine cannot be placed in the exit location.");
                }
                else{
                    robots[turn].laidMine();
                    board.putMine(robots[turn]);
                }
            }

            /**
             * The entered option is not valid, you loose your turn
             * */
            if (option > 5) {
                System.out.println("The option entered is not valid. The robot " + robots[turn].getName() + " has missed the turn.");
            }

            /**
             * Shows the player the robot's data after the movement has been made.
             * */
            System.out.println("The actual location of " + robots[turn].getName() + " is " + robots[turn].getLocation());
            if (robots[turn].getLocation().equals(robots[turn].getGoal())) {
                endedGame = true;
                ui.message(UserInterface.GOAL_ACHIEVED, robots[turn]);
            }
        }
    }
}
