package br.com.cesarcastro.telegram.bot.cesarcastrobot.model_;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class IncommingModel {

	private Boolean ok;
	private List<DialogModel> result;
	
}
