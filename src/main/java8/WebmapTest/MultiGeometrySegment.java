package WebmapTest;


import java.util.ArrayList;

public class MultiGeometrySegment implements StartingCoordinateOfKml {
    private ArrayList<ArrayList<String>> segments;

    public MultiGeometrySegment(ArrayList<?> segments){
        if (segments != null && segments.isEmpty() == false
                && segments.get(0) instanceof ArrayList<?>){
            this.segments = (ArrayList<ArrayList<String>>) segments;
        }
        else{
            this.segments = new ArrayList<ArrayList<String>>();
        }
    }

    public void addSegment(ArrayList<String> segment){
        segments.add(segment);
    }

    public ArrayList<ArrayList<String>> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<ArrayList<String>> segments) {
        this.segments = segments;
    }

    @Override
    public String toString() {
        return "RouteSegment{" +
                "segments=" + segments +
                '}';
    }
}
