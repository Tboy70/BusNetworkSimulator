package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Parser.FinishedParsingCallcack;
import fr.utbm.info.gl52.Parser.IParser;
import fr.utbm.info.gl52.Parser.ParserShapeFile;
import fr.utbm.set.io.shape.ESRIPoint;

public class ParseButton extends ButtonComponent implements FinishedParsingCallcack{
	
	private IParser<Node<ESRIPoint>, Edge<String>> parser;
	
	public ParseButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(ActionEvent evt) {
		this.parseDefaultFile();
		// Load
		// 
	}
	
	private void parseDefaultFile(){
		this.parser = new ParserShapeFile<ESRIPoint, String>("resources/Belfort.shp", "resources/test.shx");
		parser.addCallBack(this);
		
    	Thread t = new Thread(parser);
    	t.start();
	}

	@Override
	public void finishedSuccess() {
		System.out.println("coucou");
		IGraph<Node<ESRIPoint>, Edge<String>> g = this.parser.getData();
	}

	@Override
	public void finishedFailed() {
		System.out.println("Probl�me !!!!");
	}

}
