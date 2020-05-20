package com.sgveiculos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sgveiculos.model.Veiculo;

/**Project: sgveiculos
 * File: VeiculosPgRepository.java
 * @author jaime
 * Em 20-05-2020 **/

/*
 *  Interface que faz a busca paginada de um veículo
 */
public interface VeiculosPgRepository extends PagingAndSortingRepository<Veiculo, Long> {
			@Query("select e from Veiculo e")
			List<Veiculo> getListOrder(Sort sort);
			Page<Veiculo> findAll(Pageable pg);
}
