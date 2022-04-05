package br.com.cesarcastro.telegram.bot.cesarcastrobot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ContactTypeEnum {

	EMAIL(0),
	PHONE(1);
	
	@Getter
	private Integer code;
	
}
