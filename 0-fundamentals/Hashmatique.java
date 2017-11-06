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

// How CD did it:

public class HashMatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();

        trackList.put("Song1", "LYRICS");
        trackList.put("Song2", "LYRICS");
        trackList.put("Song3", "LYRICS");
        trackList.put("Song4", "LYRICS");

        String track = trackList.get("Song1");
        System.out.println(track);

        for(String key : trackList.keySet()) {
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}