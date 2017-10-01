package view;
import java.io.IOException;

import org.json.JSONException;

import model.*;

public class Main {	
	public static void main(String[] args) throws JSONException, IOException{
		Model mo = new Model();
		View view = new View(mo);
		mo.registrarObserver(view);
		view.mensagensRecebidas();
	}
}
