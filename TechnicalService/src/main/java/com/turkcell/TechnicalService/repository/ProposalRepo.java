package com.turkcell.TechnicalService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.Proposal;
import com.turkcell.TechnicalService.model.ProposalState;

@Repository
public interface ProposalRepo extends JpaRepository<Proposal, Long> {
	
	List<Proposal> findAllByUSERID(Long id);

	List<Proposal> findAllBySTATE(ProposalState state);

}
