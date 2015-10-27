package ca.ubc.ece.cpen221.mp3.graph;

import java.util.HashSet;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class ArrayListObject {
    
    private HashSet<Vertex> adjacentVertices;
    private Vertex head;

    public ArrayListObject() {
        head = new Vertex("");
        adjacentVertices = new HashSet<Vertex>();
    }
    
    public ArrayListObject( Vertex v) {
        head = v;
        adjacentVertices = new HashSet<Vertex>();
    }
    
    public ArrayListObject(Vertex v, HashSet<Vertex> h){
        head = v;
        adjacentVertices = h;
    }

    boolean isEdge(Vertex v){
        if(adjacentVertices.contains(v)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void addEdge(Vertex v){
        adjacentVertices.add(v);
    }
    
    public Vertex getHead(){
        Vertex h = new Vertex("");
        h = head;
        return h;
    }
    
    public HashSet<Vertex> getAdjacentVertices(){
        HashSet<Vertex> v = new HashSet<Vertex>();
        v = adjacentVertices;
        return v;
    }
}
