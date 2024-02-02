import org.json.JSONObject;
import java.util.*;
import static java.lang.Math.*;
import processing.core.PApplet;


public class Driver extends PApplet {
    private final int gridSize = 50; // size of each grid square
    private final int gridWidth = 10; // # of squares horizontally
    private final int gridHeight = 10; // # of squares vertically
    private HashMap<String, int[]> buildings; // to store block color and size
    private DrawBuildings build = new DrawBuildings();

    @Override
    public void settings() {
        size(gridWidth * gridSize, gridHeight * gridSize);
    }

    @Override
    public void setup() {
        System.out.println("hello setup");
        buildings = new HashMap<>();
        System.out.println(buildings);
        // red building of size 1 at (2,3)
        build.displayBuildingAtGridLocation(buildings, 2, 3, 255, 0, 0, 1);
        // yellow building of size 2 at (5,5)
        build.displayBuildingAtGridLocation(buildings, 5, 5, 225, 225, 0, 2);
        // blue building of size 1 at (1,1)
        build.displayBuildingAtGridLocation(buildings, 1, 1, 0, 0, 255, 1);

    }

    @Override
    public void draw() {

        background(255, 255, 255);
        //build.drawGrid();
        // to draw buildings
        buildings.forEach((key, info) -> {
            fill(info[0], info[1], info[2]);
            int[] coords = build.parseCoordinates(key);
            rect(coords[0] * gridSize, coords[1] * gridSize, info[3] * gridSize, info[3] * gridSize);
        });
    }

    public static void main(String[] args){
        GitClone gitClone = new GitClone("git@github.com:aayushjoshi16/CS-Projects.git");
        gitClone.clone_repo();
        PApplet.main("Driver");
    }
}
