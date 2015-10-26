package twitterAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class TwitterAnalysis {
    public static void main(String[] args) throws IOException {
        Graph twitterGraph = new AdjacencyListGraph();
        twitterGraph = createGraph();
        
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
                List<String> answer = new ArrayList<String>();
                String queryType = columns[0];
                String userID1 = columns[1];
                String userID2 = columns[2];
                if (columns[1].equals("commonInfluencers")) {
                    answer = commonInfluencers(userID1, userID2, twitterGraph);
                } else if (columns[0].equals("numRetweets")) {
                    answer.add(numRetweets(userID1, userID2, twitterGraph));
                } else {
                    answer.add("ERROR");
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

    public static List<String> commonInfluencers(String userID1, String userID2, Graph graph) {
        List<String> commonInfluencers = new ArrayList<String>();
        List<Vertex> vertexList = new ArrayList<Vertex>();
 
        // call common upstream neighbours, and put all their user IDs in a list of strings
        
        vertexList = Algorithms.commonUps(graph, new Vertex(userID1), new Vertex(userID2));
                        
        for(int j = 0; j < vertexList.size(); j++){
            commonInfluencers.add(vertexList.get(j).toString());
        }
        return commonInfluencers;
    }

    public static String numRetweets(String userID1, String userID2, Graph graph) {
        Integer shortestPath = 0;

        shortestPath = Algorithms.shortestDistance(graph, new Vertex(userID1),new Vertex(userID2));
        String s = Integer.toString(shortestPath);
        return s;
    }

    public static Graph createGraph() {
        FileInputStream data;
        AdjacencyListGraph twitter = new AdjacencyListGraph();
        try {
            data = new FileInputStream("twitter.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedReader twitterReader = new BufferedReader(
                    new InputStreamReader(data));

            String line;

            while ((line = twitterReader.readLine()) != null) {
                String[] columns = line.split(" ");
                String userID1 = columns[0];
                String userID2 = columns[2];
                Vertex v1 = new Vertex(userID1);
                Vertex v2 = new Vertex(userID2);
                if (!twitter.getVertices().contains(v1)) {
                    twitter.addVertex(v1);
                }
                if (!twitter.getVertices().contains(v1)) {
                    twitter.addVertex(v2);
                }
                if (!twitter.edgeExists(v1, v2)) {
                    twitter.addEdge(v1, v2);
                }
            }
            twitterReader.close();
        } catch (Exception e) {
            // If, for any reason, we had some problems reading data...
            throw new RuntimeException(e);
        }
        return twitter;
    }
}
