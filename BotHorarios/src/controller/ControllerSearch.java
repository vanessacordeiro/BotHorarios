package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

public interface ControllerSearch {
	public void pesquisaAula(List<String> p) throws JSONException, IOException;
	public void pesquisaProva(List<String> p) throws JSONException, IOException;
}
