package fr.utbm.info.gl52.Middle;

import java.awt.Color;

public class NameGenerator {

	public static String getRandomName()
	{
		String s = "";
		int r = (int) (Math.random()*21);
		
		switch(r)
		{
		case 0:
			s = "Golé";
			break;
		case 1:
			s = "Koup";
			break;
		case 2: 
			s = "Nikk";
			break;
		case 3:
			s = "Bad";
			break;
		case 4:
			s = "Petrol";
			break;
		case 5:
			s = "Teran";
			break;
		case 6:
			s = "Dane";
			break;
		case 7:
			s = "Teplé";
			break;
		case 8:
			s = "In the deep";
			break;
		case 9:
			s = "Deux milles";
			break;
		case 10:
			s = "Specter";
			break;
		case 11:
			s = "Oceros";
			break;
		case 12:
			s = "Monver";
			break;
		case 13:
			s = "Coyote";
			break;
		case 14:
			s = "Tchika";
			break;
		case 15:
			s = "Derue";
			break;
		case 16:
			s = "Buzz";
			break;
		case 17:
			s = "Djaipa";
			break;
		case 18:
			s = "Rincé";
			break;
		case 19:
			s = "Dizzif";
			break;
		case 20:
			s = "Pool";
			break;
		case 21:
			s = "Tassate";
			break;
		}
		return s;
	}
	public static Color getColorName(String s)
	{
		Color c = Color.black;;
		
		switch(s)
		{
		case "Golé":
			c = Color.blue.brighter();
			break;
		case "Koup":
			c = Color.red.darker();
			break;
		case "Nikk":
			c = Color.green.darker();
			break;
		case "Bad":
			c =  Color.cyan;
			break;
		case "Petrol":
			c = Color.gray;
			break;
		case "Teran":
			c = Color.green.brighter();
			break;
		case "Dane":
			c = Color.pink;
			break;
		case "Teplé":
			c = Color.DARK_GRAY;
			break;
		case "In the deep":
			c = Color.pink.brighter();
			break;
		case "Deux milles":
			c = Color.red.darker().darker();
			break;
		case "Specter":
			c = Color.blue.darker();
			break;
		case "Oceros":
			c = Color.orange;
			break;
		case  "Monver":
			c = Color.green.darker().darker();
			break;
		case "Coyote":
			c = Color.orange.darker();
			break;
		case "Tchika":
			c = Color.pink.darker();
			break;
		case "Derue":
			c = Color.yellow.darker();
			break;
		case "Buzz":
			c = Color.orange.brighter();
			break;
		case "Djaipa":
			c = Color.magenta.darker();
			break;
		case "Rincé":
			c = Color.magenta.brighter();
			break;
		case "Dizzif":
			c = Color.pink.brighter().brighter();
			break;
		case "Pool":
			c = Color.orange.darker().darker();
			break;
		case "Tassate":
			c = Color.cyan.darker();
			break;
		}
		return c;
	}
}
