package com.rbprjojects.trekkingwebapp.controller;


	
	import javax.validation.Valid;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;

import com.rbprjojects.trekkingwebapp.entity.Client;
import com.rbprjojects.trekkingwebapp.repository.ClientRepository;
	






	@Controller
	@RequestMapping("/clients/")
	public class ClientController {
		
		@GetMapping("storage")
		public String getStorage() {
			return "storage.html";
		}

		private final ClientRepository clientRepository;

		@Autowired
		public ClientController(ClientRepository clientRepository) {
			this.clientRepository = clientRepository;
		}

		 @GetMapping("content")
		    public String getContent() {
		        return "content.html";
		    }
					
		@GetMapping("list")
		public String showUpdateForm(Model model) {
			model.addAttribute("clients", clientRepository.findAll());
			return "index";
		}
		
		@GetMapping("add")
		public String showAddForm(Client client) {
			return "add-client";
		}


		@PostMapping("add")
		public String addClient(@Valid Client client, BindingResult result, Model model) {
			if (result.hasErrors()) {
				return "add-client";
			}

			clientRepository.save(client);
			return "redirect:list";
		}

		@GetMapping("edit/{id}")
		public String showUpdateForm(@PathVariable("id") long id, Model model) {
			Client client = clientRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
			model.addAttribute("client", client);
			return "update-client";
		}

		@PostMapping("update/{id}")
		public String updateClient(@PathVariable("id") long id, @Valid Client client, BindingResult result,
				Model model) {
			if (result.hasErrors()) {
				client.setId(id);
				return "update-client";
			}

			clientRepository.save(client);
			model.addAttribute("clients", clientRepository.findAll());
			return "index";
		}

		@GetMapping("delete/{id}")
		public String deleteClient(@PathVariable("id") long id, Model model) {
			Client client = clientRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
			clientRepository.delete(client);
			model.addAttribute("client", clientRepository.findAll());
			return "index";
		}
	}


