package lang.view;


import java.io.File;
import java.util.Formatter;
import java.util.HashMap;
import java.lang.*;
import java.util.Iterator;
import java.util.Map;


import static lang.view.LinkedList.writeToFile;

public class topic {
   private static String topicName;
   private static LinkedList wordList;
   public topic(String topicName, LinkedList wordList)
   {
       this.topicName=topicName;
       this.wordList=wordList;
   }

    //LinkedList mediaObj = new LinkedList();

    public static File dailyRoutineFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\dailyRoutineFile");
    public static File educationFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\educationFile");
    public static File foodFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\foodFile");
    public static File personalDetailsFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\personalDetailsFile");
    public static File appearanceFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\appearanceFile");
    public static File healthFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\healthFile");
    public static File relationshipsFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\relationshipsFile");
    public static File shoppingFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\shoppingFile");
    public static File empolymentFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\empolymentFile");
    public static File entertainmentFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\entertainmentFile");
    public static File holidaysFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\holidaysFile");
    public static File mediaFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\mediaFile");
    public static File sportFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\sportFile");
    public static File technologyFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\technologyFile");
    public static File transportFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\transportFile");
    public static File environmentFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\environmentFile");
    public static File globalIssuesFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\globalIssuesFile");
    public static File neighbourhoodFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\neighbourhoodFile");
    public static File geographyFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\geographyFile");
    public static File townsAndServicesFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\townsAndServicesFile");
    public static File weatherFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\weatherFile");
    public static File otherFile = new File("C:\\Users\\kapoo\\Desktop\\yeet - Copy.zip\\src\\otherFile");
    static private Formatter f;

    public static LinkedList dailyRoutineObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList educationObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList foodObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList personalDetailsObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList appearanceObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList healthObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList relationshipsObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList shoppingObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList employmentObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList entertainmentObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList holidaysObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList mediaObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList sportObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList technologyObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList transportObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList environmentObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList globalIssuesObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList neighbourhoodObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList geographyObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList townsAndServicesObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList weatherObj = new LinkedList("ESP", "ENG", 50);
    public static LinkedList otherObj = new LinkedList("ESP", "ENG", 50);

    public static HashMap<String, LinkedList> topicMap = new HashMap();

    public static void initializeHashMap() {

        topicMap.put("Daily Routines", dailyRoutineObj);
        topicMap.put("Education",educationObj);
        topicMap.put("Food and Drink",foodObj);
        topicMap.put("Personal Details",personalDetailsObj);
        topicMap.put("Appearance and Character",appearanceObj);
        topicMap.put("Health",healthObj);
        topicMap.put("Relationships",relationshipsObj);
        topicMap.put("Shopping",shoppingObj);
        topicMap.put("Employment",employmentObj);
        topicMap.put("Entertainment",entertainmentObj);
        topicMap.put("Holidays",holidaysObj);
        topicMap.put("Media",mediaObj);
        topicMap.put("Sport",sportObj);
        topicMap.put("Technology",technologyObj);
        topicMap.put("Transport",transportObj);
        topicMap.put("Environment",environmentObj);
        topicMap.put("Global Issues",globalIssuesObj);
        topicMap.put("Neighbourhood",neighbourhoodObj);
        topicMap.put("Geography",geographyObj);
        topicMap.put("Towns and Services",townsAndServicesObj);
        topicMap.put("Weather",weatherObj);
        topicMap.put("Other",otherObj);
    }
    public static void traverseHashMap(String topic, String esp, String eng/*,int rating, String notes*/) {
//initializeHashMap();
        topicMap.get(topic).addAtTail(esp,eng,50);
        writeToFile(topic,esp,eng,50) ;
       // dailyRoutineObj.printList();

    }
    public static String getTopicName()
    {
        return topicName;
    }
}

