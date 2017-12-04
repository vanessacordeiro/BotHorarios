package view;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import model.*;

public class Main {	
	public static void main(String[] args) throws JSONException, IOException{
		Model mo = new Model();
//		JSONObject json = mo.getJSONProva();
//		System.out.println(json.getJSONArray("semanadeprovas").get(0));
		
		View view = new View(mo);
		mo.registrarObserver(view);
		view.mensagensRecebidas();
	}
}
