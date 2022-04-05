package br.com.cesarcastro.telegram.bot.cesarcastrobot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.enums.ContactTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "contact")
public class ContactModel {


	@Id
	@Column(name="id")
	@GeneratedValue(generator = "contact-sequence")
    @GenericGenerator(
      name = "contact-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "contact_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Integer id;
	@Enumerated(EnumType.ORDINAL)
	private ContactTypeEnum type;
	@Column(columnDefinition = "varchar2", length = 150)
	private String detail;
}
