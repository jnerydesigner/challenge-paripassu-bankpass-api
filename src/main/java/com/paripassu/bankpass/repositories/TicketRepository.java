package com.paripassu.bankpass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paripassu.bankpass.model.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	
	List<Ticket> OrderByStatusDesc();
	
	
	@Query(value = "SELECT * FROM tickets ORDER BY id DESC LIMIT ?1", nativeQuery = true)
	List<Ticket> findByTicketLimit(Number limit);
	
	@Query(value = "SELECT * FROM tickets ORDER BY id ASC LIMIT 1", nativeQuery = true)
	List<Ticket> findByTicketLimitUm();
	
	@Query(value = "SELECT * FROM tickets ORDER BY id ASC LIMIT ?1", nativeQuery = true)
	List<Ticket> findByTicketLimitGerencial(Number limit);
	
	
	@Query(value = "SELECT * FROM tickets ORDER BY id ASC LIMIT ?1 OFFSET ?2", nativeQuery = true)
	List<Ticket> findByTicketPagination(Number limit, Number offset);
	
	@Query(value = "SELECT * FROM tickets where is_attending = true", nativeQuery = true)
	List<Ticket> findByTrueTicket();
	
	@Query(value = "SELECT * FROM tickets where status = 'NA' ORDER BY id ASC  LIMIT ?1 OFFSET ?2", nativeQuery = true)
	List<Ticket> findByTicketNotAtending(Number limit, Number offset);
	
	@Query(value = "SELECT * FROM tickets where type = ?1", nativeQuery = true)
	List<Ticket> findByTicketByType(String type);
	
	
	@Query(value = "SELECT * FROM tickets where (status <> 'FA') ORDER BY type DESC LIMIT ?1 OFFSET ?2", nativeQuery = true)
	List<Ticket> findByTicketByOrder(Number limit, Number offset);
	
	@Query(value = "SELECT * FROM tickets where id = ?1", nativeQuery = true)
	Ticket getById(Number id);
	
	
	
	/* Querys a ordem dos atendimentos*/
	
	@Query(value = "SELECT count(*) FROM tickets where type = 'P' and status = 'SA'", nativeQuery = true)
	Integer countTypePandStatusSa();
	
	@Query(value = "SELECT * FROM tickets where type = 'P' and status = 'SA' ORDER BY id ASC", nativeQuery = true)
	List<Ticket> countTypePandStatusSaList();
	
	@Query(value = "SELECT count(*) FROM tickets where type = 'N' and status = 'SA'", nativeQuery = true)
	Integer countTypeNandStatusSa();
	
	@Query(value = "SELECT * FROM tickets where type = 'N' and status = 'SA' ORDER BY id ASC", nativeQuery = true)
	List<Ticket> countTypeNandStatusSaList();


	
}
