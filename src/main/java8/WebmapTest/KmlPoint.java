package WebmapTest;


import WebmapTest.StartingCoordinateOfKml;

import java.util.ArrayList;

public class KmlPoint implements StartingCoordinateOfKml {

    private ArrayList<String> segments;

    public KmlPoint(ArrayList<String> segment){
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
        return "KmlPoints{" +
                "segments=" + segments +
                '}';
    }

    public String toJSONString(){
        return segments.toString();
    }

}

