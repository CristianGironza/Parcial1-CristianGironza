package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.gson.Gson;

public class Mensaje {
	
	private String mensaje;
	private String fecha;
	
	public Mensaje() {
		
	}
	
	public Mensaje(String m) {
		mensaje = m;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		fecha = sdf.format(c.getTime());
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		Gson g = new Gson();
		String out = g.toJson(this);
		return out;
	}
	
	public static Mensaje fromJson(String json) {
		Gson g = new Gson();
		return g.fromJson(json, Mensaje.class);
	}
}
