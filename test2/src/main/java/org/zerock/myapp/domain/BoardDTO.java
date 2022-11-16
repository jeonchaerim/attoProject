package org.zerock.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

@Data
public class BoardDTO {
	private Integer bno;
	private String 	title;
	private String 	content;
	private String 	writer;
	private String  answer;

} // end class
