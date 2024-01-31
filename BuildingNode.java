public class BuildingNode {

    public String name;
    public Point pos;
    public int length;
    public int height;
    public Point displayPos;
    public int displayLength;
    public int displayHeight;
    public int[] color;

    public BuildingNode( String name, int len, int height, int[] color ) {
        this.name = name;
        this.length = len;
        displayLength = len;
        this.height = height;
        displayHeight = height;
        this.color = color.clone();
    }

    public void setPos( Point pos ) {
        this.pos = pos;
        displayPos = pos;
    }

    public void setScale( double l_scale, double h_scale ) {
        displayLength = (int) ( length/l_scale );
        displayHeight = (int) ( height/h_scale );
        displayPos = new Point( (int) ( pos.getX()/l_scale ), (int) ( pos.getY()/l_scale ) );
    }
}