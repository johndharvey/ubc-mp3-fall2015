package ca.ubc.ece.cpen221.mp3.graph;

import java.util.LinkedList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {
    // TODO: Implement this class
    private List<AdjacencyListObject> AdjacencyList;

    public AdjacencyListGraph() {
        AdjacencyList = new LinkedList<AdjacencyListObject>();
    }

    @Override
    public void addVertex(Vertex v) {
        // TODO Auto-generated method stub
        AdjacencyListObject newVertex = new AdjacencyListObject(v.getLabel());
        AdjacencyList.add(newVertex);
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        if (AdjacencyList.contains(v1) && AdjacencyList.contains(v2)) {
            AdjacencyList.get(AdjacencyList.indexOf(v1)).addEdge(v2);
            AdjacencyList.get(AdjacencyList.indexOf(v2)).addEdge(v1);
        }
        // nothing should happen if the specified vertices aren't in the graph
        // I don't think I can throw an exception, although I'd like to.
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        if (AdjacencyList.contains(v1) && AdjacencyList.contains(v2)) {
            if (AdjacencyList.get(AdjacencyList.indexOf(v1)).isConnected(v2)
                    || AdjacencyList.get(AdjacencyList.indexOf(v2))
                            .isConnected(v1)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        // TODO Auto-generated method stub
        if (AdjacencyList.contains(v)) {
            return AdjacencyList.get(AdjacencyList.indexOf(v))
                    .returnAdjacentVertices();
        } else {
            // in the case that the vertex doesn't exist, and given that we
            // can't throw exceptions (???) I return an uninitialized list.
            List<Vertex> downstreamNeighbours = new LinkedList<Vertex>();
            return downstreamNeighbours;
        }
    }

    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        // TODO Auto-generated method stub
        List<Vertex> upstreamNeighbours = new LinkedList<Vertex>();
        int size = AdjacencyList.size();
        for (int i = 0; i < size; i++) {
            if (AdjacencyList.get(i).isConnected(v)) {
                upstreamNeighbours.add(AdjacencyList.get(i).returnVertex());
            }
        }
        return upstreamNeighbours;
    }

    @Override
    public List<Vertex> getVertices() {
        // TODO Auto-generated method stub
        List<Vertex> Vertices = new LinkedList<Vertex>();
        int size = AdjacencyList.size();
        for (int i = 0; i < size; i++) {
            Vertices.add(AdjacencyList.get(i).returnVertex());
        }
        return Vertices;
    }
}
