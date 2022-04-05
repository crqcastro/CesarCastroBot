package br.com.cesarcastro.telegram.bot.cesarcastrobot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Entity(name = "consumer")
public class ConsumerModel {

	@Id
	@Column(name="id")
	@GeneratedValue(generator = "consumer-sequence")
    @GenericGenerator(
      name = "consumer-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "consumer_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Integer id;
	private String cpfCnpj;
	private String razaoSocial;
	@OneToMany
	private List<AddressModel> enderecos;
	@OneToMany
	private List<ContactModel> contatos;
	@OneToMany
	private List<NotesModel> observacoes;
	
}
