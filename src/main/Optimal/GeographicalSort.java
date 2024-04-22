import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;


public class GeographicalSort {

    public static void main(String[] args) {
        String coordinatesStr = "150.216736400471,-26.658073290804,0 150.216252,-26.6592399999993,0 150.216252,-26.6592399999993,0 150.199394,-26.6594979999993,0 150.180087,-26.6552059999993,0 150.175878,-26.6547569999993,0 150.175878,-26.6547569999993,0 150.076932,-26.6467329999993,0 150.175878,-26.6547569999993,0 150.076932,-26.6467329999993,0 150.199394,-26.6594979999993,0 150.185156,-26.6558169999993,0 150.185156,-26.6558169999993,0 150.180087,-26.6552059999993,0";

        // Split the coordinates string
        String[] coordinatesArray = coordinatesStr.split("\\s+");

        // Convert and sort the coordinates
//        Arrays.sort(coordinatesArray, (coord1, coord2) -> {
//            String[] parts1 = coord1.split(",");
//            String[] parts2 = coord2.split(",");
//            double lat1 = Double.parseDouble(parts1[1]);
//            double lon1 = Double.parseDouble(parts1[0]);
//            double lat2 = Double.parseDouble(parts2[1]);
//            double lon2 = Double.parseDouble(parts2[0]);
//            if (lat1 != lat2) {
//                return Double.compare(lat1, lat2);
//            } else {
//                return Double.compare(lon1, lon2);
//            }
//        });

        LinkedHashSet<String> h = new LinkedHashSet<>();
        for(int i =0; i < coordinatesArray.length; i++){
            String[] parts1 = coordinatesArray[i].split(",");
            double lat1 = Double.parseDouble(parts1[1]);
            double lon1 = Double.parseDouble(parts1[0]);
            h.add(lon1+","+lat1+",0");
            double minLatitude = Double.MAX_VALUE, minLongitude = Double.MAX_VALUE;
            for(int j = 0; j < coordinatesArray.length; j++){
                String[] parts2 = coordinatesArray[i].split(",");
                double lat2 = Double.parseDouble(parts1[1]);
                double lon2 = Double.parseDouble(parts1[0]);
                if (i!= j && h.contains(lat2+","+lon2) == false){
                     if (Math.abs(lat1) - Math.abs(lat2) < minLatitude && Math.abs(lon1) - Math.abs(lon2) < minLongitude){
                         minLatitude= lat2;
                         minLongitude = lon2;
                     }
                 }
            }
            h.add(minLongitude+","+minLatitude+",0");
        }

        // Print the sorted coordinates and total count
        System.out.println("Sorted Coordinates:");
        for (String coordinate : coordinatesArray) {
            System.out.print(coordinate + " ");
        }

        System.out.println("sorted hashset");
        System.out.println(h);

        // <coordinates>150.216736400471,-26.658073290804,0 150.216252,-26.6592399999993,0 150.216252,-26.6592399999993,0
        // 150.199394,-26.6594979999993,0 150.180087,-26.6552059999993,0 150.175878,-26.6547569999993,0
        // 150.175878,-26.6547569999993,0 150.076932,-26.6467329999993,0 150.175878,-26.6547569999993,0
        // 150.076932,-26.6467329999993,0 150.199394,-26.6594979999993,0
        // 150.185156,-26.6558169999993,0 150.185156,-26.6558169999993,0 150.180087,-26.6552059999993,0</coordinates>

        System.out.println("\nTotal Coordinates Count: " + coordinatesArray.length);
    }
}
