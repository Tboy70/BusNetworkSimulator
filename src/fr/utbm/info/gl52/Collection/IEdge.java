package fr.utbm.info.gl52.Collection;

/**
 * 
 */
public interface IEdge<De, E extends IEdge<De,E>> {
	
	public void setNodes(Node[] ns);
	
	public Node getNodeA();
	public Node getNodeB();
	
	public void setNodeA(Node A);
	public void setNodeB(Node B);
	
	public void setData(De D);
	public De getData();

}