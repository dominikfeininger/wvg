package uebung_1_2;

public class Graph {
	private Node rootNode;

	//constructor
	public Graph(Node node){
		this.rootNode = node;
	}

	//methods
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
}
