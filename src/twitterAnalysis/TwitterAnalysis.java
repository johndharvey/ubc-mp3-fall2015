package twitterAnalysis;

import java.io.*;
import java.util.*;

public class TwitterAnalysis {
    public static void main(String[] args) {
        FileInputStream queries;
        FileOutputStream answers;

        Writer output;
        output = new BufferedWriter(new FileWriter("answers.txt"));
        output.append("ANSWERS:");
        output.close();

        try {
            queries = new FileInputStream("queries.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedReader twitterReader = new BufferedReader(
                    new InputStreamReader(queries));

            String line;

            while ((line = twitterReader.readLine()) != null) {
                String[] columns = line.split(" ");
                String answer = "";
                String queryType = columns[0];
                String userID1 = columns[1];
                String userID2 = columns[2];
                if (columns[1].equals("commonInfluencers")) {
                    answer = commonInfluencers(userID1, userID2);
                } else if (columns[0].equals("numRetweets")) {
                    answer = numRetweets(userID1, userID2);
                } else {
                    answer = "ERROR";
                }

                output = new BufferedWriter(
                        new FileWriter("answers.txt", true));

                output.write(
                        "query " + queryType + " " + userID1 + " " + userID2);
                output.write("<result>");
                output.write("    " + answer);
                output.write("</result>");
                output.close();
            }
            twitterReader.close();
        } catch (Exception e) {
            // If, for any reason, we had some problems reading data...
            throw new RuntimeException(e);
        }
    }
    
    public String commonInfluencers(String userID1, String userID2){
        return null;
    }
    
    public String numRetweets(String userID1, String userID2){
        return null;
    }
}
