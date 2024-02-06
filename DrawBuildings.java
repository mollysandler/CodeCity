import processing.core.PApplet;
import java.util.HashMap;

public class DrawBuildings extends PApplet {

    private final int gridSize = 50; // size of each grid square
    private final int gridWidth = 10; // # of squares horizontally
    private final int gridHeight = 10; // # of squares vertically
    //private HashMap<String, int[]> buildings; // to store block color and size
//
//    @Override
//    public void setup() {
//        buildings = new HashMap<>();
//
//        // sample input
//        // red building of size 1 at (2,3)
//        displayBuildingAtGridLocation(2, 3, 255, 0, 0, 1);
//        // yellow building of size 2 at (5,5)
//        displayBuildingAtGridLocation(5, 5, 225, 225, 0, 2);
//        // blue building of size 1 at (1,1)
//        displayBuildingAtGridLocation(1, 1, 0, 0, 255, 1);
//    }
//
//    @Override
//    public void draw() {
//        background(255, 255, 255);
//        drawGrid();
//        // to draw buildings
//        buildings.forEach((key, info) -> {
//            fill(info[0], info[1], info[2]);
//            int[] coords = parseCoordinates(key);
//            rect(coords[0] * gridSize, coords[1] * gridSize, info[3] * gridSize, info[3] * gridSize);
//        });
//    }

    // to draw the grid
//    public void drawGrid() {
//        stroke(0);
//        noFill();
//        rect(0, 0, gridWidth * gridSize, gridHeight * gridSize);
//    }

    // to display a colored block at a specific grid location
    public void displayBuildingAtGridLocation(HashMap buildings, int gridX, int gridY,
                                              int colorR, int colorG, int colorB, int blockSize) {
        //System.out.println("hello display building");
        // debugging from thurs lab: when run from the driver, it gets to here and fails becuase
        buildings.put(gridX + "," + gridY, new int[]{colorR, colorG, colorB, blockSize});
    }

    // to parse coordinates from string
    public int[] parseCoordinates(String coord) {
        String[] parts = coord.split(",");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }


    //public static void main(String[] args) {
     //   PApplet.main("DrawBuildings");
    //}
}
