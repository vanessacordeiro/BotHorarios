package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

public interface ControllerSearch {
	public void pesquisa(List<String> p) throws JSONException, IOException;
}
