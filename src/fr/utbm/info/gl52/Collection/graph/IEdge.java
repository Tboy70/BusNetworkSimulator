package fr.utbm.info.gl52.Collection.graph;

/**
 * 
 */
public interface IEdge<De> {
	
	public void setNodes(INode<?>[] ns);
	
	public INode<?> getNodeA();
	public INode<?> getNodeB();
	
	public void setNodeA(INode<?> A);
	public void setNodeB(INode<?> B);
	
	public void setData(De D);
	public De getData();
    @Override
    public boolean equals(Object object);

}