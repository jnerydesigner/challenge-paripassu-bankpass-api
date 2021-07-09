package com.paripassu.bankpass.controllers;


import java.util.List;
import java.util.Map;
import com.paripassu.bankpass.model.Ticket;
import com.paripassu.bankpass.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paripassu.bankpass.helpers.GenerateRandoPass;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class TicketController {
	
	
	@Autowired
	private TicketRepository ticketRepository;
	
	
	//get Tickets
	@GetMapping("tickets")
	public List<Ticket> getAllTickets(){
		return this.ticketRepository.findAll();
	}
	
	@GetMapping("tickets/status")
	public List<Ticket> getAllStatusOrderByDesc(){
		return this.ticketRepository.OrderByStatusDesc();
	}
	
	@GetMapping("tickets/status/limit")
	public List<Ticket> getAllStatusLimit(Number limit){
		return this.ticketRepository.findByTicketLimit(limit);
	}
	
	@GetMapping("tickets/count")
	public int getRowCount(){
		int limit = 4;
		int rows = (int) this.ticketRepository.count();
		int totalPage = (int) Math.ceil(rows / limit);
		return totalPage;
	}
	
	@GetMapping("tickets/not_answered")
	public List<Ticket> getTicketNotAtending(Integer page){	
		if(page <= 0) {
			page = 1;
		}
		
		int rows = (int) this.ticketRepository.count();
		int limit = 4;
		int offset = (limit * page) - limit;	
		int totalPage = (int) Math.ceil(rows / limit);
		
		if(page > totalPage) {
			offset = (limit * totalPage) - limit;
		}
		
		return this.ticketRepository.findByTicketNotAtending(limit, offset);
	}
	
	@GetMapping("tickets/find_type")
	public List<Ticket> getTicketFindType(String type){		
		return this.ticketRepository.findByTicketByType(type);
	}
	
	@GetMapping("tickets/atendimento/{page}")
	public List<Ticket> getTicketFindAtendimentos(@PathVariable("page") Integer page){	
		if(page <= 0) {
			page = 1;
		}
		int rows = (int) this.ticketRepository.count();
		int limit = 4;
		int offset = (limit * page) - limit;	
		int totalPage = (int) Math.ceil(rows / limit);
		
		if(page > totalPage) {
			offset = (limit * totalPage) - limit;
		}
		return this.ticketRepository.findByTicketByOrder(limit, offset);
		
	}
	
	
	
	@GetMapping("tickets/pagination/{page}")
	public List<Ticket> getPaginationTickets(@PathVariable("page") Integer page){
		if(page <= 0) {
			page = 1;
		}
		int rows = (int) this.ticketRepository.count();
		int limit = 4;
		int offset = (limit * page) - limit;	
		int totalPage = (int) Math.ceil(rows / limit);
		
		if(page > totalPage) {
			offset = (limit * totalPage) - limit;
		}
		
		
		return this.ticketRepository.findByTicketPagination(limit, offset);
	}
	
	@GetMapping("tickets/gerencial/limit")
	public List<Ticket> getAllStatusLimitGerencial(Number limit){
		return this.ticketRepository.findByTicketLimitGerencial(limit);
	}
	
	@GetMapping("tickets/status/limitum")
	public List<Ticket> getAllStatusLimitUm(){
		return this.ticketRepository.findByTicketLimitUm();
	}
	
	@GetMapping("tickets/attending")
	public List<Ticket> getTicketAttending(){
		return this.ticketRepository.findByTrueTicket();
	}
	
	
	@GetMapping("/tickets/{type}")
	public String generateTicket(@PathVariable("type") String type) {
		GenerateRandoPass pass = new GenerateRandoPass();
		String ticket = pass.tickets(type);

		return ticket;
	}
	
	
	@PostMapping("/tickets")
	public Ticket createTicket(@RequestBody Ticket ticket){
		var typeTicket = ticket.getType();
		GenerateRandoPass pass = new GenerateRandoPass();
		String realTicket = pass.tickets(typeTicket);
		ticket.setNumber(realTicket);
		
		return ticketRepository.save(ticket);
	}
	
	@PutMapping("tickets/attending/{id}")
	public Ticket updateTrueTicket(@PathVariable("id") Integer id){
		Ticket ticket = this.ticketRepository.getById(id);
		
		if(ticket.getIs_attending()) {
			ticket.setIs_attending(false);			
		}else {
			ticket.setStatus("FA");
			ticket.setIs_attending(true);	
		}
		
		
		return this.ticketRepository.save(ticket);
	}
	
	
	@DeleteMapping("/tickets/{id}")
	public Map<String,Boolean> deleteTicket(@PathVariable(value = "id") Long ticketId){
		Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
		
		ticketRepository.delete(ticket);
		return null;			
	}
	
	
	@PutMapping("/tickets/update-ea/{id}")
	public ResponseEntity<Ticket> updateTicketEa(@PathVariable(value = "id") Long ticketId){
		Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
		
		// EM - EM ATENDIMENTO
		String newStatus = "EA";
		
		ticket.setStatus(newStatus);
		
		final Ticket updatedTicket = ticketRepository.save(ticket);
		return ResponseEntity.ok(updatedTicket);
		
		
	}
	
	@PutMapping("/tickets/update-fa/{id}")
	public ResponseEntity<Ticket> updateTicketFa(@PathVariable(value = "id") Long ticketId){
		Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
		
		
		//FA - FINALIZADO O ATENDIMENTO
		String newStatus = "FA";
		
		ticket.setStatus(newStatus);
		
		final Ticket updatedTicket = ticketRepository.save(ticket);
		return ResponseEntity.ok(updatedTicket);
		
		
	}
	
	@PutMapping("/tickets/update-ca/{id}")
	public ResponseEntity<Ticket> updateTicketCa(@PathVariable(value = "id") Long ticketId){
		Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
		
		//CA - 
		String newStatus = "CA";
		
		ticket.setStatus(newStatus);
		
		final Ticket updatedTicket = ticketRepository.save(ticket);
		return ResponseEntity.ok(updatedTicket);
		
		
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
		
	
}
