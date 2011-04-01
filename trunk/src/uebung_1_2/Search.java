package uebung_1_2;

import java.util.LinkedList;

public class Search {
	private static LinkedList<Node> list = new LinkedList<Node>();
	// list to save already visited nodes
	private static LinkedList<Node> ramlist = new LinkedList<Node>();

	// methods
	/**
	 * this method implements the breadthsearch
	 */
	public static void breadthsearch(Graph graph, Node target) {
		// remove all old nodes
		list.removeAll(list);
		// add root
		list.addFirst(graph.getRootNode());
		Node currentNode = graph.getRootNode();
		do {
			// print node label
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).getLabel());
			}
			System.out.println();
			// expand first node
			currentNode = list.removeFirst();
			// test if node found
			if (currentNode.getLabel().equals(target.getLabel())) {
				System.out.println("Node found:");
				System.out.println(currentNode.getLabel());
			} else {
				// not found -> add next node
				for (int i = 0; i < currentNode.getChildren().size(); i++) {
					//sepecific to breathsearch
					list.addLast(currentNode.getChildren().get(i));
				}
			}
		} while (currentNode != target);
	}

	/**
	 * this method implements the depththsearch
	 */
	public static void depthsearch(Graph graph, Node target) {
		// remove all old nodes
		list.removeAll(list);
		list.addLast(graph.getRootNode());
		Node currentNode;
		// test if root node is target
		do {
			// print loop
			for (int i = 0; i < list.size(); i++) {
				// print all nodes in list
				System.out.print(list.get(i).getLabel());
			}
			currentNode = list.removeFirst();
			System.out.println();
			if (currentNode.getLabel().equals(target.getLabel())) {
				System.out.println("Node found:");
				System.out.println(currentNode.getLabel());
			} else {
				// check the whole ramlist
				// if there is a already visited node in ramlist
				if (!ramlist.contains(currentNode)) {
					// else do it like usual
					for (int i = 0; i < currentNode.getChildren().size(); i++) {
						//specific to depthsearch
						list.addFirst(currentNode.getChildren().get(
								currentNode.getChildren().size() - 1 - i));
					}
				}
			}
			// add visited node to remember list
			ramlist.addLast(currentNode);
		} while (currentNode != target);
	}
}
