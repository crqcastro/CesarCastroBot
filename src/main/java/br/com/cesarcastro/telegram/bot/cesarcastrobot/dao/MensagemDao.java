package br.com.cesarcastro.telegram.bot.cesarcastrobot.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.model_.MensagemModel;

@Repository
public interface MensagemDao extends JpaRepository<MensagemModel, Long>{

	@Query(value = "select max(d.id) from mensagem d")
	public Long max();
	
	@Query(value = "select case when count(0) = 0 then 0 else 1 end from mensagem m where m.id = :id",  nativeQuery = true)
	public BigDecimal existe(@Param("id")Long id);

}
