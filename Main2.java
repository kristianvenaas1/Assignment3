public class Main2 {
    public static void main(String[] args) {
        VektetGraf VektetGraf = new VektetGraf(true);
        VektetNode A = new VektetNode(0, "A");
        VektetNode B = new VektetNode(1, "B");
        VektetNode C = new VektetNode(2, "C");
        VektetNode D = new VektetNode(3, "D");
        VektetNode E = new VektetNode(4, "E");
        VektetNode F = new VektetNode(5, "F");

        VektetGraf.addEdge(A, B, 10);
        VektetGraf.addEdge(B, C, 17);
        VektetGraf.addEdge(C, D, 35);
        VektetGraf.addEdge(D, E, 17);
        VektetGraf.addEdge(E, F, 35);


        VektetGraf.DijkstraShortestPath(A, F);
    }
}
