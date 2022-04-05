package br.com.cesarcastro.telegram.bot.cesarcastrobot.model_;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
@Entity(name = "chat")
public class ChatModel {

	@Id
	@GeneratedValue(generator = "chat-sequence")
    @GenericGenerator(
      name = "chat-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "chat_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Long seq;
	@JsonProperty("id")
	private Long id;
	@JsonProperty("first_name")
	@Column
	private String firstName;
	@JsonProperty("last_name")
	@Column
	private String lastName;
	@JsonProperty("username")
	@Column
	private String userName;
	@JsonProperty("type")
	@Column
	private String type;

}
