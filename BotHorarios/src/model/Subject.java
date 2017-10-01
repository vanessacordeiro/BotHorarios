package model;

import view.Observer;

public interface Subject {
	public void registrarObserver(Observer observer);
	public void notificaObservers(long chatId, String horarios);
}
