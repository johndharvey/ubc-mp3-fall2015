package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {

    private HashMap<Vertex, HashSet<Vertex>> adjMap;
    // private HashSet<ArrayListObject> setOfSets;
    // private ArrayList<ArrayList<Vertex>> listOfLists;

    /*private ArrayListObject vertexExists(Vertex v) {
        try {
            for (ArrayListObject o : setOfSets) {
                if (o.getHead().equals(v)) {
                    return o;
                }
            }
        } catch (NullPointerException e) {
            return null;
        }
        return null;
    }*/

    /*
     * private List<Vertex> generateSublist(List<Vertex> l) { List<Vertex>
     * sublist = new ArrayList<Vertex>(); int size = l.size(); for(int i = 1;
     * i<size; i++){ sublist.add(l.get(i)); } return sublist; }
     * 
     * private int findIndex(Vertex v) { int index = -1; int size =
     * listOfLists.size(); for (int i = 0; i < size; i++) { if
     * (listOfLists.get(i).get(0).equals(v)) { index = i; } } return index; }
     */

    public AdjacencyListGraph() {
        /*setOfSets = new HashSet<ArrayListObject>();*/
        /*listOfLists = new ArrayList<ArrayList<Vertex>>();*/
        adjMap = new HashMap<Vertex, HashSet<Vertex>>();
    }

    @Override
    public void addVertex(Vertex v) {
        HashSet<Vertex> map = new HashSet<Vertex>();
        map = adjMap.get(v);
        if (map == null){
            adjMap.put(v, null);
        }
        
        /*if (vertexExists(v) == null) {
            ArrayListObject o = new ArrayListObject(v);
            setOfSets.add(o);
        }*/

        /*
         * ArrayList<Vertex> newList = new ArrayList<Vertex>(); newList.add(v);
         * listOfLists.add(newList);
         */
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        HashSet<Vertex> map = new HashSet<Vertex>();
        map = adjMap.get(v1);
        if (map==null){
            HashSet<Vertex> newMap = new HashSet<Vertex>();
            newMap.add(v2);
            adjMap.put(v1, newMap);
        } else if (!map.contains(v2)){
            adjMap.get(v1).add(v2);
        }
        
        /*ArrayListObject o = vertexExists(v1);
        if (o != null && o.getAdjacentVertices().contains(v2)) {
            o.addEdge(v2);
        }*/

        /*
         * int size = listOfLists.size(); for (int i = 0; i < size; i++) { if
         * (listOfLists.get(i).get(0).equals(v1)) { listOfLists.get(i).add(v2);
         * } }
         */
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        HashSet<Vertex> map = new HashSet<Vertex>();
        map = adjMap.get(v1);
        if(map != null && map.contains(v2)){
            return true;
        }
        else return false;
        
        /*ArrayListObject o = vertexExists(v1);
        if (o != null && o.getAdjacentVertices().contains(v2)) {
            return true;
        } else {
            return false;
        }*/

        /*
         * // TODO Auto-generated method stub boolean edgeExists = false; int
         * index = this.findIndex(v1); List<Vertex> sublist = new
         * ArrayList<Vertex>(); sublist =
         * generateSublist(listOfLists.get(index)); if (sublist.contains(v2)) {
         * edgeExists = true; } return edgeExists;
         */
    }

    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        HashSet<Vertex> downMap = new HashSet<Vertex>();
        List<Vertex> downstreamNeighbours = new LinkedList<Vertex>();
        downMap = adjMap.get(v);
        if(downMap!=null){
            downstreamNeighbours = new LinkedList<Vertex>(downMap);
        }
        return downstreamNeighbours;
        
        /*ArrayListObject o = vertexExists(v);
        List<Vertex> downstreamNeighbours = new ArrayList<Vertex>();
        if (o != null) {
            for (Vertex vv : o.getAdjacentVertices()) {
                downstreamNeighbours.add(vv);
            }
        }
        return downstreamNeighbours;*/

        /*
         * int index = this.findIndex(v); List<Vertex> downstreamNeighbours =
         * new ArrayList<Vertex>(); downstreamNeighbours =
         * generateSublist(listOfLists.get(index)); return downstreamNeighbours;
         */
    }

    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        List<Vertex> upstreamNeighbours = new ArrayList<Vertex>();
        
        for (HashMap.Entry<Vertex, HashSet<Vertex>> entry : adjMap.entrySet()) {
            if(entry.getValue() != null && entry.getValue().contains(v)){
                upstreamNeighbours.add(entry.getKey());
            }
        }
        
        return upstreamNeighbours;
        
        /*List<Vertex> upstreamNeighbours = new ArrayList<Vertex>();

        for (ArrayListObject o : setOfSets) {
            if (o.getAdjacentVertices().contains(v)) {
                upstreamNeighbours.add(o.getHead());
            }
        }*/



        /*
         * int size = listOfLists.size(); Vertex head = new Vertex(""); for (int
         * i = 0; i < size; i++) { List<Vertex> sublist = new
         * ArrayList<Vertex>(); sublist = generateSublist(listOfLists.get(i));
         * if (sublist.contains(v)) { head = listOfLists.get(i).get(0);
         * upstreamNeighbours.add(head); } } return upstreamNeighbours;
         */
    }

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> vertices = new LinkedList<Vertex>(adjMap.keySet());
        
        
        /*List<Vertex> vertices = new LinkedList<Vertex>();
        try {
            for (ArrayListObject o : setOfSets) {
                vertices.add(o.getHead());
            }
        } catch (NullPointerException e) {
            return vertices;
        }
        return vertices;*/

        /*
         * int size = listOfLists.size(); for (int i = 0; i < size; i++) {
         * vertices.add(listOfLists.get(i).get(0)); } return vertices;
         */
        
        return vertices;
    }

}
