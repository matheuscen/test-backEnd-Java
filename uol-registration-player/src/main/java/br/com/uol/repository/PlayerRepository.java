package br.com.uol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.uol.entity.PlayerEntity;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {

	@Query("select p.codename from PLAYER p where p.codename in ?1 AND p.group = ?2 GROUP BY p.codename")
	List<String> findIsCodinamesForUse(List<String> codinames, String group);

}
