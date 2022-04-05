package br.com.cesarcastro.telegram.bot.cesarcastrobot.model_;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "mensagem")
public class MensagemModel {

	@Id
	@GeneratedValue(generator = "mensagem-sequence")
    @GenericGenerator(
      name = "mensagem-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "mensagem_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long seq;
	@JsonProperty("message_id")
	private Long id;
	@JsonProperty("from")
	@OneToOne
	private UserModel usuario;
	@JsonProperty("chat")
	@OneToOne
	private ChatModel chat;
	@JsonProperty("date")
	@Column
	private Timestamp data;
	@JsonProperty("text")
	@Column
	private String text;

}