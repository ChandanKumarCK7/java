package WebmapTest;






import java.util.ArrayList;

public class RouteSegment implements StartingCoordinateOfKml {

    ArrayList<String> segments;

    public RouteSegment(ArrayList<String> segment){
            this.segments = segment;

    }

    public ArrayList<String> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<String> segments) {
        this.segments = segments;
    }

    @Override
    public String toString() {
        return "RouteSegment{" +
                "segments=" + segments +
                '}';
    }

    //    public RouteSegment(ArrayList<String> segment){
//        this.segments = new ArrayList<ArrayList<String>>();
//        this.segments.add(segment);
//    }
}
