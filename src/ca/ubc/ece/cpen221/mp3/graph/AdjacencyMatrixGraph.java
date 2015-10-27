package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraph implements Graph {

    private ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
    private ArrayList<ArrayList<Integer>> adjacencyMatrix = new ArrayList<ArrayList<Integer>>();

    /**
     * adds a vertex to the graph
     * 
     * @param v
     * 
     */
    @Override
    public void addVertex(Vertex v) {

        vertexList.add(v);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        
        for (int i = 0; i < vertexList.size(); i++){
            tempList.add(0);
        }
        if (vertexList.size() > 1){
        for (int j = 0; j < vertexList.size() - 1; j++){
            adjacencyMatrix.get(j).add(0);
        }
        }

        adjacencyMatrix.add(tempList);

    }

    /**
     * adds an edge between two vertices
     * 
     * @param v1
     * @param v2
     * 
     */
    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        int x;
        int y;

        x = vertexList.indexOf(v1);
        y = vertexList.indexOf(v2);
        
        adjacencyMatrix.get(x).set(y, 1);

    }

    /**
     * 
     * @param v1
     * @param v2
     * @return true if an edge exists between the two
     */
    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {

        int x;
        int y;

        x = vertexList.indexOf(v1);
        y = vertexList.indexOf(v2);

        return adjacencyMatrix.get(x).get(y) == 1;
    }

    /**
     * 
     * @param v
     * @return a list of neighbour vertices this vertex points toward
     */
    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {

        int x;
        x = vertexList.indexOf(v);

        List<Vertex> dwnsNeighbours = new LinkedList<Vertex>();
        
        if (adjacencyMatrix.isEmpty())
            return dwnsNeighbours;
        
        for (int i = 0; i < vertexList.size(); i++) {

            if (adjacencyMatrix.get(x).get(i) == 1) {

                dwnsNeighbours.add(vertexList.get(i));
            }
        }
        return dwnsNeighbours;
    }

    /**
     * 
     * @param v
     * @return a list of neighbor vertices that point toward this vertex
     */
    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {

        int y;
        y = vertexList.indexOf(v);

        List<Vertex> upstNeighbours = new LinkedList<Vertex>();
        
        if (adjacencyMatrix.isEmpty())
            return upstNeighbours;

        for (int i = 0; i < vertexList.size(); i++) {

            if (adjacencyMatrix.get(i).get(y) == 1) {

                upstNeighbours.add(vertexList.get(i));
            }
        }
        return upstNeighbours;
    }

    /**
     * 
     * @return the list of all vertices in the graph
     */
    @Override
    public List<Vertex> getVertices() {
        List<Vertex> listofVertices = new LinkedList<Vertex>();

        for (int i = 0; i < vertexList.size(); i++) {
            listofVertices.add(vertexList.get(i));
        }

        return listofVertices;
    }

}
