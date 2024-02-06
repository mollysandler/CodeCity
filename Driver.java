import org.json.JSONObject;
import java.util.*;
import static java.lang.Math.*;
import processing.core.PApplet;


public class Driver extends PApplet {
    private final int gridSize = 50; // size of each grid square
    private final int gridWidth = 10; // # of squares horizontally
    private final int gridHeight = 10; // # of squares vertically
    private HashMap<String, int[]> buildings = new HashMap<>(); // to store block color and size
    private DrawBuildings build = new DrawBuildings();
    private Builder builder = new Builder();

    @Override
    public void settings() {
        size(gridWidth * gridSize, gridHeight * gridSize);
    }

    @Override
    public void setup() {
        System.out.println("hello setup");
        System.out.println(buildings);

        JSONObject classes = Parsing.loadData("/Users/mollysandler/Documents/coursework-1/308/CodeCity/SpiderWorld");
        System.out.println(classes);
        builder.addFromJSON(classes);
        System.out.println(classes);

        System.out.println(builder.getBuildings());

        for (BuildingNode bn : builder.getBuildings()) {
            //String message = "Building at (";
            //message += bn.displayPos.getX() + "," + bn.displayPos.getY() + "), length ";
            //message += bn.displayLength + ", color " + Arrays.toString(bn.color);
            //System.out.println(message);

            // red building of size 1 at (2,3)
            //build.displayBuildingAtGridLocation(buildings, 2, 3, 255, 0, 0, 1);
            // yellow building of size 1 at (5,5)
            //build.displayBuildingAtGridLocation(buildings, 5, 5, 225, 225, 0, 1);
            // blue building of size 1 at (1,1)
            build.displayBuildingAtGridLocation(buildings, bn.displayPos.getX(), bn.displayPos.getY(), bn.color[0], bn.color[1], bn.color[2], bn.displayLength);
        }
    }

        @Override
        public void draw () {
            background(255, 255, 255);
            //build.drawGrid();
            // to draw buildings
            buildings.forEach((key, info) -> {
                fill(info[0], info[1], info[2]);
                int[] coords = build.parseCoordinates(key);
                rect(coords[0] * gridSize, coords[1] * gridSize, info[3] * gridSize, info[3] * gridSize);
            });
        }

        public static void main (String[]args){
            GitClone gitClone = new GitClone("git@github.com:mollysandler/SpiderWorld.git");
            gitClone.clone_repo();
            PApplet.main("Driver");
        }
    }
