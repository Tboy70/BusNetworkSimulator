package fr.utbm.info.gl52.Graphics.Buttons;
import java.awt.event.ActionEvent;
import java.io.File;


import javax.swing.JFileChooser;

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
	
	private String loadedRessource[]; // 0 : filename ; 1 : extension

	public ParseButton(String text, int x, int y, int h, int w) {
		super(text, x, y, h, w);
	}

	@Override
	public void action(ActionEvent evt) { 
		
		File file = this.openDialog();
		
		loadedRessource = file.getName().split("[.]");
		
		switch(loadedRessource[1]){
			case "shp":
			case "dbf":
				loadedRessource[0] = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("."));
				
				File shp = new File(loadedRessource[0] + ".shp");
				File dbf = new File(loadedRessource[0] + ".dbf");
				
				if(shp.exists() && dbf.exists()){
					this.dbaseParser = new ParserDBase<>(dbf.getAbsolutePath());
					this.shapeParser = new ParserShapeFile<>(shp.getAbsolutePath(), this.dbaseParser);
					
					this.shapeParser.addFinishedCallback(this);

					Thread t = new Thread(this.shapeParser);
					t.start();

					System.out.println("Go parsing");
				}
				break;
			default:
		}
		
	}

	private File openDialog(){		
		// Open choose window
		JFileChooser fc = new JFileChooser(new File("."));
		
		// get filename without extension
		if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
			return fc.getSelectedFile();
		else
			return null;
	}

	@Override
	public void finishedSuccess() {
		switch(loadedRessource[1]){
			case "shp":
			case "dbf":
				System.out.println("Finished");
				IGraph<INode<ESRIPoint>, IEdge<AttributeContainer>> g = this.shapeParser.getData();
				GraphicsLaunch.addGraph(g);
				break;
			default:
		}
	}

	@Override
	public void finishedFailed() {
		switch(loadedRessource[1]){
		case "shp":
		case "dbf":
			System.out.println("Problème Parser");
			break;
		default:
	}
	}
}
