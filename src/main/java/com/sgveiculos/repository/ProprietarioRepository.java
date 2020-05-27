package com.sgveiculos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sgveiculos.model.Proprietario;

/**Project: sgveiculos
 * File: ProprietarioRepository.java
 * @author jaime
 * Em 17-05-2020 **/
@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
/*
 * 
 *     Find By Name Ignore Case
 */
	//@Query("select e from Proprietario e where nome like concat(?1, '%')")
	 @Query("select e from Proprietario e where lower(e.nome) like lower(concat('%', concat( ?1, '%')))")
	 List<Proprietario> findByNome(String nome);
	 @Query(value="select * from t_proprietario order by id asc",nativeQuery = true)
	 List<Proprietario> findAllOrder();

}
