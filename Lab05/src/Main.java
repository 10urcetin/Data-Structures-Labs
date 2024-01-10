import java.util.*;

/*

-Topic: Trees
-nonlinear
-We will implement general tree
-Represent programming language is a class node
-Node class keeps a value
-List<Node> childrenNode
-Each tree consist of one or more
-Breadthfirst(bfs) kademe kademe inmek treede   1 2 5 3 4 with queues
-Depthfirst ise (dfs) numarasına göre kademeye bakmadan 1,2,3,4,5

1-- 2-5 --3--4 (1in altında 2 5 ve 2nin altında 3 ve 3ün altında 4
*/
public class Main {
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n5=new Node(5);
        n1.childrenNodes.add(n2);
        n2.childrenNodes.add(n5);

        Node n3=new Node(3);
        n2.childrenNodes.add(n5);

        Node n4=new Node(4);
        n3.childrenNodes.add(n4);


        Tree tree=new Tree(0);
        tree.root=n1;

        tree.bfs();
        tree.dfs(tree.root);

    }
    static class Node{
        int value;
        List<Node> childrenNodes;
       // private Node parent;//optional

        public Node(int value) {
            this.value = value;
            this.childrenNodes = new ArrayList<>();

        }
    }
    static class Tree{
        Node root;

        public Tree(int value) {
            root = new Node(value);
        }
        public void bfs(){
            Queue<Node> treeQueue= new LinkedList<Node>();
            treeQueue.add(root);


            while (!treeQueue.isEmpty()){
                Node current=treeQueue.poll();
                /*
                 Returns: This method returns the element at the front of the container or the head of the Queue.
                 It returns null when the Queue is empty.
                 */
                //peek-poll farkına bak
                System.out.println(current.value);
                for (Node child : current.childrenNodes){

                    treeQueue.add(child);
                }

            }

        }
        public void dfs(Node n){
            //we will use recursion method
            if (n == null)
                return;
            System.out.println(n.value);

            for (Node child: n.childrenNodes){
                dfs(child);//recursion
            }
        }
    }
}