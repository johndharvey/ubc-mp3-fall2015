package ca.ubc.ece.cpen221.mp3.graph;

import java.util.LinkedList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListObject {

    private Vertex ObjectVertex;
    private List<Vertex> AdjacentVertices;

    /**
     * Constructor for ArrayListObject
     * @param name The name of the vertex in the object
     */
    public AdjacencyListObject(String name) {
        ObjectVertex = new Vertex(name);
        AdjacentVertices = new LinkedList<Vertex>();
    }
    
    public AdjacencyListObject(Vertex v, List<Vertex> l){
        ObjectVertex = v;
        AdjacentVertices = l;
    }

    public AdjacencyListObject clone(){
        return new AdjacencyListObject(this.getVertex(), this.getAdjacentVertices());
    }

    /**
     * Determines whether v1, the vertex on which the function is called, is connected to v2 
     * 
     * @param v2 a vertex
     * @return true if v1 is connected to v2, false otherwise
     */
    public boolean isConnected(Vertex v2) {
        if (AdjacentVertices.contains(v2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an edge between the vertex on which the function is called and the passed vertex, v
     * 
     * @param v The vertex at the end of the newly-constructed edge
     * @return false if the vertexes were already connected, true otherwise.
     */
    public boolean addEdge(Vertex v) {
        if (this.isConnected(v)) {
            return false;
        } else {
            AdjacentVertices.add(v);
            return true;
        }
    }

    /**
     * Removes an edge between the vertex on which the function is called and the passed vertex, v
     * 
     * @param v The vertex on the end of the vertex to be removed
     * @return true if the edge existed and has been removed, false if it did not exist in the first place
     */
    public boolean removeEdge(Vertex v) {
        if (!this.isConnected(v)) {
            return false;
        } else {
            AdjacentVertices.remove(v);
            return true;
        }
    }

    /**
     * Returns the list of vertices which are adjacent to the vertex on which the function is called
     * @return a List of all vertices which are adjacent to the vertex on which the function is called
     */
    public List<Vertex> getAdjacentVertices() {
        List<Vertex> AdjacentVerticesCopy = new LinkedList<Vertex>();
        int size = AdjacentVertices.size();
        Vertex returnVertex = new Vertex("");
        for(int i = 0; i<size; i++){
            returnVertex.setLabel(AdjacentVertices.get(i).getLabel());
            AdjacentVerticesCopy.add(returnVertex);
        }
        return AdjacentVerticesCopy;
    }
    
    /**
     * Returns a copy of the vertex on which the function is called.
     * @return a Vertex which is a copy of the vertex on which the function is called
     */
    public Vertex getVertex(){
        Vertex returnVertex = new Vertex("");
        returnVertex.setLabel(ObjectVertex.getLabel());
        return returnVertex;
    }

}
