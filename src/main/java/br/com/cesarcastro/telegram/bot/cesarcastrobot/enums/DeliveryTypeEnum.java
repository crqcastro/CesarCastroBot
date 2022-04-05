package br.com.cesarcastro.telegram.bot.cesarcastrobot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DeliveryTypeEnum {

	WITHDRAW(0),
	DELIVERY(1);
	
	@Getter
	private Integer code;
}
