package model;

public class Articles {

	private String titulo, autor;
	private long ISSN;
	private int año;
	private boolean disponivilidad;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getISSN() {
		return ISSN;
	}
	public void setISSN(long iSSN) {
		this.ISSN = iSSN;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public boolean isDisponivilidad() {
		return disponivilidad;
	}
	public void setDisponivilidad(boolean disponivilidad) {
		this.disponivilidad = disponivilidad;
	}
	
	public Articles(String titulo, String autor, long iSSN, int año, boolean disponivilidad) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISSN = iSSN;
		this.año = año;
		this.disponivilidad = disponivilidad;
	}
	
	@Override
	public String toString() {
		return "Articles [titulo=" + titulo + ", autor=" + autor + ", ISSN=" + ISSN + ", año=" + año
				+ ", disponivilidad=" + disponivilidad + "]";
	}
}