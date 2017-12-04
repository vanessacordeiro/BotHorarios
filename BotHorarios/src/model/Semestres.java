package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Semestres {
	private Map<Integer, String[]> semestres = new HashMap<Integer, String[]>();
	
	public void contruindoMapa(){
		ArrayList<String> str = {"1ºa", "1ºb", "primeiroa", "primeirob", "1a", "1b"};
		semestres.put(1, str);
		str = {"2ºa", "2ºb", "segundoa", "segundob", "2a", "2b"};
		semestres.put(1, str);
	}
}
