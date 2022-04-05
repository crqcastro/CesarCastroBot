package br.com.cesarcastro.telegram.bot.cesarcastrobot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.model_.UserModel;

@Repository
public interface UserDao extends JpaRepository<UserModel, Long>{

}
