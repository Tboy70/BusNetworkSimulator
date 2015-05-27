package fr.utbm.info.gl52.Graphics.Buttons;

import java.awt.event.ActionEvent;

import fr.utbm.info.gl52.Collection.graph.IEdge;
import fr.utbm.info.gl52.Collection.graph.INode;
import fr.utbm.info.gl52.Parser.IParser;
import fr.utbm.info.gl52.Parser.ParserShapeFile;

public class ParseButton extends ButtonComponent {
	
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
		IParser<INode<Float>, IEdge<Integer>> parser = new ParserShapeFile<Float, Integer>("resources/Belfort.shp", "resources/test.shx");
	}

}
