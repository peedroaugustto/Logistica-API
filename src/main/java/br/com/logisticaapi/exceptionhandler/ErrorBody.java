package br.com.logisticaapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorBody {

	private Integer status;
	private LocalDateTime dateHour;
	private String title;
	private List<Campo> campos;

	public static class Campo {
		private String name;
		private String message;

		public Campo(String name, String message) {
			this.name = name;
			this.message = message;
		}

		public Campo() {

		}

		public String getName() {
			return name;
		}

		public String getMessage() {
			return message;
		}

	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDateHour() {
		return dateHour;
	}

	public void setDateHour(LocalDateTime dateHour) {
		this.dateHour = dateHour;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

}
