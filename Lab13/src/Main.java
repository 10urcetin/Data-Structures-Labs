
//Dijkstra Algorithm

import java.awt.font.TextHitInfo;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addConnection(nodeB, 10);
        nodeA.addConnection(nodeC, 15);

        nodeB.addConnection(nodeD, 12);
        nodeB.addConnection(nodeF, 15);

        nodeC.addConnection(nodeE, 10);

        nodeD.addConnection(nodeE, 2);
        nodeD.addConnection(nodeF, 1);

        nodeF.addConnection(nodeE, 5);

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

    }
}
class Node{
    private String  name;
    private Map<Node,Integer> connections;
    private int shortestDistance;
    private List<Node> shortestPath;

    public Node(String name) {
        this.name = name;
        this.connections = new HashMap<>();
        this.shortestDistance=Integer.MAX_VALUE;
        this.shortestPath=new ArrayList<>();

    }
    
    public void addConnection(Node node,int distance){
        this.connections.put(node,distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getConnections() {
        return connections;
    }

    public void setConnections(Map<Node, Integer> connections) {
        this.connections = connections;
    }

    public int getShortestDistance() {
        return shortestDistance;
    }

    public void setShortestDistance(int shortestDistance) {
        this.shortestDistance = shortestDistance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
}
class Graph{
    Set<Node> nodes;
    public Graph(){
        this.nodes=new HashSet<>();
    }
    public void addNode(Node node){
        this.nodes.add(node);
    }


    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
class DijkstraAlgorithm{
    
    public static Graph calculateShortestPath(Graph graph,Node source){
        source.setShortestDistance(0);
        Queue<Node> unsettledNodes= new PriorityQueue(
                Comparator.comparingInt(n-> n.getShortestPath));
        unsettledNodes.add(source);
        Set<Node> settleNodes=new HashSet<>();
        
        while (!unsettledNodes.isEmpty()){
            Node currentNode=unsettledNodes.poll();
            for (Map.Entry<Node,Integer> entry : currentNode.getConnections().){
                Node adjNode= entry.getKey();
                int distance= entry.getValue();

                if(settleNodes.contains(adjNode)){
                    //calculate the new nodes
                    unsettledNodes.add(adjNode);
                }
        }
            settleNodes.add(currentNode);
                
       
        
        return graph;
        
    }
}