package br.com.cesarcastro.telegram.bot.cesarcastrobot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.model_.ChatModel;

@Repository
public interface ChatDao extends JpaRepository<ChatModel, Long>{

}
