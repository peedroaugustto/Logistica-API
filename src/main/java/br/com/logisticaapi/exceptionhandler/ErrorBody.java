package br.com.logisticaapi.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorBody {

	private Integer status;
	private OffsetDateTime dateHour;
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

	public OffsetDateTime getDateHour() {
		return dateHour;
	}

	public void setDateHour(OffsetDateTime dateHour) {
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
