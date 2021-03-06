import java.util.LinkedList;

public class VektetNode {

    int n;
    String name;
    private boolean visited;
    LinkedList<VektetEdge> edges;

    VektetNode(int n, String name) {
        this.n = n;
        this.name = name;
        visited = false;
        edges = new LinkedList<>();
    }

    boolean isVisited() {
        return visited;
    }

    void visit() {
        visited = true;
    }

    void unvisit() {
        visited = false;
    }


}