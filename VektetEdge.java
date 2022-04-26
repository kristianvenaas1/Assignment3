public class VektetEdge implements Comparable<VektetEdge> {

    VektetNode source;
    VektetNode destination;
    double weight;

    VektetEdge(VektetNode s, VektetNode d, double w) {

        source = s;
        destination = d;
        weight = w;
    }
    public String toString() {
        return String.format("(%s -> %s, %f)", source.name, destination.name, weight);
    }

    public int compareTo(VektetEdge otherEdge) {

        if (this.weight > otherEdge.weight) {
            return 1;
        }
        else return -1;
    }
}