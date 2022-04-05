package br.com.cesarcastro.telegram.bot.cesarcastrobot.model;

import java.math.BigDecimal;

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
@Entity(name = "item")
public class ItemModel {

	@Id
	@Column(name="id")
	@GeneratedValue(generator = "item-sequence")
    @GenericGenerator(
      name = "item-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "item_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Integer id;
	@Column(columnDefinition = "varchar2", length = 60)
	private String shortDescription;
	@Column(columnDefinition = "varchar2", length = 1000)
	private String longDescription;
	@Column(columnDefinition = "number", length = 6, precision = 2)
	private BigDecimal saleValue;
	@Column(columnDefinition = "blob")
	private byte[] image;
	private Boolean active;
	
}
