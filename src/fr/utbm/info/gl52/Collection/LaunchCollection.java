package fr.utbm.info.gl52.Collection;

public class LaunchCollection {

	public static void main(String[] args) {
		System.out.println("Création d'un graphe.");
		IGraph<Integer, String, Node<Integer>, Edge<String>> graph = new Graph<Integer, String>();
		
		Node<Integer> node1 = new Node<Integer>(new Integer(1));
		Node<Integer> node2 = new Node<Integer>(new Integer(2));
		Node<Integer> node3 = new Node<Integer>(new Integer(3));
		Node<Integer> node4 = new Node<Integer>(new Integer(4));
		
		Edge<String> edge1 = new Edge<String>("Noeud 1 et 2", node1, node2);
		Edge<String> edge2 = new Edge<String>("Noeud 2 et 3", node2, node3);
		
		graph.addEdge(edge1);
		graph.addEdge(edge2);
		
		for (Edge<String> e : graph)
		{
			System.out.println("Valeur de l'edge:" + e.getData());
			System.out.println("Valeur de Node A:" + e.getNodeA().getData());
			System.out.println("Valeur de Node B:" + e.getNodeB().getData());
			System.out.println("---------------------------------------------");
		}
		
	}

}
