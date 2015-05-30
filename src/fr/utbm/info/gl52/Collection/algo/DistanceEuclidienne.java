package fr.utbm.info.gl52.Collection.algo;

import fr.utbm.info.gl52.Middle.Connection;
import fr.utbm.info.gl52.Middle.Position;

public class DistanceEuclidienne<D extends Connection<? extends Position>> implements Heuristic<D> {

	@Override
	public double f(D A, D B) {
		return 0;
	}

}
