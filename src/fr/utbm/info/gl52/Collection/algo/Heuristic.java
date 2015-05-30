package fr.utbm.info.gl52.Collection.algo;

import fr.utbm.info.gl52.Collection.graph.INode;

public interface Heuristic<D extends INode<?>> {
	public double f(D a, D b);
}
