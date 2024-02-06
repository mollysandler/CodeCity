import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Math.*;

public class Builder {

    public ArrayList< BuildingNode > buildings;
    public int x_wid, y_len, x_space, y_space;

    public Builder() {
        buildings = new ArrayList<>();
        x_wid = y_len = x_space = y_space = 0;
    }

    public void addFromJSON( JSONObject classes ){
        Iterator<String> keys = classes.keys();
        while ( keys.hasNext() ) {
            String n = keys.next();
            int h = (Integer) classes.getJSONObject(n).get("loc");
            int l = (Integer) classes.getJSONObject(n).get("localVars");  // colors randomized where data not given
            int[] color = new int[]{(int) (random() * 255), (int) (random() * 255), (int) (random() * 255)};
            BuildingNode b = new BuildingNode(n, l, h, color);
            b.setPos(placeBuilding(b.length));
            buildings.add(b);
        }
    }

    public Point placeBuilding(int len ) {  // basic spacing algorithm, add to right or bottom or corner
        Point pos;
        if ( len <= x_space && len <= y_space) {  // add in corner
            pos = new Point( x_wid - len, y_len - len );
            x_space = y_space = 0;
        } else if ( y_len < x_wid) {  // add below
            pos = new Point( 0, y_len );
            y_len += len;
            if ( len < x_wid ) {
                y_space += len;
                x_space = x_wid - len;
            } else {
                x_wid = len;
                x_space = y_space = 0;
            }
        } else {  // add to right
            pos = new Point( x_wid, 0 );
            x_wid += len;
            if ( len < y_len ) {
                x_space += len;
                y_space = min( y_space, y_len - len );
            } else {
                y_len = len;
                x_space = y_space = 0;
            }
        }
        return pos;
    }

    public ArrayList< BuildingNode > getBuildings( double l_scale, double h_scale ) {
        for ( BuildingNode b : buildings ) {
            b.setScale( l_scale, h_scale );
        }
        return buildings;
    }

    public ArrayList< BuildingNode > getBuildings() {
        return buildings;
    }
}
