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

    /**
     * 
     * @param v
     * @return
     */
    public boolean isConnected(Vertex v) {
        if (AdjacentVertices.contains(v)) {
            return false;
        } else {
            AdjacentVertices.remove(v);
            return true;
        }
    }

    public boolean addEdge(Vertex v) {
        if (this.isConnected(v)) {
            return false;
        } else {
            AdjacentVertices.add(v);
            return true;
        }
    }

    public boolean removeEdge(Vertex v) {
        if (!this.isConnected(v)) {
            return false;
        } else {
            AdjacentVertices.remove(v);
            return true;
        }
    }

    public List<Vertex> returnAdjacentVertices() {
        List<Vertex> AdjacentVerticesCopy = new LinkedList<Vertex>();
        int size = AdjacentVertices.size();
        Vertex returnVertex = new Vertex("tempName");
        for(int i = 0; i<size; i++){
            returnVertex.setLabel(AdjacentVertices.get(i).getLabel());
            AdjacentVerticesCopy.add(returnVertex);
        }
        return AdjacentVerticesCopy;
    }
    
    public Vertex returnVertex(){
        Vertex returnVertex = new Vertex("tempName");
        returnVertex.setLabel(ObjectVertex.getLabel());
        return returnVertex;
    }
}
