package ca.ubc.ece.cpen221.mp3.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AlgorithmsTest {

    /**
     * Tests the Breadth-First Search of the Adjacency Matrix Graph type.
     */
    @Test
    public void testBFSMatrix() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph(); 
        amg.addVertex(testv1);
        amg.addVertex(testv2);
        amg.addVertex(testv3);
        amg.addVertex(testv4);
        amg.addVertex(testv5);
        amg.addVertex(testv6);
        
        amg.addEdge(testv1, testv2);
        amg.addEdge(testv1, testv3);
        amg.addEdge(testv2, testv4);
        amg.addEdge(testv2, testv5);
        amg.addEdge(testv5, testv6);
        
        List<Vertex> checklist1 = new ArrayList<Vertex>();
        checklist1.add(testv1);
        checklist1.add(testv2);
        checklist1.add(testv3);
        checklist1.add(testv4);
        checklist1.add(testv5);
        checklist1.add(testv6);
        List<Vertex> checklist2 = new ArrayList<Vertex>();
        checklist2.add(testv2);
        checklist2.add(testv4);
        checklist2.add(testv5);
        checklist2.add(testv6);
        List<Vertex> checklist3 = new ArrayList<Vertex>();
        checklist3.add(testv3);
        List<Vertex> checklist4 = new ArrayList<Vertex>();
        checklist4.add(testv4);
        List<Vertex> checklist5 = new ArrayList<Vertex>();
        checklist5.add(testv5);
        checklist5.add(testv6);
        List<Vertex> checklist6 = new ArrayList<Vertex>();
        checklist6.add(testv6);
        
        Set<List<Vertex>> checkList = new LinkedHashSet<List<Vertex>>();
        checkList.add(checklist1);
        checkList.add(checklist2);
        checkList.add(checklist3);
        checkList.add(checklist4);
        checkList.add(checklist5);
        checkList.add(checklist6);

        
        Set<List<Vertex>> BFSset = Algorithms.BFS(amg);  
        
        assertTrue("checking whether sets are equivalent", BFSset.equals(checkList));

    }
    
    /**
     * Tests the Breadth-First Search of the Adjacency List Graph type.
     */
    @Test
    public void testBFSList() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph alg = new AdjacencyListGraph(); 
        alg.addVertex(testv1);
        alg.addVertex(testv2);
        alg.addVertex(testv3);
        alg.addVertex(testv4);
        alg.addVertex(testv5);
        alg.addVertex(testv6);
        
        alg.addEdge(testv1, testv2);
        alg.addEdge(testv1, testv3);
        alg.addEdge(testv2, testv4);
        alg.addEdge(testv2, testv5);
        alg.addEdge(testv5, testv6);
        
        List<Vertex> checklist1 = new ArrayList<Vertex>();
        checklist1.add(testv1);
        checklist1.add(testv2);
        checklist1.add(testv3);
        checklist1.add(testv4);
        checklist1.add(testv5);
        checklist1.add(testv6);
        List<Vertex> checklist2 = new ArrayList<Vertex>();
        checklist2.add(testv2);
        checklist2.add(testv4);
        checklist2.add(testv5);
        checklist2.add(testv6);
        List<Vertex> checklist3 = new ArrayList<Vertex>();
        checklist3.add(testv3);
        List<Vertex> checklist4 = new ArrayList<Vertex>();
        checklist4.add(testv4);
        List<Vertex> checklist5 = new ArrayList<Vertex>();
        checklist5.add(testv5);
        checklist5.add(testv6);
        List<Vertex> checklist6 = new ArrayList<Vertex>();
        checklist6.add(testv6);
        
        Set<List<Vertex>> checkList = new LinkedHashSet<List<Vertex>>();
        checkList.add(checklist1);
        checkList.add(checklist2);
        checkList.add(checklist3);
        checkList.add(checklist4);
        checkList.add(checklist5);
        checkList.add(checklist6);

        
        Set<List<Vertex>> BFSset = Algorithms.BFS(alg);  
        
        assertTrue("checking whether sets are equivalent", BFSset.equals(checkList));

    }
    
    /**
     * Tests the Depth-First Search of the Adjacency Matrix Graph type.
     */
    @Test
    public void testDFSMatrix() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph(); 
        amg.addVertex(testv1);
        amg.addVertex(testv2);
        amg.addVertex(testv3);
        amg.addVertex(testv4);
        amg.addVertex(testv5);
        amg.addVertex(testv6);
        
        amg.addEdge(testv1, testv2);
        amg.addEdge(testv1, testv3);
        amg.addEdge(testv2, testv4);
        amg.addEdge(testv2, testv5);
        amg.addEdge(testv5, testv6);
        
        List<Vertex> checklist1 = new ArrayList<Vertex>();
        checklist1.add(testv1);
        checklist1.add(testv2);
        checklist1.add(testv4);
        checklist1.add(testv5);
        checklist1.add(testv6);
        checklist1.add(testv3);
        List<Vertex> checklist2 = new ArrayList<Vertex>();
        checklist2.add(testv2);
        checklist2.add(testv4);
        checklist2.add(testv5);
        checklist2.add(testv6);
        List<Vertex> checklist3 = new ArrayList<Vertex>();
        checklist3.add(testv3);
        List<Vertex> checklist4 = new ArrayList<Vertex>();
        checklist4.add(testv4);
        List<Vertex> checklist5 = new ArrayList<Vertex>();
        checklist5.add(testv5);
        checklist5.add(testv6);
        List<Vertex> checklist6 = new ArrayList<Vertex>();
        checklist6.add(testv6);
        
        Set<List<Vertex>> checkList = new LinkedHashSet<List<Vertex>>();
        checkList.add(checklist1);
        checkList.add(checklist2);
        checkList.add(checklist3);
        checkList.add(checklist4);
        checkList.add(checklist5);
        checkList.add(checklist6);
       
        
        Set<List<Vertex>> DFSset = Algorithms.DFS(amg);  
        
        assertTrue("checking whether sets are equivalent", DFSset.equals(checkList));


    }
    
    /**
     * Tests the Depth-First Search of the Adjacency List Graph type.
     */
    @Test
    public void testDFSList() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph alg = new AdjacencyListGraph(); 
        alg.addVertex(testv1);
        alg.addVertex(testv2);
        alg.addVertex(testv3);
        alg.addVertex(testv4);
        alg.addVertex(testv5);
        alg.addVertex(testv6);
        
        alg.addEdge(testv1, testv2);
        alg.addEdge(testv1, testv3);
        alg.addEdge(testv2, testv4);
        alg.addEdge(testv2, testv5);
        alg.addEdge(testv5, testv6);
        
        List<Vertex> checklist1 = new ArrayList<Vertex>();
        checklist1.add(testv1);
        checklist1.add(testv2);
        checklist1.add(testv4);
        checklist1.add(testv5);
        checklist1.add(testv6);
        checklist1.add(testv3);
        List<Vertex> checklist2 = new ArrayList<Vertex>();
        checklist2.add(testv2);
        checklist2.add(testv4);
        checklist2.add(testv5);
        checklist2.add(testv6);
        List<Vertex> checklist3 = new ArrayList<Vertex>();
        checklist3.add(testv3);
        List<Vertex> checklist4 = new ArrayList<Vertex>();
        checklist4.add(testv4);
        List<Vertex> checklist5 = new ArrayList<Vertex>();
        checklist5.add(testv5);
        checklist5.add(testv6);
        List<Vertex> checklist6 = new ArrayList<Vertex>();
        checklist6.add(testv6);
        
        Set<List<Vertex>> checkList = new LinkedHashSet<List<Vertex>>();
        checkList.add(checklist1);
        checkList.add(checklist2);
        checkList.add(checklist3);
        checkList.add(checklist4);
        checkList.add(checklist5);
        checkList.add(checklist6);
       
        
        Set<List<Vertex>> DFSset = Algorithms.DFS(alg);  
        
        assertTrue("checking whether sets are equivalent", DFSset.equals(checkList));

    }

    /**
     * This tests the shortest distance algorithm for an AdjancencyMatrixGraph
     */
    @Test
    public void testShortestDistanceMatrix() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph();
        
        amg.addVertex(testv1);
        amg.addVertex(testv2);
        amg.addVertex(testv3);
        amg.addVertex(testv4);
        amg.addVertex(testv5);
        amg.addVertex(testv6);
        
        amg.addEdge(testv1, testv2);
        amg.addEdge(testv1, testv3);
        amg.addEdge(testv2, testv4);
        amg.addEdge(testv2, testv5);
        amg.addEdge(testv5, testv6);
        
        int j = 3;
        
        assertEquals("Should equal 3.", Algorithms.shortestDistance(amg, testv1, testv6), j);
    }
    
    /**
     * This tests the shortest distance algorithm for an AdjancencyListGraph
     */
    @Test
    public void testShortestListMatrix() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph alg = new AdjacencyListGraph();
        
        alg.addVertex(testv1);
        alg.addVertex(testv2);
        alg.addVertex(testv3);
        alg.addVertex(testv4);
        alg.addVertex(testv5);
        alg.addVertex(testv6);
        
        alg.addEdge(testv1, testv2);
        alg.addEdge(testv1, testv3);
        alg.addEdge(testv2, testv4);
        alg.addEdge(testv2, testv5);
        alg.addEdge(testv5, testv6);
        
        int j = 3;
        
        assertEquals("Should equal 3.", Algorithms.shortestDistance(alg, testv1, testv6), j);
    }

    /**
     * This tests the common upstream algorithm for the Adjacency Matrix Graph type.
     */
    @Test
    public void testCommonUpsMatrix() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph();
        
        amg.addVertex(testv1);
        amg.addVertex(testv2);
        amg.addVertex(testv3);
        amg.addVertex(testv4);
        amg.addVertex(testv5);
        amg.addVertex(testv6);
        
        amg.addEdge(testv1, testv2);
        amg.addEdge(testv1, testv3);
        amg.addEdge(testv2, testv4);
        amg.addEdge(testv2, testv5);
        amg.addEdge(testv5, testv6);
        
        List<Vertex> checklist = new ArrayList<Vertex>();
        checklist.add(testv2);
        
        assertTrue("E & D should share B as an upstream neighbour.", Algorithms.commonUps(amg, testv5, testv4).containsAll(checklist));
    }

    /**
     * This tests the common upstream algorithm for the Adjacency List Graph type.
     */
    @Test
    public void testCommonUpsLine() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph alg = new AdjacencyListGraph();
        
        alg.addVertex(testv1);
        alg.addVertex(testv2);
        alg.addVertex(testv3);
        alg.addVertex(testv4);
        alg.addVertex(testv5);
        alg.addVertex(testv6);
        
        alg.addEdge(testv1, testv2);
        alg.addEdge(testv1, testv3);
        alg.addEdge(testv2, testv4);
        alg.addEdge(testv2, testv5);
        alg.addEdge(testv5, testv6);
        
        List<Vertex> checklist = new ArrayList<Vertex>();
        checklist.add(testv2);
        
        assertTrue("E & D should share B as an upstream neighbour.", Algorithms.commonUps(alg, testv5, testv4).containsAll(checklist));
    }
    
    /**
     * Tests the common downstream algorithm for the Adjacency Matrix Graph type.
     */
    @Test
    public void testCommonDownsMatrix() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph(); 
        
        amg.addVertex(testv1);
        amg.addVertex(testv2);
        amg.addVertex(testv3);
        amg.addVertex(testv4);
        amg.addVertex(testv5);
        amg.addVertex(testv6);
        
        amg.addEdge(testv1, testv2);
        amg.addEdge(testv1, testv3);
        amg.addEdge(testv2, testv4);
        amg.addEdge(testv2, testv5);
        amg.addEdge(testv5, testv6);
        
        assertTrue("If this is empty, it's working!", Algorithms.commonDowns(amg, testv5, testv4).isEmpty());
    }
    
    /**
     * Tests the common downstream algorithm for the Adjacency List Graph type.
     */
    @Test
    public void testCommonDownsList() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph alg = new AdjacencyListGraph(); 
        
        alg.addVertex(testv1);
        alg.addVertex(testv2);
        alg.addVertex(testv3);
        alg.addVertex(testv4);
        alg.addVertex(testv5);
        alg.addVertex(testv6);
        
        alg.addEdge(testv1, testv2);
        alg.addEdge(testv1, testv3);
        alg.addEdge(testv2, testv4);
        alg.addEdge(testv2, testv5);
        alg.addEdge(testv5, testv6);
        
        assertTrue("If this is empty, it's working!", Algorithms.commonDowns(alg, testv5, testv4).isEmpty());
    }
}
