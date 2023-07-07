package com.movie.movierecommend.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

	private int status;
	private Boolean success;
	private String message;
	private Object data;

	public ResponseDTO(int status, String message, Object data) {
		
		this.message = message;
		this.data = data;
		this.status = status;
	}

}
