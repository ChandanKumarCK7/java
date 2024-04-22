















package WebmapTest;






import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class backup {

    static HashMap<String, StartingCoordinateOfKml> additionalInfo = new HashMap<>(); // to be stored in db as CLOB that contains  segments, points
    static HashMap<String, List<String>> placemarkHashMap = new HashMap<>(); // each placemark will have entire
    // map of the placemark's name and list of all coordinates in that (segment only)

    static HashMap<String, String> lastCoordinateHashMap = new HashMap<>(); // each placemark's last coordinate will be
    // stored so that next time in merging the name of placemark can be unique.
    static HashMap<String, String> startingCoordinateHashMap = new HashMap<>(); // each placemark's first coordinate will be
    // stored so that next time in merging the name of placemark can be unique.
    static int placemarkCounter = 0; // keeps track of placemarks processed
    static StringBuilder globalCoordinate = new StringBuilder(); // will be used to all coordinates of segments only

    static String xmlFile = "C:\\Users\\chitchan\\Desktop\\random\\webmap\\normallllllWithBothMultiAndPoint.kml";



    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

//        HashMap<String, StartingCoordinateOfKml> additionalInfo = new HashMap<>();
//        additionalInfo.put("linhas",
//                new MultiGeometrySegment(new ArrayList<>(Arrays.asList("45.0", "45.0", "0"),
//                        Arrays.asList("46.0", "46.0", "0"))));
//
//        additionalInfo.put("linhas1", new RouteSegment(new ArrayList<>(Arrays.asList("5.0", "45.0", "0"))));


        boolean status = checkIfOldFlowWillBeSufficient();
        System.out.println("status "+status);
        segmentStorer();
        justPrint();

        String lineString = segmentMerger();






    }

    private static boolean checkIfOldFlowWillBeSufficient() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        System.out.println("here");
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        System.out.println("here1 "+xmlFile);
        Document doc = dBuilder.parse(xmlFile);
        System.out.println("her8");
        doc.getDocumentElement().normalize();
        System.out.println("here9");
        System.out.printf("Root element: {}", doc.getDocumentElement().getNodeName());
        System.out.println();

        NodeList placemarkList = doc.getElementsByTagName("Placemark");
        if (placemarkList.getLength() == 1)
            return true;

        System.out.println("Looping through placemark tags");

        int lineStringCounter = 0, pointCounter = 0;
        for (int i = 0; i < placemarkList.getLength(); i++) {
            Node pNode = placemarkList.item(i);

            if (pNode.getNodeType() == Node.ELEMENT_NODE) {
                Element pElement = (Element) pNode;
                NodeList tmpName = pElement.getElementsByTagName("name");
//                    System.out.println("tmpName: "+ tmpName.item(0).getTextContent());
                System.out.println();

                NodeList tmpLineString = pElement.getElementsByTagName("LineString");
                if (tmpLineString.getLength() > 0){
                    lineStringCounter++;
                    if (lineStringCounter > 1){
                        return false;
                    }
                }
                else if (tmpLineString.getLength() == 0){
                    // manhole or maybe just multigeometry

                    NodeList tmpPoint = pElement.getElementsByTagName("Point");
                    if (tmpPoint.getLength() > 0)
                        pointCounter++;
                    if (pointCounter >2){
                        return false;
                    }

                }
            }
        }
        return true;
    }
    private static void segmentStorer(){
        System.out.println("enter segmentMerging");





        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            System.out.println("here");
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            System.out.println("here1 "+xmlFile);
            Document doc = dBuilder.parse(xmlFile);
            System.out.println("her8");
            doc.getDocumentElement().normalize();
            System.out.println("here9");
            System.out.printf("Root element: {}", doc.getDocumentElement().getNodeName());
            System.out.println();

            NodeList placemarkList = doc.getElementsByTagName("Placemark");
            System.out.println("Looping through placemark tags");

            for (int i = 0; i < placemarkList.getLength(); i++) {
                Node pNode = placemarkList.item(i);

                if (pNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element pElement = (Element) pNode;
                    NodeList tmpName = pElement.getElementsByTagName("name");
//                    System.out.println("tmpName: "+ tmpName.item(0).getTextContent());
                    System.out.println();

                    NodeList tmpLineString = pElement.getElementsByTagName("LineString");
                    NodeList multiString = pElement.getElementsByTagName("MultiGeometry");
                    System.out.println(tmpName.item(0).getTextContent()+" ------- "+tmpLineString.getLength()+"    "+multiString.getLength());
                    if (tmpLineString.getLength() > 0 && multiString.getLength() == 0 ){
                        findCoordinatesForLineStringAndAppend(tmpLineString, tmpName.item(0).getTextContent());
                    }
                    else if (tmpLineString.getLength() == 0){
                        // manhole or maybe just multigeometry

                        NodeList tmpPoint = pElement.getElementsByTagName("Point");
                        if (tmpPoint != null && tmpPoint.getLength() > 0){
                            if (isValidIP(tmpName.item(0).getTextContent()) == false)
                                findCoordinatesForPointAndAppend(tmpPoint, tmpName.item(0).getTextContent() );
                        }

                    }
                    else if (multiString.getLength() > 0){
                        System.out.println("yeah there are some multigeometries bruhhhhhhhh");

                        // only points
                        if (tmpLineString.getLength() == 0){
                            NodeList tmpPoint = pElement.getElementsByTagName("Point");
                            if (tmpPoint != null && tmpPoint.getLength() > 0){
                                findCoordinatesForPointAndAppend(tmpPoint, tmpName.item(0).getTextContent() );
                            }
                        }
                        else if (tmpLineString.getLength() > 0){
                            // lineStrings in the multigeometry.
                            findCoordinatesForEachSegmentInMultiGeometryAndAppend(tmpLineString, tmpName.item(0).getTextContent());
                        }



                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error at "+ e);
        }

        System.out.println("exit segmentMerging");

    }

    private static void justPrint(){




        System.out.println("additionalInfo "+additionalInfo);
        System.out.println("placemarkHashMap "+placemarkHashMap);
        System.out.println("lastCoordinateHashMap "+lastCoordinateHashMap);
        System.out.println("startingCoordinateHashMap "+startingCoordinateHashMap);
        System.out.println("globalCoordinate "+ globalCoordinate);



    }





    private static void findCoordinatesForLineStringAndAppend(NodeList tmpLineString, String segmentName){
        if (tmpLineString.getLength() > 0) {





            System.out.println(segmentName + tmpLineString);
            Element lineStringElement = (Element) tmpLineString.item(0);
            NodeList coordinatesList = lineStringElement.getElementsByTagName("coordinates");

            if (coordinatesList.getLength() > 0) {
                Element coordinatesElement = (Element) coordinatesList.item(0);
                String coordinates = coordinatesElement.getTextContent().trim();
                String[] coordinatesArray = fetchCoordinatesAsArray(coordinates);
                String startingCoordinate = coordinatesArray[0];
                String lastCoordinate = coordinatesArray[coordinatesArray.length-1].trim();
                System.out.println(coordinatesArray.length);

                // data appenders
                additionalInfo.put(segmentName, new RouteSegment(new ArrayList<>(Arrays.asList(startingCoordinate))));
                System.out.println();
                lastCoordinateHashMap.put(lastCoordinate, segmentName);
                System.out.println();
                placemarkHashMap.put(segmentName, new ArrayList<>(Arrays.asList(coordinatesArray)));
                startingCoordinateHashMap.put(startingCoordinate, segmentName);


                // Process the coordinates as needed

                if (globalCoordinate.isEmpty()){
                    globalCoordinate.append(Arrays.toString(coordinatesArray));
                }



            }
        }
    }

//    private static void findCoordinatesForPointAndAppend(NodeList tmpPoint, String tmpName){
//        Element pointElement = (Element) tmpPoint.item(0);
//        NodeList coordinates = pointElement.getElementsByTagName("coordinates");
//
//        String[] cooordinatesArray = new String[1];
//        cooordinatesArray[0] = coordinates.toString();
//        // data appenders
//        additionalInfo.put(tmpName, new KmlPoint(new ArrayList<>(Arrays.asList(cooordinatesArray))));
//    }

    private static void findCoordinatesForPointAndAppend(NodeList tmpPoint, String tmpName){
        for(int i =0; i < tmpPoint.getLength();){

            Element pointElement = (Element) tmpPoint.item(i);
            NodeList coordinatesList = pointElement.getElementsByTagName("coordinates");

            Element coordinatesElement = (Element) coordinatesList.item(0);
            String coordinates = coordinatesElement.getTextContent().trim();





            String[] coordinatesArray = fetchCoordinatesAsArray(coordinates);
            String startingCoordinate = coordinatesArray[0];
            // data appenders
            if (tmpPoint.getLength() == 1){
                additionalInfo.put(tmpName+"_PT", new KmlPoint(new ArrayList<>(Arrays.asList(startingCoordinate))));
            }
            else{
                additionalInfo.put(tmpName+i+"_PT", new KmlPoint(new ArrayList<>(Arrays.asList(startingCoordinate))));
            }
            i++;
        }

    }

    private static void findCoordinatesForEachSegmentInMultiGeometryAndAppend(NodeList tmpLineString, String segmentName){
        MultiGeometrySegment multiGeometrySegments = new MultiGeometrySegment(new ArrayList<>());


        boolean onlyPointsArePresentInMultigeometry = checkIfOnlyPointsArePresentInMultigeometry(tmpLineString, segmentName);
        for(int i=0; i< tmpLineString.getLength();){
            Element lineStringElement = (Element) tmpLineString.item(i);
            NodeList coordinatesList = lineStringElement.getElementsByTagName("coordinates");
            Element coordinatesElement = (Element) coordinatesList.item(0);
            String coordinates = coordinatesElement.getTextContent().trim();
            System.out.println("multigeometry Segment "+ coordinates+ segmentName);
            String[] coordinatesArray = fetchCoordinatesAsArray(coordinates);
            String startingCoordinate = coordinatesArray[0];
            String lastCoordinate = coordinatesArray[coordinatesArray.length-1].trim();
            System.out.println(coordinatesArray.length);
            multiGeometrySegments.addSegment(new ArrayList<>(Arrays.asList(startingCoordinate)));
            lastCoordinateHashMap.put(lastCoordinate, segmentName+i);
            placemarkHashMap.put(segmentName+i, new ArrayList<>(Arrays.asList(coordinatesArray)));
            startingCoordinateHashMap.put(startingCoordinate, segmentName+i);

            if (globalCoordinate.isEmpty()){
                globalCoordinate.append(Arrays.toString(coordinatesArray));
            }

            i++;
        }
        System.out.println("multi "+multiGeometrySegments);


        additionalInfo.put(segmentName, multiGeometrySegments);
    }

    public static boolean checkIfOnlyPointsArePresentInMultigeometry(NodeList tmpLineString, String segmentName){



        int counter = 0;
        for (int i = 0; i < tmpLineString.getLength(); i++) {
            Node pNode = tmpLineString.item(i);
            if (pNode.getNodeType() == Node.ELEMENT_NODE) {
                Element pElement = (Element) pNode;
                NodeList tmpPoint = pElement.getElementsByTagName("Point");
                NodeList tmpName = pElement.getElementsByTagName("name");
                if (tmpPoint != null && tmpPoint.getLength() > 0){
                    if (isValidIP(tmpName.item(0).getTextContent()) == false)
                        counter+=1;
                }
            }

        }

        System.out.println("of tags of multigeometry "+tmpLineString.getLength() + "counter "+counter);
        if (tmpLineString.getLength() == counter)
            return true;
        return false;



    }

    public static String[] fetchCoordinatesAsArray(String coordinates){
        String[] coordinatesArray = coordinates.split("\n");
//        Arrays.stream(coordinatesArray).forEach(e -> e.trim());



        String[] returnable = new String[coordinatesArray.length];
        for( int i =0; i < coordinatesArray.length; i++){
            String coordinatesString = coordinatesArray[i].trim().stripTrailing().stripLeading();
            returnable[i] = coordinatesString;
        }
        return returnable;

    }

    public static String segmentMerger(){
        for(int i =0 ; i < startingCoordinateHashMap.size(); i++){
            String[] coordinatesArray = globalCoordinate.toString().substring(1, globalCoordinate.toString().length()-1).split(" ");
            System.out.println(Arrays.toString(coordinatesArray));

            String lastCoordinate = coordinatesArray[coordinatesArray.length-1].trim();



            if (lastCoordinateHashMap.containsKey(lastCoordinate)){
                String firstCoordinateSegmentName = startingCoordinateHashMap.get(lastCoordinate);

                globalCoordinate.append(placemarkHashMap.get(firstCoordinateSegmentName));
            }

            System.out.println("lastCoordinate "+ lastCoordinate);
        }


        System.out.println("globalCoordinate "+ globalCoordinate.toString());
        return globalCoordinate.toString();

    }


    public static boolean isValidIP(String ipAddress) {
        System.out.println("ipAddress check "+ipAddress);
        if (ipAddress == null || ipAddress.isEmpty())
            return false;

        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4)
            return false;

        for (String part : parts) {
            try {
                int value = Integer.parseInt(part);
                if (value < 0 || value > 255)
                    return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }




}
