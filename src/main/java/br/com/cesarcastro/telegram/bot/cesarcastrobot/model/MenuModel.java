package br.com.cesarcastro.telegram.bot.cesarcastrobot.model;

import java.util.List;

import javax.persistence.CascadeType;
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
@Entity(name = "menu")
public class MenuModel {

	@Id
	@Column(name="id")
	@GeneratedValue(generator = "menu-sequence")
    @GenericGenerator(
      name = "menu-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "menu_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Integer id;
	@OneToMany(cascade=CascadeType.ALL)
	private List<ItemModel> items;
}
