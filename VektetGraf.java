import java.util.*;

public class VektetGraf {
    private Set<VektetNode> nodes;
    private boolean directed;

    VektetGraf(boolean directed) {
        this.directed = directed;
        nodes = new HashSet<>();
    }

    public void addNode(VektetNode... n) {

        nodes.addAll(Arrays.asList(n));
    }
    public void addEdge(VektetNode source, VektetNode destination, double weight) {

        nodes.add(source);
        nodes.add(destination);

        addEdgeHelper(source, destination, weight);

        if (!directed && source != destination) {
            addEdgeHelper(destination, source, weight);
        }
    }

    private void addEdgeHelper(VektetNode a, VektetNode b, double weight) {

        for (VektetEdge edge : a.edges) {
            if (edge.source == a && edge.destination == b) {

                edge.weight = weight;
                return;
            }
        }

        a.edges.add(new VektetEdge(a, b, weight));
    }

    public void printEdges() {
        for (VektetNode node : nodes) {
            LinkedList<VektetEdge> edges = node.edges;

            if (edges.isEmpty()) {
                System.out.println("Node " + node.name + " har ingen edges.");
                continue;
            }
            System.out.print("Node " + node.name + " har edges til: ");

            for (VektetEdge edge : edges) {
                System.out.print(edge.destination.name + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }
    public boolean hasEdge(VektetNode source, VektetNode destination) {
        LinkedList<VektetEdge> edges = source.edges;
        for (VektetEdge edge : edges) {

            if (edge.destination == destination) {
                return true;
            }
        }
        return false;
    }


    public void DijkstraShortestPath(VektetNode start, VektetNode end) {

        HashMap<VektetNode, VektetNode> changedAt = new HashMap<>();
        changedAt.put(start, null);

        HashMap<VektetNode, Double> shortestPathMap = new HashMap<>();

        for (VektetNode node : nodes) {
            if (node == start)
                shortestPathMap.put(start, 0.0);
            else shortestPathMap.put(node, Double.POSITIVE_INFINITY);
        }

        for (VektetEdge edge : start.edges) {
            shortestPathMap.put(edge.destination, edge.weight);
            changedAt.put(edge.destination, start);
        }

        start.visit();

        while (true) {
            VektetNode currentNode = closestReachableUnvisited(shortestPathMap);

            if (currentNode == null) {
                System.out.println("Det er ikke en vei mellom " + start.name + " and " + end.name);
                return;
            }

            if (currentNode == end) {
                System.out.println("Veien med minste kostnad "
                        + start.name + " og " + end.name + " er:");

                VektetNode child = end;

                String path = end.name;
                while (true) {
                    VektetNode parent = changedAt.get(child);
                    if (parent == null) {
                        break;
                    }

                    path = parent.name + " " + path;
                    child = parent;
                }
                System.out.println(path);
                System.out.println("Den korteste veien koster: " + shortestPathMap.get(end));
                return;
            }
            currentNode.visit();

            for (VektetEdge edge : currentNode.edges) {
                if (edge.destination.isVisited())
                    continue;

                if (shortestPathMap.get(currentNode)
                        + edge.weight
                        < shortestPathMap.get(edge.destination)) {
                    shortestPathMap.put(edge.destination,
                            shortestPathMap.get(currentNode) + edge.weight);
                    changedAt.put(edge.destination, currentNode);
                }
            }
        }
    }
    private VektetNode closestReachableUnvisited(HashMap<VektetNode, Double> shortestPathMap) {

        double shortestDistance = Double.POSITIVE_INFINITY;
        VektetNode closestReachableNode = null;
        for (VektetNode node : nodes) {
            if (node.isVisited())
                continue;

            double currentDistance = shortestPathMap.get(node);
            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;

            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                closestReachableNode = node;
            }
        }
        return closestReachableNode;
    }

}

