import java.util.Scanner;

class NeuralNetwork {
    private int numLayers;
    private int[] nodesInLayer;
    private double[][] edgeWeights;

    public NeuralNetwork(int numLayers, int[] nodesInLayer) {
        this.numLayers = numLayers;
        this.nodesInLayer = nodesInLayer;
        this.edgeWeights = new double[numLayers - 1][];
        for (int i = 0; i < numLayers - 1; i++) {
            edgeWeights[i] = new double[nodesInLayer[i] * nodesInLayer[i + 1]];
        }
    }

    public void setEdgeWeight(int layer, int fromNode, int toNode, double weight) {
        int index = fromNode * nodesInLayer[layer + 1] + toNode;
        edgeWeights[layer][index] = weight;
    }

    public double getEdgeWeight(int layer, int fromNode, int toNode) {
        int index = fromNode * nodesInLayer[layer + 1] + toNode;
        return edgeWeights[layer][index];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of layers: ");
        int numLayers = scanner.nextInt();

        int[] nodesInLayer = new int[numLayers];
        for (int i = 0; i < numLayers; i++) {
            System.out.print("Enter the number of nodes in layer " + (i + 1) + ": ");
            nodesInLayer[i] = scanner.nextInt();
        }

        NeuralNetwork neuralNetwork = new NeuralNetwork(numLayers, nodesInLayer);

        for (int layer = 0; layer < numLayers - 1; layer++) {
            for (int fromNode = 0; fromNode < nodesInLayer[layer]; fromNode++) {
                for (int toNode = 0; toNode < nodesInLayer[layer + 1]; toNode++) {
                    System.out.print("Enter weight for edge from node " + fromNode +
                            " to node " + toNode + " in layer " + (layer + 1) + ": ");
                    double weight = scanner.nextDouble();
                    neuralNetwork.setEdgeWeight(layer, fromNode, toNode, weight);
                }
            }
        }

        System.out.println("success");
        
    }
}
