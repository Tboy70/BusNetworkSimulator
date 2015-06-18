package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Collection.graph.INode;

public class AstarEvent {
	public INode<?> start;
	public INode<?> end;
	
	public AstarEvent(INode<?> A, INode<?> B)
	{
		this.start = A;
		this.end = B;
	}
}
