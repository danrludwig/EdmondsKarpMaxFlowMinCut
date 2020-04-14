import java.util.ArrayList;
import java.util.LinkedList;

public class MaxFlow {

    public static void main(String[] args) {
        for (int i=1; i <= 5; i++) {
            int flowRate = 0;
            String inputFile = "demands" + i + ".txt";
            Graph graph = new Graph();
            graph.makeGraph(inputFile);
            System.out.println("OUTPUT:\n" + inputFile + "\n\nMAX FLOW:");
            ArrayList<Integer> shortestPathIndexes = breadthSearchIndexes(graph, graph.G[0]);
            flowRate += fixCapacity(graph, shortestPathIndexes);
            ArrayList<Integer> inOrderIndexes = new ArrayList<>();
            for (int j=shortestPathIndexes.size(); j > 0; j--) {
                inOrderIndexes.add(shortestPathIndexes.get(j - 1));
            }
            System.out.println("Found flow " + flowRate + ": " + inOrderIndexes.toString());
            boolean maxFlowReached = false;
            while (!maxFlowReached) {
                graph.resetVisits();
                shortestPathIndexes = breadthSearchIndexes(graph, graph.G[0]);
                if (shortestPathIndexes.size() == 0) {
                    break;
                }
                int currentFlow = fixCapacity(graph, shortestPathIndexes);
                flowRate += currentFlow;
                inOrderIndexes.clear();
                for (int j=shortestPathIndexes.size(); j > 0; j--) {
                    inOrderIndexes.add(shortestPathIndexes.get(j - 1));
                }
                System.out.println("Found flow " + currentFlow + ": " + inOrderIndexes.toString());
            }
            System.out.println("Produced " + flowRate + "\n");

            for (int j=0; j < graph.vertexCt; j++) {
                for (int g=0; g < graph.G[j].succ.size(); g++) {
                    int startIndex = graph.G[j].nodeID;
                    int finishIndex = graph.G[j].succ.get(g).to;
                    int transportAmount = graph.G[j].succ.get(g).transported;
                    System.out.println("Edge (" + startIndex + "," + finishIndex + ") transports " + transportAmount + " cases");
                }
            }
            System.out.println();
            graph.resetVisits();
            minCut(graph);
            System.out.println("-------------------------------\n");
        }
    }

    // The methods minCut() and breadthSearchIndexes() are pretty similar with how they move through the graph
    // they just are looking for different things.
    public static void minCut(Graph graph) {
        System.out.println("MIN CUT:");

        GraphNode node = graph.G[0];

        ArrayList<Integer> indexes = new ArrayList<>();
        if (node == null) {
            return;
        }

        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        GraphNode lastNode = node;
        while (!queue.isEmpty() && lastNode.nodeID != graph.G[graph.G.length - 1].nodeID) {
            GraphNode firstNode = queue.removeFirst();
            lastNode = firstNode;
            if (firstNode.isVisited()) {
                continue;
            }
            firstNode.visit();

            LinkedList<GraphNode> neighbors = new LinkedList<>();

            for (int i=0; i < firstNode.succ.size(); i++) {
                if (firstNode.succ.get(i).capacity != 0) {
                    int index = firstNode.succ.get(i).to;
                    if (firstNode.succ.get(i).capacity != 0) {
                        neighbors.add(graph.G[index]);
                        if (!graph.G[index].isVisited()) {
                            graph.G[index].parent = firstNode.nodeID;
                        }
                    }
                } else {
                    System.out.println("Edge (" + firstNode.succ.get(i).from + "," + firstNode.succ.get(i).to +") " +
                            "transports " + firstNode.succ.get(i).transported + " cases");
                }
            }

            if (neighbors.size() == 0) {
                continue;
            }

            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                }
            }
        }
        if (lastNode.nodeID == graph.G[graph.G.length - 1].nodeID) {
            indexes.add(lastNode.nodeID);
            while (lastNode.parent >= 0) {
                indexes.add(lastNode.parent);
                lastNode = graph.G[lastNode.parent];
            }
        }

    }

    public static int fixCapacity(Graph graph, ArrayList<Integer> path) {
        int minCapacity = 0;
        for (int i=path.size() - 1; i > 0; i--) {
            GraphNode currentNode = (graph.G[path.get(i)]);
            for (int j=0; j < currentNode.succ.size(); j++) {
                if (currentNode.succ.get(j).to == path.get(i-1)) {
                    int cap = currentNode.succ.get(j).capacity;
                    if (minCapacity == 0) {
                        minCapacity = cap;
                    } else if (cap < minCapacity) {
                        minCapacity = cap;
                    }
                }
            }
        }
        for (int i=path.size() - 1; i > 0; i--) {
            GraphNode currentNode = (graph.G[path.get(i)]);
            for (int j=0; j < currentNode.succ.size(); j++) {
                if (currentNode.succ.get(j).to == path.get(i-1)) {
                    currentNode.succ.get(j).capacity -= minCapacity;
                    currentNode.succ.get(j).transported += minCapacity;
                }
            }
        }
        return minCapacity;
    }

    public static ArrayList<Integer> breadthSearchIndexes(Graph graph, GraphNode node) {
        ArrayList<Integer> indexes = new ArrayList<>();
       if (node == null) {
           return indexes;
       }

       LinkedList<GraphNode> queue = new LinkedList<>();
       queue.add(node);
       GraphNode lastNode = node;
       while (!queue.isEmpty() && lastNode.nodeID != graph.G[graph.G.length - 1].nodeID) {
           GraphNode firstNode = queue.removeFirst();
           lastNode = firstNode;
           if (firstNode.isVisited()) {
               continue;
           }
           firstNode.visit();

           LinkedList<GraphNode> neighbors = new LinkedList<>();

           for (int i=0; i < firstNode.succ.size(); i++) {
               if (firstNode.succ.get(i).capacity != 0) {
                   int index = firstNode.succ.get(i).to;
                   neighbors.add(graph.G[index]);
                   if(!graph.G[index].isVisited()) {
                       graph.G[index].parent = firstNode.nodeID;
                   }
               }
           }

           if (neighbors.size() == 0) {
               continue;
           }

           for (GraphNode neighbor : neighbors) {
               if (!neighbor.isVisited()) {
                   queue.add(neighbor);
               }
           }
       }
       if (lastNode.nodeID == graph.G[graph.G.length - 1].nodeID) {
           indexes.add(lastNode.nodeID);
           while (lastNode.parent >= 0) {
               indexes.add(lastNode.parent);
               lastNode = graph.G[lastNode.parent];
           }
       }
       return indexes;
    }
}
