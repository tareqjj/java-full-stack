import java.util.HashMap;
import java.util.Set;

public class Hashmatique {

    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Maybe be sometimes", "I don't know where to go");
        trackList.put("Don't be hard on yourself", "Take a deep breath, and move on");
        trackList.put("I am not sure", "not sure of where I belong");
        trackList.put("Take me away", "Take me away, somewhere faraway");

        String lyrics = trackList.get("Take me away");
        Set<String> keys = trackList.keySet();
        for (String key:keys){
            System.out.println("Track: " + key + ", Lyrics: " + trackList.get(key));
        }
    }
}
