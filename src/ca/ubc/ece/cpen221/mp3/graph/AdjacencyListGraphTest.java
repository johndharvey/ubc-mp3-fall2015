/**
 * 
 */
package ca.ubc.ece.cpen221.mp3.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

/**
 * @author John
 *
 */
public class AdjacencyListGraphTest {

    /**
     * Test method for {@link ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph#addVertex(ca.ubc.ece.cpen221.mp3.staff.Vertex)}.
     */
    @Test
    public void testVertices() {
        AdjacencyListGraph TestGraph = new AdjacencyListGraph();
        List<Vertex> TestList = new LinkedList<Vertex>();
        
        assertEquals("The lists should be the same: both empty.", TestList, TestGraph.getVertices());
        
        Vertex testVertex1 = new Vertex("v1");
        Vertex testVertex2 = new Vertex("v2");
        Vertex testVertex3 = new Vertex("v3");
        Vertex testVertex4 = new Vertex("v4");
        Vertex testVertex5 = new Vertex("v5");
        
        TestGraph.addVertex(testVertex1);
        TestGraph.addVertex(testVertex2);
        TestGraph.addVertex(testVertex3);
        TestGraph.addVertex(testVertex4);
        TestGraph.addVertex(testVertex5);
        
        TestList.add(testVertex1);
        TestList.add(testVertex2);
        TestList.add(testVertex3);
        TestList.add(testVertex4);
        TestList.add(testVertex5);        
        
        assertEquals("The lists should be the same: all five vertices.", TestList, TestGraph.getVertices());
        
        TestList.remove(testVertex3);

        assertFalse("The lists should not be the same.", TestList.equals(TestGraph.getVertices()));
    }

    /**
     * Test method for {@link ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph#addEdge(ca.ubc.ece.cpen221.mp3.staff.Vertex, ca.ubc.ece.cpen221.mp3.staff.Vertex)}.
     */
    @Test
    public void testEdges() {
        AdjacencyListGraph TestGraph = new AdjacencyListGraph();
        List<Vertex> TestList1 = new LinkedList<Vertex>();
        List<Vertex> TestList2 = new LinkedList<Vertex>();
        List<Vertex> EmptyList = new LinkedList<Vertex>();
        
        Vertex testVertex1 = new Vertex("v1");
        Vertex testVertex2 = new Vertex("v2");
        
        TestGraph.addVertex(testVertex1);
        TestList1 = TestGraph.getDownstreamNeighbors(testVertex1);
        TestList2 = TestGraph.getUpstreamNeighbors(testVertex1);
        
        assertEquals("The lists should be the same; empty.", EmptyList, TestList1);
        assertEquals("The lists should be the same; empty.", EmptyList, TestList2);
        
        assertEquals("v1 has no upstream neighbours", EmptyList, TestGraph.getUpstreamNeighbors(testVertex1));
        assertEquals("v1 has no downstream neighbours", EmptyList, TestGraph.getDownstreamNeighbors(testVertex1));
        assertEquals("v2 has no upstream neighbours", EmptyList, TestGraph.getUpstreamNeighbors(testVertex2));
        assertEquals("v2 has no downstream neighbours", EmptyList, TestGraph.getDownstreamNeighbors(testVertex2));
        
        TestGraph.addVertex(testVertex2);
        
        TestGraph.addEdge(testVertex1, testVertex2);
        assertEquals("There should be an edge from 1 to 2.", true, TestGraph.edgeExists(testVertex1, testVertex2));
        assertEquals("There should be no edge from 2 to 1.", false, TestGraph.edgeExists(testVertex2, testVertex1));
        
        List<Vertex> TestList3 = new LinkedList<Vertex>();
        TestList3.add(testVertex2);
        List<Vertex> TestList4 = new LinkedList<Vertex>();
        TestList4.add(testVertex1);
        
        assertEquals("v2 is a downstream neighbour of v1", TestList3, TestGraph.getDownstreamNeighbors(testVertex1));
        assertEquals("v1 is an upstream neighbour of v2", TestList4, TestGraph.getUpstreamNeighbors(testVertex2));
        assertEquals("v1 has no upstream neighbours", EmptyList, TestGraph.getUpstreamNeighbors(testVertex1));
        assertEquals("v2 has no downstream neighbours", EmptyList, TestGraph.getDownstreamNeighbors(testVertex2));
      
        TestGraph.addEdge(testVertex2, testVertex1);
        
        assertEquals("There should be an edge from 2 to 1.", true, TestGraph.edgeExists(testVertex2, testVertex1));
        
        assertEquals("v1 is a downstream neighbour of v2", TestList4, TestGraph.getDownstreamNeighbors(testVertex2));
        assertEquals("v2 is an downstream neighbour of v1", TestList3, TestGraph.getUpstreamNeighbors(testVertex1));
        }
    
    @Test
    public void testGraph(){
        AdjacencyListGraph TestGraph = new AdjacencyListGraph();
        List<Vertex> TestList = new ArrayList<Vertex>();
        List<Vertex> CheckList = new ArrayList<Vertex>();
         
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        
        TestGraph.addVertex(v1);
        TestGraph.addVertex(v2);
        TestGraph.addVertex(v3);
        TestGraph.addVertex(v4);
        TestGraph.addVertex(v5);
        
        TestGraph.addEdge(v1, v4);
        TestGraph.addEdge(v2, v1);
        TestGraph.addEdge(v2, v4);
        TestGraph.addEdge(v4, v1);
        TestGraph.addEdge(v4, v4);
        TestGraph.addEdge(v4, v5);
        
        CheckList.clear();
        CheckList.add(v2);
        CheckList.add(v4);
        TestList = TestGraph.getUpstreamNeighbors(v1);
        assertEquals("The upstream neighbours of v1 are v2, v4", CheckList, TestList);
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getDownstreamNeighbors(v1);
        CheckList.add(v4);
        assertEquals("The downstream neighbours of v1 are v4", CheckList, TestList);
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getUpstreamNeighbors(v2);
        assertEquals("The upstream neighbours of v2 are 0", CheckList, TestList);
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getDownstreamNeighbors(v2);
        CheckList.add(v1);
        CheckList.add(v4);
        assertEquals("The downstream neighbours of v2 are v1, v4", CheckList, TestList); //John fails
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getUpstreamNeighbors(v3);
        assertEquals("The upstream neighbours of v3 are 0", CheckList, TestList);
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getDownstreamNeighbors(v3);
        assertEquals("The downstream neighbours of v3 are 0", CheckList, TestList);
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getUpstreamNeighbors(v4);
        CheckList.add(v1);
        CheckList.add(v2);
        CheckList.add(v4);
        assertEquals("The upstream neighbours of v4 are v1, v2, v4", CheckList, TestList);
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getDownstreamNeighbors(v4);
        CheckList.add(v1);
        CheckList.add(v4);
        CheckList.add(v5);
        assertEquals("The downstream neighbours of v4 are v1, v4, v5", CheckList, TestList); // John fails
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getUpstreamNeighbors(v5);
        CheckList.add(v4);
        assertEquals("The upstream neighbours of v5 are v4", CheckList, TestList);
        TestList.clear();
        
        CheckList.clear();
        TestList = TestGraph.getDownstreamNeighbors(v5);
        assertEquals("The downstream neighbours of v5 are 0", CheckList, TestList); 
        TestList.clear();
    }
}