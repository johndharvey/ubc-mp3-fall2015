package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.List;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {

    private ArrayList<ArrayList<Vertex>> listOfLists;

    private List<Vertex> generateSublist(List<Vertex> l) {
        List<Vertex> sublist = new ArrayList<Vertex>();
        int size = l.size();        
        for(int i = 1; i<size; i++){
            sublist.add(l.get(i));
        }
        return sublist;
    }

    private int findIndex(Vertex v) {
        int index = -1;
        int size = listOfLists.size();
        for (int i = 0; i < size; i++) {
            if (listOfLists.get(i).get(0).equals(v)) {
                index = i;
            }
        }
        return index;
    }

    public AdjacencyListGraph() {
        listOfLists = new ArrayList<ArrayList<Vertex>>();
    }

    @Override
    public void addVertex(Vertex v) {
        ArrayList<Vertex> newList = new ArrayList<Vertex>();
        newList.add(v);
        listOfLists.add(newList);
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        int size = listOfLists.size();
        for (int i = 0; i < size; i++) {
            if (listOfLists.get(i).get(0).equals(v1)) {
                listOfLists.get(i).add(v2);
            }
        }
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        boolean edgeExists = false;
        int index = this.findIndex(v1);
        List<Vertex> sublist = new ArrayList<Vertex>();
        sublist = generateSublist(listOfLists.get(index));
        if (sublist.contains(v2)) {
            edgeExists = true;
        }
        return edgeExists;
    }

    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        int index = this.findIndex(v);
        List<Vertex> downstreamNeighbours = new ArrayList<Vertex>();
        downstreamNeighbours = generateSublist(listOfLists.get(index));
        return downstreamNeighbours;
    }

    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        List<Vertex> upstreamNeighbours = new ArrayList<Vertex>();
        int size = listOfLists.size();
        Vertex head = new Vertex("");
        for (int i = 0; i < size; i++) {
            List<Vertex> sublist = new ArrayList<Vertex>();
            sublist = generateSublist(listOfLists.get(i));
            if (sublist.contains(v)) {
                head = listOfLists.get(i).get(0);
                upstreamNeighbours.add(head);
                System.out.println("In this case, element " + (i + 1) + " is an upstream neighbour");
            }
        }
        return upstreamNeighbours;
    }

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> vertices = new ArrayList<Vertex>();
        int size = listOfLists.size();
        for (int i = 0; i < size; i++) {
            vertices.add(listOfLists.get(i).get(0));
        }
        return vertices;
    }

}
