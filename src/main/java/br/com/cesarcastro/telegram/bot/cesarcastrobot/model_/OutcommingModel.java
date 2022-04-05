package br.com.cesarcastro.telegram.bot.cesarcastrobot.model_;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class OutcommingModel {

	private Boolean ok;
	private MensagemModel result;
}
