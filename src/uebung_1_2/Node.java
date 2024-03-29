package uebung_1_2;

import java.util.LinkedList;

public class Node {
	//saves all children in list
	private LinkedList<Node> children;
	//save the name of node
	private String label;

	//constructor
	public Node(String name){
		this.label = name;
		this.children=new LinkedList<Node>();
	}

	//methods
	public void setChildren(Node childNode){
		this.children.add(childNode);
	}
	public LinkedList<Node> getChildren(){
		return this.children;
	}
	public void setLabel(String name){
		this.label = name;
	}
	public String getLabel(){
		return this.label;
	}
}
