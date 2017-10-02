package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import view.Observer;

public class Model implements Subject{
	private Materias m = new Materias();
	private List<Observer> observers = new LinkedList<Observer>();
	private JSONObject json;
	String h_ads_manha[] = {"07:10 ~ 08:00", "08:00 ~ 08:50", "09:15 ~ 10:05", "10:05 ~ 10:55", "10:55 ~ 11:45", "11:45 ~ 12:35"};
	
	public void registrarObserver(Observer observer){
		observers.add(observer);
	}
	
	public void notificaObservers(long chatId, String horarios){
		for(Observer observer:observers){
			observer.update(chatId, horarios);
		}
	}
	
	public void lendo(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		    sb.append((char) cp);
	    }
		    this.json = new JSONObject(sb.toString());
	    }finally{
	    	is.close();
	    }
	}
	
	public JSONObject getJSON(Object curso) throws JSONException, IOException{
		if(curso.equals("ADS_manha"))
			lendo("https://api.myjson.com/bins/1g1pd5");
		return json;
	}
	
	public String diaDaSemana(){
		Date d = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		String nome = "";
		int dia = c.get(c.DAY_OF_WEEK);
		switch(dia){
			case Calendar.SUNDAY: nome = "Domingo";break;
			case Calendar.MONDAY: nome = "Segunda-feira";break;
			case Calendar.TUESDAY: nome = "Terça-feira";break;
			case Calendar.WEDNESDAY: nome = "Quarta-feira";break;
			case Calendar.THURSDAY: nome = "Quinta-feira";break;
			case Calendar.FRIDAY: nome = "Sexta-feira";break;
			case Calendar.SATURDAY: nome = "Sábado";break;
		}
		return nome;
	}
	
	public void pesquisaDia(List<String> p)  throws JSONException, IOException{
		JSONObject json = this.getJSON(p.get(0));
		m.construindoMapa();
		int n = 0;
		
		String mensagem = null;
		//if("Segunda-feira"=="Segunda-feira"){
		if(this.diaDaSemana()=="Segunda-feira"){
			mensagem = "<b>" + this.diaDaSemana() + " </b>";
			for(Object mat:json.getJSONArray(p.get(0).toString()).getJSONObject(Integer.parseInt(p.get(1))).getJSONArray("seg")){
				mensagem = mensagem + "\n <b>" + h_ads_manha[n] + "</b>: " + m.getMateria(mat);
				n++;
			}
		}else if(this.diaDaSemana()=="Terça-feira"){
			mensagem = this.diaDaSemana();
			for(Object dia:json.getJSONArray(p.get(0).toString()).getJSONObject(Integer.parseInt(p.get(1))).getJSONArray("ter")){
				mensagem = mensagem + "\n" + dia;
			}
		}else if(this.diaDaSemana()=="Quarta-feira"){
			mensagem = this.diaDaSemana();
			for(Object dia:json.getJSONArray(p.get(0).toString()).getJSONObject(Integer.parseInt(p.get(1))).getJSONArray("qua")){
				mensagem = mensagem + "\n" + dia;
			}
		}else if(this.diaDaSemana()=="Quinta-feira"){
			mensagem = this.diaDaSemana();
			for(Object dia:json.getJSONArray(p.get(0).toString()).getJSONObject(Integer.parseInt(p.get(1))).getJSONArray("qui")){
				mensagem = mensagem + "\n" + dia;
			}
		}else if(this.diaDaSemana()=="Sexta-feira"){
			mensagem = this.diaDaSemana();
			for(Object dia:json.getJSONArray(p.get(0).toString()).getJSONObject(Integer.parseInt(p.get(1))).getJSONArray("sex")){
				mensagem = mensagem + "\n" + dia;
			}
		}else if(this.diaDaSemana()=="Sábado"){
			mensagem = "Aula sábado?\n<b>Não tem!!!</b>";
		}else if(this.diaDaSemana()=="Domingo"){
			mensagem = "Aula domingo?\n<b>Não tem!!!</b>";
		}
		
		if(mensagem != null){
			this.notificaObservers((Long.parseLong(p.get(2).toString())), mensagem);
		} 
		/*else {
			this.notificaObservers((Long.parseLong(p.get(2).toString())), "Not found");
		}*/
	}
}
