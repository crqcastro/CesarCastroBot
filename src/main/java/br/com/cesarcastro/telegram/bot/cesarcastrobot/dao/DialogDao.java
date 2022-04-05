package br.com.cesarcastro.telegram.bot.cesarcastrobot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.model_.DialogModel;

@Repository
public interface DialogDao 	extends JpaRepository<DialogModel, Long>{

	@Query(value = "select max(d.id) + 1 from dialog d")
	public Long max();
	
}
