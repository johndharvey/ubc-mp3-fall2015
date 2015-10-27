package ca.ubc.ece.cpen221.mp3.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AlgorithmsTest {

    @Test
    public void testBFS() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph amg = new AdjacencyListGraph(); 
        // AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph(); 
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
        
        Set<List<Vertex>> BFSset = Algorithms.BFS(amg);  
        
        assertTrue("checking first list of vertices.", BFSset.containsAll(checklist1));
        assertTrue("checking second list of vertices.", BFSset.containsAll(checklist2));
        assertTrue("checking third list of vertices.", BFSset.containsAll(checklist3));
        assertTrue("checking fourth list of vertices.", BFSset.containsAll(checklist4));
        assertTrue("checking fifth list of vertices.", BFSset.containsAll(checklist5));
        assertTrue("checking sixth list of vertices.", BFSset.containsAll(checklist6));
        
        
    }

    @Test
    public void testDFS() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph amg = new AdjacencyListGraph();
        // AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph(); 
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
        
        Set<List<Vertex>> DFSset = Algorithms.DFS(amg);  
        
        assertTrue("checking first list of vertices.", DFSset.containsAll(checklist1));
        assertTrue("checking first list of vertices.", DFSset.containsAll(checklist2));
        assertTrue("checking first list of vertices.", DFSset.containsAll(checklist3));
        assertTrue("checking first list of vertices.", DFSset.containsAll(checklist4));
        assertTrue("checking first list of vertices.", DFSset.containsAll(checklist5));
        assertTrue("checking first list of vertices.", DFSset.containsAll(checklist6));


        

    }

    @Test
    public void testShortestDistance() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph amg = new AdjacencyListGraph();
        // AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph();
        
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
        
        assertEquals("Should equal 4.", Algorithms.shortestDistance(amg, testv1, testv6), 4);
    }

    @Test
    public void testCommonUps() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph amg = new AdjacencyListGraph();
        //AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph();
        
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

    @Test
    public void testCommonDowns() {
        Vertex testv1 = new Vertex("A");
        Vertex testv2 = new Vertex("B");
        Vertex testv3 = new Vertex("C");
        Vertex testv4 = new Vertex("D");
        Vertex testv5 = new Vertex("E");
        Vertex testv6 = new Vertex("F");
        
        AdjacencyListGraph amg = new AdjacencyListGraph();
        // AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph(); 
        
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

}
