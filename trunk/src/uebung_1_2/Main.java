package uebung_1_2;

import java.util.LinkedList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node target = g;

		//LinkedList<Node> list1 = new LinkedList<Node>();

		a.setChildren(b);
		a.setChildren(c);
		b.setChildren(c);
		b.setChildren(d);
		c.setChildren(d);
		c.setChildren(e);
		d.setChildren(a);
		d.setChildren(f);
		d.setChildren(g);
		e.setChildren(f);
		f.setChildren(g);
		
		//list1=d.getChildren();
		Graph graph = new Graph(a);
		
		//Search.breadthsearch(graph, target);
		Search.depthsearch(graph, target);
		
		/*
		for(int i=0; list1.size()>i; i++){
			System.out.println(list1.get(i).getNodeName());
		}
		*/

		//agenda.printGraph(a);
	}

}
