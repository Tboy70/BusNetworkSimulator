package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Collection.graph.Edge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.Node;
import fr.utbm.info.gl52.Parser.FinishedParsingCallcack;
import fr.utbm.info.gl52.Parser.IParser;
import fr.utbm.info.gl52.Parser.ParserShapeFile;
import fr.utbm.set.io.shape.ESRIPoint;

public class ParseButton extends ButtonComponent implements FinishedParsingCallcack{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6054097105602086695L;
	private IParser<Node<ESRIPoint>, Edge<String>> parser;
	
	public ParseButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
	}

	@Override
	public void action(ActionEvent evt) {
		this.parseDefaultFile();
	}
	
	private void parseDefaultFile(){
		this.parser = new ParserShapeFile<ESRIPoint, String>("Belfort.shp", "test.shx");
		this.parser.addCallBack(this);
		
    	Thread t = new Thread(this.parser);
    	t.start();
    	
    	System.out.println("Go parsing");
	}

	@Override
	public void finishedSuccess() {
		IGraph<Node<ESRIPoint>, Edge<String>> g = this.parser.getData();
		System.out.println("coucou");
		System.out.println(g);
	}

	@Override
	public void finishedFailed() {
		System.out.println("Problème !!!!");
	}

}
