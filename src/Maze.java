import java.util.Arrays;

public class Maze {

    private final String [][] maze = {
            {"|", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "|"},
            {"|", " ", " ", " ", " ", " ", "E", "|", "_", "_", "_", "S", "|"},
            {"|", " ", "_", "_", "_", "_", "_", "|", "|", " ", " ", " ", "|"},
            {"|", " ", "_", "_", "_", "_", "_", "|", " ", " ", "_", "_", "|"},
            {"|", " ", " ", " ", " ", " ", " ", " ", " ", "|", "|", "|", "|"},
            {"|", "_", "_", "_", " ", "|", "|", "|", "|", " ", "|", "|", "|"},
            {"|", "|", " ", " ", " ", "|", "|", "|", " ", " ", "|", "|", "|"},
            {"|", "|", " ", "|", " ", " ", " ", " ", "|", " ", " ", " ", "|"},
            {"|", " ", " ", "|", "|", "|", " ", "|", "|", "|", "|", " ", "|"},
            {"|", " ", "|", "|", "|", "|", " ", "_", "_", "|", "|", " ", "|"},
            {"|", " ", " ", "|", " ", " ", " ", " ", " ", "|", "|", " ", "|"},
            {"|", " ", "|", "|", " ", "|", " ", "|", " ", " ", " ", " ", "|"},
            {"|", "_", "|", " ", " ", "|", " ", "_", "_", "_", " ", "|", "|"},
            {"|", " ", " ", " ", "|", "|", " ", " ", "_", "_", " ", " ", "|"},
            {"|", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
    };


    ArrayStack lastPosition = new ArrayStack(1,0);
    ArrayStack position1 = new ArrayStack(1,0);
    ArrayStack position2 = new ArrayStack(1,0);

    public void start() {
        position1.push(1);
        position2.push(6);
        lastPosition.push(0);
    }


    public void walkMaze() {
        start();
        while (!findExit()) {
            markWay();
            System.out.println("\n");
            printOutMaze();
            if ((maze[position1.lastPosition()][position2.lastPosition() - 1] == " ") || (maze[position1.lastPosition()][position2.lastPosition() - 1] == "S")) {
                position2.push(position2.lastPosition() - 1);
                lastPosition.push(0);
            }else
            if ((maze[position1.lastPosition() + 1][position2.lastPosition()] == " ") || (maze[position1.lastPosition() + 1][position2.lastPosition()] == "s")) {
                position1.push(position1.lastPosition() + 1);
                lastPosition.push(1);
            }else
            if ((maze[position1.lastPosition()][position2.lastPosition() + 1] == " ") || (maze[position1.lastPosition()][position2.lastPosition() + 1] == "S")) {
                position2.push(position2.lastPosition() + 1);
                lastPosition.push(2);
            }else
            if ((maze[position1.lastPosition() - 1][position2.lastPosition()] == " ") || (maze[position1.lastPosition() - 1][position2.lastPosition()] == "s")) {
                position1.push(position1.lastPosition() - 1);
                lastPosition.push(3);
            }else{
                switch(lastPosition.lastPosition()) {
                    case 0:
                        position2.pop();
                        lastPosition.pop();
                        break;
                    case 1:
                        lastPosition.pop();
                        position1.pop();
                        break;
                    case 2:
                        lastPosition.pop();
                        position2.pop();
                        break;
                    case 3:
                        position1.pop();
                        lastPosition.pop();
                        break;
                }
            }
        }
    }

    public void markWay() {
        if (maze[position1.lastPosition()][position2.lastPosition()] == "E")
            maze[position1.lastPosition()][position2.lastPosition()] = "E";
        else if (maze[position1.lastPosition()][position2.lastPosition()] == "S")
            maze[position1.lastPosition()][position2.lastPosition()] = "S";
        else{
            maze[position1.lastPosition()][position2.lastPosition()] = "*";
        }
    }

    public boolean findExit() {
        if (maze[position1.lastPosition()][position2.lastPosition()] == "S") {
            System.out.println("\nYou got it!\n");
            return true;
        }
        else if (position1.isEmpty() || position2.isEmpty()) {
            System.out.println("\nthere is no way out!\n");
            return true;
        }
        return false;
    }

    public void printOutMaze() {
        for (String[] strings : maze) {
            String arrayMaze = Arrays.toString(strings);
            arrayMaze = arrayMaze.replace(",", " ");
            System.out.println(arrayMaze);
        }
    }
}
