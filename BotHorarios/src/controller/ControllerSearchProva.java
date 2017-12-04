package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import model.Model;
import view.View;

public class ControllerSearchProva implements ControllerSearch{
	private Model mo;
	private View vw;
	
	public ControllerSearchProva(Model mo, View vw){
		this.mo = mo;
		this.vw = vw;
	}
	
	
	public void pesquisa(List<String> p) throws JSONException, IOException{
		vw.avisoEnviando(p);
		mo.pesquisaSemana(p);
	}
}
