
import java.util.*;
public class Spambot {

    public static List<String> visitedURLs;
    public static List<String> emailsFarmed;

    
    
    
    public static void main(String[] args) {
        
        Spider crawlerOne = new Spider("www.telegraph.co.uk");
        crawlerOne.beginCrawl();
        for (int i = 0; i < emailsFarmed.size(); i++){
        System.out.println(emailsFarmed.get(i));    
        }
        
        
        
    }
}
