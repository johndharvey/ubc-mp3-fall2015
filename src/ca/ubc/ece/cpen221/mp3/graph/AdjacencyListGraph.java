package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {

    private HashMap<Vertex, HashSet<Vertex>> adjMap;

    public AdjacencyListGraph() {
        adjMap = new HashMap<Vertex, HashSet<Vertex>>();
    }

    @Override
    public void addVertex(Vertex v) {
        HashSet<Vertex> map = new HashSet<Vertex>();
        map = adjMap.get(v);
        if (map == null) {
            adjMap.put(v, null);
        }
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        HashSet<Vertex> map = new HashSet<Vertex>();
        map = adjMap.get(v1);
        if (map == null) {
            HashSet<Vertex> newMap = new HashSet<Vertex>();
            newMap.add(v2);
            adjMap.put(v1, newMap);
        } else if (!map.contains(v2)) {
            adjMap.get(v1).add(v2);
        }
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        HashSet<Vertex> map = new HashSet<Vertex>();
        map = adjMap.get(v1);
        if (map != null && map.contains(v2)) {
            return true;
        } else
            return false;
    }

    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        HashSet<Vertex> downMap = new HashSet<Vertex>();
        List<Vertex> downstreamNeighbours = new LinkedList<Vertex>();
        downMap = adjMap.get(v);
        if (downMap != null) {
            downstreamNeighbours = new LinkedList<Vertex>(downMap);
        }
        return downstreamNeighbours;
    }

    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        List<Vertex> upstreamNeighbours = new ArrayList<Vertex>();
        
        for (HashMap.Entry<Vertex, HashSet<Vertex>> entry : adjMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().contains(v)) {
                upstreamNeighbours.add(entry.getKey());
            }
        }
        return upstreamNeighbours;
    }

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> vertices = new LinkedList<Vertex>(adjMap.keySet());
        return vertices;
    }
}
