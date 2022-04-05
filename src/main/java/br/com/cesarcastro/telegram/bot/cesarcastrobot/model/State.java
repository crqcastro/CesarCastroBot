package br.com.cesarcastro.telegram.bot.cesarcastrobot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "state")
public class State {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "state-sequence")
    @GenericGenerator(
      name = "state-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "state_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Integer id;
	@Column(columnDefinition = "varchar2", length = 150)
	private String description;
	@Column(columnDefinition = "varchar2", length = 150)
	private String shortName;
}
