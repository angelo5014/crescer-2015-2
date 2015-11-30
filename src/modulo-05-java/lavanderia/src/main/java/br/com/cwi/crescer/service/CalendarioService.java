package br.com.cwi.crescer.service;

import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("static-access")
public class CalendarioService {
	
	private Calendar calendar = Calendar.getInstance();
	
	private int diaDaSemana;
	private int segunda = calendar.MONDAY;;
	private int terca = calendar.WEDNESDAY;
	private int quarta = calendar.WEDNESDAY;
	private int quinta = calendar.THURSDAY;
	private int sexta = calendar.FRIDAY;
	
	public boolean diaEhSegundaAQuarta(Date data){
		
		this.setData(data);
		return diaDaSemana >= segunda && diaDaSemana <= quarta;
	}
	
	public boolean diaEhQuintaOuSexta(Date data){
		
		setData(data);
		return diaDaSemana == quinta || diaDaSemana == sexta;
	}
	
	private void setData(Date data){
		calendar.setTime(data);
		diaDaSemana = calendar.get(calendar.DAY_OF_WEEK);
	}

}