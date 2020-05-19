package com.sgveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgveiculos.model.Proprietario;

/**Project: sgveiculos
 * File: ProprietarioRepository.java
 * @author jaime
 * Em 17-05-2020 **/
@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
	
}
