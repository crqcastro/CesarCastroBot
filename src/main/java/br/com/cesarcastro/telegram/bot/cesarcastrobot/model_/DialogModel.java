package br.com.cesarcastro.telegram.bot.cesarcastrobot.model_;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "dialog")
public class DialogModel {

	@Id
	@GeneratedValue(generator = "dialog-sequence")
    @GenericGenerator(
      name = "dialog-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "dialog_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long seq;
	@JsonProperty("update_id")
	private Long id;
	@JsonProperty("message")
	@JsonAlias("edited_message")
	@OneToOne
	private MensagemModel mensagem;
}
