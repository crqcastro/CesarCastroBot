package br.com.cesarcastro.telegram.bot.cesarcastrobot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
@Entity(name = "address")
public class AddressModel {

	@Id
	@Column(name="id")
	@GeneratedValue(generator = "address-sequence")
    @GenericGenerator(
      name = "address-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "address_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Integer id;
	private String place;
	private String complement;
	private String zipCode;
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="city_id", referencedColumnName="id",nullable=false) 
	private City city;
	
	
}
