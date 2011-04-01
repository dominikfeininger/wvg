package uebung_1_2;

public class Main {

	public static void main(String[] args) {
		//create all nodes
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node target = g;
		
		//link all nodes
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
		
		//create graph
		Graph graph = new Graph(a);
		
		//do search
		Search.breadthsearch(graph, target);
		Search.depthsearch(graph, target);
	}

}
