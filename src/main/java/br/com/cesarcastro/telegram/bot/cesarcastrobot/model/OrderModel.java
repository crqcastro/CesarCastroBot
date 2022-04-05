package br.com.cesarcastro.telegram.bot.cesarcastrobot.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.enums.DeliveryTypeEnum;
import br.com.cesarcastro.telegram.bot.cesarcastrobot.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "order")
public class OrderModel {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "order-sequence")
    @GenericGenerator(
      name = "order-sequence",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "order_sequnce"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private Integer id;
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="consumer_id", referencedColumnName="id",nullable=false) 
	private ConsumerModel consumer;
	@Enumerated(EnumType.ORDINAL)
	private DeliveryTypeEnum deliveryType;
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="address_id", referencedColumnName="id",nullable=false) 
	private AddressModel address;
	@OneToMany(cascade=CascadeType.ALL) 
	private List<ItemModel> itens;
	private BigDecimal amount;
	private OffsetDateTime dateTime;
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	public BigDecimal amount() {
		this.amount = this.getItens().stream()
				.map(i -> i.getSaleValue())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		return this.amount;
	}
}
