package fr.utbm.info.gl52.Graphics.Buttons;
import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.IGraph;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Graphics.GraphicsLaunch;
import fr.utbm.info.gl52.Parser.FinishedParsingCallcack;
import fr.utbm.info.gl52.Parser.IParser;
import fr.utbm.info.gl52.Parser.ParserDBase;
import fr.utbm.info.gl52.Parser.ParserShapeFile;
import fr.utbm.set.attr.AttributeContainer;
import fr.utbm.set.io.shape.ESRIPoint;

@SuppressWarnings("deprecation")
public class ParseButton extends ButtonComponent implements FinishedParsingCallcack{
	
	private static final long serialVersionUID = 6054097105602086695L;
	private IParser<IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>>> shapeParser;
	private IParser<IGraph<INode<ESRIPoint>,IEdge<AttributeContainer>>> dbaseParser;
	
	public ParseButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
	}

	@Override
	public void action(ActionEvent evt) {
		this.parseDefaultFile();
	}
	
	private void parseDefaultFile(){

		this.dbaseParser = new ParserDBase<>("resources/quartier_polyline.dbf");
		this.shapeParser = new ParserShapeFile<>("resources/quartier_polyline.shp", this.dbaseParser);
		this.shapeParser.addFinishedCallback(this);
		
    	Thread t = new Thread(this.shapeParser);
    	t.start();
    	
    	System.out.println("Go parsing");
	}

	@Override
	public void finishedSuccess() {
		System.out.println("Finished");
		IGraph<INode<ESRIPoint>, IEdge<AttributeContainer>> g = this.shapeParser.getData();
		GraphicsLaunch.addGraph(g);
	}

	@Override
	public void finishedFailed() {
		System.out.println("Probl�me parser !!!!");
	}

}
