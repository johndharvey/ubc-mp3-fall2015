package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class Algorithms {

    /**
     * Uses breadth-first search algorithm on an adjacencyGraph and returns a
     * set of each individual vertex's breadth-first relationships.
     * 
     * @param adjacencyGraph
     * @return Set<List<Vertex>>
     */
    public static Set<List<Vertex>> BFS(Graph adjacencyGraph) {
        Set<List<Vertex>> vertexSet = new LinkedHashSet<List<Vertex>>();
        List<Vertex> vertexList = new ArrayList<Vertex>();
        Queue<Vertex> vertexQueue = new LinkedList<Vertex>();

        // we first add the element beginning the search to the queue

        for (int i = 0; i < adjacencyGraph.getVertices().size(); i++) {
            vertexQueue.add(adjacencyGraph.getVertices().get(i));
            vertexList.add(vertexQueue.peek());

            // while the queue has an element in it, it puts new items into
            // vertexlist, then
            // adds the downstream elements of the top element while removing
            // that element from the
            // queue
            while (!vertexQueue.isEmpty()) {
                if (!vertexList.contains(vertexQueue.peek())) {
                    vertexList.add(vertexQueue.peek());
                }
                vertexQueue.addAll(adjacencyGraph.getDownstreamNeighbors(vertexQueue.remove()));

            }
            // places the values of vertexlist into the vertex set
            List<Vertex> tempList3 = new ArrayList<Vertex>();
            tempList3.addAll(vertexList);
            vertexSet.add(tempList3);
            vertexList.clear();
        }

        return vertexSet;

    }

    /**
     * Uses a depth-first search algorithm and returns each list of vertex
     * relationships as a set of the whole.
     * 
     * 
     * @param adjacencyGraph
     * @return Set<List<Vertex>>
     */

    public static Set<List<Vertex>> DFS(Graph adjacencyGraph) {
        Set<List<Vertex>> vertexSet = new LinkedHashSet<List<Vertex>>();
        List<Vertex> vertexList = new ArrayList<Vertex>();
        ArrayList<Vertex> vertexQueue = new ArrayList<Vertex>();

        // we first add the element beginning the search to the queue

        for (int i = 0; i < adjacencyGraph.getVertices().size(); i++) {
            vertexQueue.add(adjacencyGraph.getVertices().get(i));
            vertexList.add(vertexQueue.get(0));

            // while the queue has an element in it, it puts new items into
            // vertexlist, then
            // adds the downstream elements of the top element while removing
            // that element from the
            // queue
            while (!vertexQueue.isEmpty()) {
                if (!vertexList.contains(vertexQueue.get(0))) {
                    vertexList.add(vertexQueue.get(0));
                }
                vertexQueue.addAll(0, adjacencyGraph.getDownstreamNeighbors(vertexQueue.remove(0)));

            }
            // places the values of vertexlist into the vertex set
            List<Vertex> tempList3 = new ArrayList<Vertex>();
            tempList3.addAll(vertexList);
            vertexSet.add(tempList3);
            vertexList.clear();
        }

        return vertexSet;

    }

    /**
     * Generates the shortest distance between two vertices on an adjacency
     * graph.
     * 
     * @param adjacencyGraph
     * @param vertex
     *            - a
     * @param vertex
     *            - b
     * @return int - distance
     */
    public static int shortestDistance(Graph adjacencyGraph, Vertex a, Vertex b) throws IllegalArgumentException {

        List<Vertex> vertexList = new ArrayList<Vertex>();
        List<Vertex> tempList = new ArrayList<Vertex>();

        int counter = 0;

        // the distance between a vertex and itself is zero, this ends the
        // method
        if (a == b)
            return 0;

        // fills the vertex list with the first downstream neighbours
        vertexList = adjacencyGraph.getDownstreamNeighbors(a);
        if (!vertexList.isEmpty())
            // as long there are downstream neighbours, counter goes up by 1
            counter++;

        // while the vertexlist doesn't contain the target vertex
        while (!vertexList.contains(b)) {

            for (int i = 0; i < vertexList.size(); i++) {

                // creates a temporary list that is made up of the vertices'
                // downstream vertices
                tempList.addAll(adjacencyGraph.getDownstreamNeighbors(vertexList.get(i)));
            }

            // sends that list to vertexlist
            vertexList.addAll(tempList);
            // clears templist to prepare it for later usage
            tempList.clear();

            // as long as there were downstream neighbours counter++
            if (!vertexList.isEmpty())
                counter++;

            // if there weren't any downstream neighbours, there isn't a
            // connection between the two vertices
            else if (vertexList.isEmpty() == true)
                throw new IllegalArgumentException("No path exists between these vectors!");

        }

        return counter;

    }

    /**
     * Returns the list of shared upstream vertices of two vertices.
     * 
     * 
     * @param G
     *            - adjacency graph
     * @param a
     *            - Vertex
     * @param b
     *            - Vertex
     * @return List<Vertex>
     */
    public static List<Vertex> commonUps(Graph G, Vertex a, Vertex b) {

        List<Vertex> alist = new ArrayList<Vertex>();
        List<Vertex> blist = new ArrayList<Vertex>();

        alist.clear();
        blist.clear();

        alist = G.getUpstreamNeighbors(a);
        blist = G.getUpstreamNeighbors(b);

        // this just compares the two lists and keeps the one's that are shared
        // in alist

        alist.retainAll(blist);

        return alist;
    }

    /**
     * Returns the list of shared downstream vertices of two vertices.
     * 
     * 
     * @param G
     *            - adjacency graph
     * @param a
     *            - Vertex
     * @param b
     *            - Vertex
     * @return List<Vertex>
     */
    public static List<Vertex> commonDowns(Graph G, Vertex a, Vertex b) {

        List<Vertex> alist = new ArrayList<Vertex>();
        List<Vertex> blist = new ArrayList<Vertex>();

        alist = G.getDownstreamNeighbors(a);
        blist = G.getDownstreamNeighbors(b);

        alist.retainAll(blist);

        return alist;
    }
}
