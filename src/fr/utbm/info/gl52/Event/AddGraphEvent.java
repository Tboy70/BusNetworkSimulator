package fr.utbm.info.gl52.Event;

import fr.utbm.info.gl52.Collection.graph.Graph;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIPoint;

public class AddGraphEvent implements IEvent {
	public IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> message;
	public AddGraphEvent(IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>> g)
	{
		this.message = g;
	}
}
