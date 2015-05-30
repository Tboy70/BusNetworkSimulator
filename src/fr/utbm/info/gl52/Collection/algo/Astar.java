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
		closedList = new ArrayList<INode<?>>();
		openList = new ArrayList<INode<?>>();
		cost = new HashMap<INode<?>, Double>();
		path = new HashMap<INode<?>, INode<?>>();

		shortestPath = new LinkedList<INode<?>>();	
	}
	public List<INode<?>> getPath()
	{
		INode<?> temp = end;
		while (!path.isEmpty())
		{
			shortestPath.add(temp);
			temp = path.remove(temp);
		}
		return shortestPath;
	}
	public double run(INode<?> start, INode<?> end)
	{
		this.start = start;
		this.end = end;
		openList.add(start);
		cost.put(start, (double) 0);
		while (!openList.isEmpty())
		{
			Collections.sort(openList, new ArrayComparator());
			current = openList.remove(0);
			if (current == end)
				return score;
			openList.remove(current);
			closedList.add(current);
			for (IEdge<?> edge : graph.getNeighbours(current))
			{
				boolean neighborIsBetter = false;
				INode<?> neighbor;
				if (current == edge.getNodeA())
					neighbor = edge.getNodeB();
				else
					neighbor = edge.getNodeA();
				if (!closedList.contains(neighbor))
				{
					double neighborDistanceFromStart = cost.get(current) + meta.f(current, neighbor);
					if(!openList.contains(neighbor)) {
						openList.add(neighbor);
						neighborIsBetter = true;
						//if neighbor is closer to start it could also be better
					}
					else if(neighborDistanceFromStart < cost.get(current)) {
						neighborIsBetter = true;
					}
					// set neighbors parameters if it is better
					if (neighborIsBetter) {
						path.put(neighbor, current);
						cost.put(neighbor, neighborDistanceFromStart);
					}
				}
			}
		}
		return score;
	}
	public void flush()
	{
		closedList.clear();
		openList.clear();
		shortestPath.clear();
		path.clear();
		score = 0;
	}
	private class ArrayComparator implements Comparator<INode<?>> {
		@Override
		public int compare(INode<?> A, INode<?> B)
		{
			if (meta.f(A, current) > meta.f(B, current))
				return -1;
			else if (meta.f(A, current) < meta.f(B, current))
				return 1;
			else
				return 0;
		}
	}

}
