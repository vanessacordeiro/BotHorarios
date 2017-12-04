package view;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import controller.ControllerSearch;
import controller.ControllerSearchAula;
import controller.ControllerSearchProva;
import model.Model;

public class View implements Observer{
	private Model model;
	private ControllerSearch controller;
	private List<String> p = new LinkedList<String>();
	boolean comportamento = false;
	boolean first = true;
	
	TelegramBot bot = TelegramBotAdapter.build("427577413:AAEvvPRKw1WF5YfA4Q6kBqmIiapLn5UGY_Q");
	GetUpdatesResponse updatesResponse;
	SendResponse sendResponse;
	BaseResponse baseResponse;
	
	int queuesIndex=0;
	
	public View(Model mo) {
		this.model = mo;
	}
	
	public void setControllerSearch(ControllerSearch cs){
		this.controller = cs;
	}
	
	public void mensagensRecebidas() throws JSONException, IOException{
		while (true){
			
			updatesResponse =  bot.execute(new GetUpdates().limit(100).offset(queuesIndex));
							
			List<Update> updates = updatesResponse.updates();

			for (Update update : updates) {
								
				queuesIndex = update.updateId()+1;
				
				if(this.comportamento==true){
					if (update.message().text().toLowerCase().replace(" ", "").equals("1a") || 
							update.message().text().toLowerCase().replace(" ", "").equals("1ºa") || 
							update.message().text().toLowerCase().replace(" ", "").equals("primeiroa"))
					{
						this.p.add("0");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else if(update.message().text().toLowerCase().replace(" ", "").equals("1b") || 
							update.message().text().toLowerCase().replace(" ", "").equals("1ºb") || 
							update.message().text().toLowerCase().replace(" ", "").equals("primeirob"))
					{
						this.p.add("1");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else if(update.message().text().toLowerCase().replace(" ", "").equals("2a") || 
							update.message().text().toLowerCase().replace(" ", "").equals("2ºa") || 
							update.message().text().toLowerCase().replace(" ", "").equals("segundoa"))
					{
						this.p.add("2");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else if(update.message().text().toLowerCase().replace(" ", "").equals("2b") || 
							update.message().text().toLowerCase().replace(" ", "").equals("2ºb") || 
							update.message().text().toLowerCase().replace(" ", "").equals("segundob"))
					{
						this.p.add("3");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else if(update.message().text().toLowerCase().replace(" ", "").equals("3a") || 
							update.message().text().toLowerCase().replace(" ", "").equals("3ºa") || 
							update.message().text().toLowerCase().replace(" ", "").equals("terceiroa"))
					{
						this.p.add("4");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else if(update.message().text().toLowerCase().replace(" ", "").equals("3b") || 
							update.message().text().toLowerCase().replace(" ", "").equals("3ºb") || 
							update.message().text().toLowerCase().replace(" ", "").equals("terceirob"))
					{
						this.p.add("5");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else if(update.message().text().toLowerCase().replace(" ", "").equals("4") || 
							update.message().text().toLowerCase().replace(" ", "").equals("4º") || 
							update.message().text().toLowerCase().replace(" ", "").equals("quarto"))
					{
						this.p.add("6");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else if(update.message().text().toLowerCase().replace(" ", "").equals("5") || 
							update.message().text().toLowerCase().replace(" ", "").equals("5º") || 
							update.message().text().toLowerCase().replace(" ", "").equals("cinco"))
					{
						this.p.add("7");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else if(update.message().text().toLowerCase().replace(" ", "").equals("6") || 
							update.message().text().toLowerCase().replace(" ", "").equals("6º") || 
							update.message().text().toLowerCase().replace(" ", "").equals("sexto"))
					{
						this.p.add("8");
						this.p.add(update.message().chat().id().toString());
						this.falandoComController(this.p);
					}else{
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"Não entendi o semestre...\n\n"
								+ "<strong>Atenção</strong>: Caso esteja no 1º, 2º ou 3º semetre de ADS, por favor, coloque o semetre seguido da turma!!!\n\n"
								+ "<b>Ex.:</b> '1 a' ou '1º a' ou 'primeiro a'\n\n"
								+ "Digite novamente!").parseMode(ParseMode.HTML));
					}
				}else if(update.message().text().toLowerCase().replace(" ", "").equals("horariodeaula")|| 
						update.message().text().toLowerCase().replace(" ", "").equals("horáriodeaula")){
					this.p.add("ADS_manha");
					setControllerSearch(new ControllerSearchAula(this.model, this));
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"Qual semestre você está em ADS?"));
					this.comportamento = true;
				}else if(update.message().text().toLowerCase().replace(" ", "").equals("horariodasemana")|| 
					update.message().text().toLowerCase().replace(" ", "").equals("horáriodasemana")){
					System.out.print("foi");
					this.p.add("semanadeprovas");
					setControllerSearch(new ControllerSearchProva(this.model, this));
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"Qual semestre você está em ADS?"));
					this.comportamento = true;	
				}else{
					if(this.first==true){
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"<b>Bem-vindo aluno de ADS!</b>\n"
								+ "Posso informar o seu horário do dia!\n"
								+ "Quer saber o horário de aula ou horário da semana de provas?").parseMode(ParseMode.HTML));
						System.out.println("Mensagem Enviada?" +sendResponse.isOk());
						this.first = false;
					}else{
						sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"Não entendi...\nDigite novamente, por favor!"));
					}
				}
					
				System.out.println("Recebendo mensagem:"+ update.message().text());
			}
		}
	}
	
	public void falandoComController(List<String> p) throws JSONException, IOException{
			this.controller.pesquisa(p);
		
	}
	
	public void update(long chatId, String horarios){
		sendResponse = bot.execute(new SendMessage(chatId, horarios).parseMode(ParseMode.HTML));
		this.comportamento = false;
		this.first = true;
		this.p = new LinkedList<String>();
	}
	
	public void avisoEnviando(List<String> p){
		baseResponse = bot.execute(new SendChatAction(p.get(2), ChatAction.typing.name()));
		System.out.println("Resposta de Chat Action Enviada?" + baseResponse.isOk());
	}
}
