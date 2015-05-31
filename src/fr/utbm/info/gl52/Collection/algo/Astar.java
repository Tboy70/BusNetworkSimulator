package fr.utbm.info.gl52.Collection.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;

public class Astar {

	private IGraph<?, ?> graph;
	private Heuristic<INode<?> > meta;

	private List<INode<?>> closedList;
	private List<INode<?>> openList;
	private List<INode<?>> shortestPath;
	
	private Map<INode<?>, Double> cost;
	private Map<INode<?>, INode<?> > path;

	private INode<?> start;
	private INode<?> current;
	private INode<?> end;
	
	private double score;

	public Astar(IGraph<?, ?> g, Heuristic<INode<?>> meta)
	{
		this.graph = g;
		this.meta = meta;
		this.closedList = new ArrayList<>();
		this.openList = new ArrayList<>();
		this.cost = new HashMap<>();
		this.path = new HashMap<>();

		this.shortestPath = new LinkedList<>();	
	}
	public List<INode<?>> getPath()
	{
		INode<?> temp = this.end;
		while (!this.path.isEmpty())
		{
			this.shortestPath.add(temp);
			temp = this.path.remove(temp);
		}
		return this.shortestPath;
	}
	public double run(INode<?> start, INode<?> end)
	{
		this.start = start;
		this.end = end;
		this.openList.add(start);
		this.cost.put(start, (double) 0);
		while (!this.openList.isEmpty())
		{
			Collections.sort(this.openList, new ArrayComparator());
			this.current = this.openList.remove(0);
			if (this.current == end)
				return this.score;
			this.openList.remove(this.current);
			this.closedList.add(this.current);
			for (IEdge<?> edge : this.graph.getNeighbours(this.current))
			{
				boolean neighborIsBetter = false;
				INode<?> neighbor;
				if (this.current == edge.getNodeA())
					neighbor = edge.getNodeB();
				else
					neighbor = edge.getNodeA();
				if (!this.closedList.contains(neighbor))
				{
					double neighborDistanceFromStart = this.cost.get(this.current) + this.meta.f(this.current, neighbor);
					if(!this.openList.contains(neighbor)) {
						this.openList.add(neighbor);
						neighborIsBetter = true;
						//if neighbor is closer to start it could also be better
					}
					else if(neighborDistanceFromStart < this.cost.get(this.current)) {
						neighborIsBetter = true;
					}
					// set neighbors parameters if it is better
					if (neighborIsBetter) {
						this.path.put(neighbor, this.current);
						this.cost.put(neighbor, neighborDistanceFromStart);
					}
				}
			}
		}
		return this.score;
	}
	public void flush()
	{
		this.closedList.clear();
		this.openList.clear();
		this.shortestPath.clear();
		this.path.clear();
		this.score = 0;
	}
	private class ArrayComparator implements Comparator<INode<?>> {
		@Override
		public int compare(INode<?> A, INode<?> B)
		{
			if (Astar.this.meta.f(A, Astar.this.current) > Astar.this.meta.f(B, Astar.this.current))
				return -1;
			else if (Astar.this.meta.f(A, Astar.this.current) < Astar.this.meta.f(B, Astar.this.current))
				return 1;
			else
				return 0;
		}
	}

}
