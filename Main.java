public class Main {
    public static void main(String[] args) {
        VektetGraf VektetGraf = new VektetGraf(true);
        VektetNode A = new VektetNode(0, "A");
        VektetNode B = new VektetNode(1, "B");
        VektetNode C = new VektetNode(2, "C");
        VektetNode D = new VektetNode(3, "D");
        VektetNode E = new VektetNode(4, "E");
        VektetNode F = new VektetNode(5, "F");

        VektetGraf.addEdge(A, B, 10);
        VektetGraf.addEdge(A, C, 5);
        VektetGraf.addEdge(A, E, 3);
        VektetGraf.addEdge(A, F, 12);
        VektetGraf.addEdge(B, C, 17);
        VektetGraf.addEdge(B, D, 9);
        VektetGraf.addEdge(B, E, 17);
        VektetGraf.addEdge(B, F, 12);
        VektetGraf.addEdge(C, D, 35);
        VektetGraf.addEdge(C, E, 3);
        VektetGraf.addEdge(C, F, 12);
        VektetGraf.addEdge(D, F, 12);
        VektetGraf.addEdge(E, F, 12);

        VektetGraf.DijkstraShortestPath(A, D);

    }
}