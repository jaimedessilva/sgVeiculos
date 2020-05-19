package com.sgveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgveiculos.model.Veiculo;

/**Project: sgveiculos
 * File: VeiculoRepository.java
 * @author jaime
 * Em 16-05-2020 **/

@Repository
public interface VeiculoRepository extends JpaRepository <Veiculo, Long>  {
	
}	
