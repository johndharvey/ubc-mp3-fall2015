package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class Algorithms {
    
     static boolean[] visited;

     /**
      * Uses breadth-first search algorithm on an adjacencyGraph and
      * returns a set of each individual vertex's breadth-first relationships.
      * 
      * @param adjacencyGraph
      * @return Set<List<Vertex>>
      */
    public static Set<List<Vertex>> BFS(Graph adjacencyGraph){
        Set<List<Vertex>> vertexSet = new HashSet<List<Vertex>>();    
        List<Vertex> vertexList = new ArrayList<Vertex>();
        
        
        for (int i = 0; i < adjacencyGraph.getVertices().size(); i++){
            
            vertexList.add(adjacencyGraph.getVertices().get(i));  //adds first indexed element to the list
            vertexList.addAll(adjacencyGraph.getDownstreamNeighbors(adjacencyGraph.getVertices().get(i))); //adds the downstream neighbours to the list
            List<Vertex> tempList = vertexList;
            
            if (tempList.size() > 1){  //if there are no downstream neighbours, no need to check the list
            for (int j = 1; j < tempList.size(); j++){ 
                List<Vertex> funList = adjacencyGraph.getDownstreamNeighbors(vertexList.get(j)); //checks the elements of the vertexlist
                                                                                                    //for it's downstream neighbours
                for (int k = 0; k < funList.size(); k++){
                if (!vertexList.contains(funList.get(k))){   //if vertexList doesn't already contain this element in the temporary list, adds it, so as
                      vertexList.add(funList.get(k));                                          // not to have repeats                  
                }
                }
            }
            }
            vertexSet.add(vertexList);
            vertexList.clear();
            tempList.clear();
            
        }
        return vertexSet;
    }    
       
    
    /**
     * Uses a depth-first search algorithm and returns each list of
     * vertex relationships as a set of the whole.
     * 
     * 
     * @param adjacencyGraph
     * @return Set<List<Vertex>>
     */
    
    public static Set<List<Vertex>> DFS(Graph adjacencyGraph){
        Set<List<Vertex>> vertexSet = new HashSet<List<Vertex>>(); 
        List<Vertex> vertexList = new ArrayList<Vertex>();
        
        for (int i = 0; i < adjacencyGraph.getVertices().size(); i++){
        
        DFinner(i, vertexList, adjacencyGraph); //calls the DFinner function
            
        
        vertexSet.add(vertexList);
        vertexList.clear();
        for ( int l = 0; l < visited.length; l++){  //resets the visited boolean array
            visited[l] = false;   
        }
        
    }
        return vertexSet;

    }
    
    /**
     * Finds an individual vertex's depth-first relationships and returns them as a list.
     * @param i
     * @param vertexList
     * @param adjacencyGraph
     * @return
     */
    private static List<Vertex> DFinner(int i, List<Vertex> vertexList, Graph adjacencyGraph){
        
        visited[i] = true;  //tells us we've visited this particular element/index
        
        vertexList.add(adjacencyGraph.getVertices().get(i));  //adds the element to the vertexList
        
        for (int j = 0; j < adjacencyGraph.getVertices().size(); j++){
            
            if ( !adjacencyGraph.getDownstreamNeighbors(adjacencyGraph.getVertices().get(i)).isEmpty() && !visited[j]) 
                DFinner(j, vertexList, adjacencyGraph);                                                               
        }
        
        return vertexList;
       
    }

    /**
     * Generates the shortest distance between two vertices on an adjacency graph.
     * 
     * @param adjacencyGraph
     * @param vertex - a
     * @param vertex - b
     * @return int - distance
     */
	public static int shortestDistance (Graph adjacencyGraph, Vertex a, Vertex b) throws IllegalArgumentException{
	    
	        List<Vertex> vertexList = new ArrayList<Vertex>();
            List<Vertex> tempList = new ArrayList<Vertex>();

	        int counter = 0;
	        
	        if (a == b)                //the distance between a vertex and itself is zero, this ends the method
	                return 0;
	        
            vertexList = adjacencyGraph.getDownstreamNeighbors(a);  //fills the vertex list with the first downstream neighbours
            if (!vertexList.isEmpty())
                counter++;  //as long there are downstream neighbours, counter goes up by 1
            
	            while (!vertexList.contains(b)){   //while the vertexlist doesn't contain the target vertex
	            
	            for (int i = 0; i < vertexList.size(); i++){
	             
	                tempList.addAll(adjacencyGraph.getDownstreamNeighbors(vertexList.get(i)));   //creates a temporary list that is made up of 
	            }                                                                                //the vertices' downstream vertices      
	            
	            vertexList = tempList;  //sends that list to vertexlist
	            tempList.clear();     //clears templist to prepare it for later usage
	            
	            if (!vertexList.isEmpty())  //as long as there were downstream neighbours counter++
	            counter++;
	            
	            else if (vertexList.isEmpty() == true)  //if there weren't any downstream neighbours, there isn't a connection between the two vertices
	                throw new IllegalArgumentException("No path exists between these vectors!");

	            }
	            	            
	            return counter;
	            
	        }
	        	 
	/**
	 * Returns a list of shared upstream vertices of two vertices.
	 * 
	 * 
	 * @param G - adjacency graph
	 * @param a Vertex
	 * @param b Vertex
	 * @return List<Vertex>
	 */
	public static List<Vertex> commonUps(Graph G, Vertex a, Vertex b){
	    
	    List<Vertex> alist = new ArrayList<Vertex>();
	    List<Vertex> blist = new ArrayList<Vertex>();

	    alist = G.getUpstreamNeighbors(a);  
	    blist = G.getUpstreamNeighbors(b);
	    
	    alist.retainAll(blist);  //this just compares the two lists and keeps the one's that are shared in alist
	    
	    return alist;
	    
	}
	
   /**
     * Returns a list of shared downstream vertices of two vertices.
     * 
     * 
     * @param G - adjacency graph
     * @param a Vertex
     * @param b Vertex
     * @return List<Vertex>
     */
     public static List<Vertex> commonDowns(Graph G, Vertex a, Vertex b){
	        
         List<Vertex> alist = new ArrayList<Vertex>();
         List<Vertex> blist = new ArrayList<Vertex>();

         alist = G.getDownstreamNeighbors(a);
         blist = G.getDownstreamNeighbors(b);
         
         alist.retainAll(blist);
         
         return alist;
	        
	}

}
