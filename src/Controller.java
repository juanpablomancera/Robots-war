import java.awt.*;

public class Controller {
    private UserInterface ui;
    private Robot[] robots;
    private Board board;

    void initialize() {
        ui = new UserInterface();
        int altura, anchura;
        anchura = ui.getBoardDimension("Width");
        altura = ui.getBoardDimension("Height");
        robots = new Robot[2];
        robots[0] = new Robot(ui.getRobostNames("1"), new CustomPoint(0, 0), new CustomPoint(anchura - 1, altura - 1), new CustomPoint(anchura, altura));
        robots[1] = new Robot(ui.getRobostNames("2"), new CustomPoint(anchura - 1, altura - 1), new CustomPoint(0, 0), new CustomPoint(anchura, altura));

        board = new Board(anchura, altura);
    }

    void robotsWar() {
        int turn = -1;
        boolean endedGame = false;
        while (!endedGame) {
            turn = (turn + 1) % 2;
            System.out.println("---------------------------------------");
            ui.showTurn(robots[turn]);
            int option = ui.menu(robots[turn]);
            if (robots[turn].move(option)){

            }
            else if (option >=1 && option <= 4){
                System.out.println("You have left the board and missed the turn");
            }
            if (board.containsAntiRobotMine(robots[turn])) {
                ui.message(UserInterface.ROBOT_DESTROYED, robots[turn]);
                endedGame = true;
            }
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
            if (option > 5) {
                System.out.println("The option entered is not valid. The robot " + robots[turn].getName() + " has missed the turn.");
            }
            System.out.println("The actual location of " + robots[turn].getName() + " is " + robots[turn].getLocation());
            if (robots[turn].getLocation().equals(robots[turn].getGoal())) {
                endedGame = true;
                ui.message(UserInterface.GOAL_ACHIEVED, robots[turn]);
            }
        }
    }
}
