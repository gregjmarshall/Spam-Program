
import java.util.*;
public class Spambot {

    public static List<String> visitedURLs = new ArrayList<String>();
    public static List<String> emailsFarmed = new ArrayList<String>();

    
    
    
    public static void main(String[] args) {
        
        Spider crawlerOne = new Spider("www.telegraph.co.uk");
        crawlerOne.beginCrawl();
        for (int i = 0; i < emailsFarmed.size(); i++){
        System.out.println(emailsFarmed.get(i));    
        }
        
        
        
    }
}
