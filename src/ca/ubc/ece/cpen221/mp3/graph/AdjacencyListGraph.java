package ca.ubc.ece.cpen221.mp3.graph;

import java.util.LinkedList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {
    // TODO: Implement this class
    private List<AdjacencyListObject> AdjacencyObjectList;

    public AdjacencyListGraph() {
        AdjacencyObjectList = new LinkedList<AdjacencyListObject>();
    }

    private AdjacencyListObject returnAdjacencyListObject(Vertex v)
    { 
        int size = AdjacencyObjectList.size();
        AdjacencyListObject requestedObject = new AdjacencyListObject("");
        for(int i  = 0; i<size; i++){
            if(AdjacencyObjectList.get(i).getVertex().equals(v)){
                requestedObject = AdjacencyObjectList.get(i);
            }
        }
        return requestedObject;
    }
    
    @Override
    public void addVertex(Vertex v) {
        // TODO Auto-generated method stub
        AdjacencyListObject newVertex = new AdjacencyListObject(v.getLabel());
        AdjacencyObjectList.add(newVertex);
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        if (this.getVertices().contains(v1)
                && this.getVertices().contains(v2)) {
            this.returnAdjacencyListObject(v1).addEdge(v2);
        }
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        boolean edgeExists = false;
        if (getVertices().contains(v1) && getVertices().contains(v2)) {
            int size = AdjacencyObjectList.size();
            for (int i = 0; i < size; i++) {
                boolean rightObject = (AdjacencyObjectList.get(i).getVertex().equals(v1));
                boolean isAdjacent = AdjacencyObjectList.get(i).getAdjacentVertices().contains(v2);
                if (rightObject && isAdjacent) {
                    edgeExists = true;
                }
            }
        } 
        return edgeExists;
    }

    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        // TODO Auto-generated method stub
        List<Vertex> downstreamNeighbours = new LinkedList<Vertex>();
        int size = AdjacencyObjectList.size();
        for (int i = 0; i < size; i++) {
            boolean rightObject = (AdjacencyObjectList.get(i).getVertex().equals(v));
            if (rightObject){
                downstreamNeighbours = AdjacencyObjectList.get(i).getAdjacentVertices();
            }       
        }
        return downstreamNeighbours;
    }

    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        // TODO Auto-generated method stub
        List<Vertex> upstreamNeighbours = new LinkedList<Vertex>();
        int size = AdjacencyObjectList.size();
        for (int i = 0; i < size; i++) {
            if (AdjacencyObjectList.get(i).isConnected(v)) {
                upstreamNeighbours
                        .add(AdjacencyObjectList.get(i).getVertex());
            }
        }
        return upstreamNeighbours;
    }

    @Override
    public List<Vertex> getVertices() {
        // TODO Auto-generated method stub
        List<Vertex> Vertices = new LinkedList<Vertex>();
        int size = AdjacencyObjectList.size();
        for (int i = 0; i < size; i++) {
            Vertices.add(AdjacencyObjectList.get(i).getVertex());
        }
        return Vertices;
    }
}
