import java.util.HashMap;


public class Hashmatique {

    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("Breakfast","I love hashbrowns in the mornin");
        trackList.put("Lunch", "I still eat hashbrowns for lunch");
        trackList.put("McDs Hash", "All bout that big breakfast hash");
        trackList.put("Python Hash", "I miss commenting in Python");
        String bf = trackList.get("Breakfast");
        for (HashMap.Entry<String, String> e : trackList.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}