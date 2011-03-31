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
		// test if root is target
		if (graph.getRootNode().getLabel().equals(target.getLabel())) {
			System.out.println(currentNode.getLabel());
		}
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
				System.out.println(currentNode.getLabel());
				System.out.println("Node found");
			} else {
				// not found -> add next node
				for (int i = 0; i < currentNode.getChildren().size(); i++) {
					list.addLast(currentNode.getChildren().get(i));
				}
			}
		} while (currentNode != target);
	}

	/**
	 * this method implements the depththsearch
	 */
	public static void depthsearch(Graph graph, Node target) {
		int g = 0;
		// remove all old nodes
		list.removeAll(list);
		list.addLast(graph.getRootNode());
		Node currentNode = graph.getRootNode();
		ramlist.addLast(currentNode);
		// test if root node is target
		if (graph.getRootNode().getLabel().equals(target.getLabel())) {
			System.out.println(currentNode.getLabel());
		}
		do {
			for (int i = 0; i < list.size(); i++) {
				// print all nodes in list
				System.out.print(list.get(i).getLabel());
			}
			currentNode = list.removeFirst();
			// add visited node to remember list
			ramlist.addLast(currentNode);
			System.out.println();
			if (currentNode.getLabel().equals(target.getLabel())) {
				System.out.println(currentNode.getLabel());
				System.out.println("Node found");
			} else {
				for (int i = 0; i < currentNode.getChildren().size(); i++) {
					// check the whole ramlist
					for (int j = 0; j < ramlist.size(); j++) {
						// if there is a already visited node in ramlist
						if (currentNode.getLabel().equals(ramlist.get(j))) {
							currentNode = list.removeFirst();
							// else do it like usual
						} else {
							list.addFirst(currentNode.getChildren().get(
									currentNode.getChildren().size() - 1 - i));
						}
					}
				}
			}
			// terminate early
			// if (g == 20) {
			// return;
			// }
			// g++;
		} while (currentNode != target);
	}
}
