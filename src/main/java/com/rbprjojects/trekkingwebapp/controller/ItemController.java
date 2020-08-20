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
import com.rbprjojects.trekkingwebapp.entity.Item;
import com.rbprjojects.trekkingwebapp.repository.ItemRepository;






@Controller
@RequestMapping("/items/")
public class ItemController {



	private final ItemRepository itemRepository;

	@Autowired
	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

				
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("items", itemRepository.findAllByOrderByNameAsc());
		return "items";
	}
	
	@GetMapping("sortByWeight")
	public String showsortedByWeightForm(Model model) {
		model.addAttribute("items", itemRepository.findAllByOrderByWeightDesc());
		return "items";
	}
	
	@GetMapping("add")
	public String showAddForm(Item item) {
		return "add-item";
	}


	@PostMapping("add")
	public String addItem(@Valid Item item, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-item";
		}

		itemRepository.save(item);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
		model.addAttribute("item", item);
		return "update-item";
	}

	
	@PostMapping("update/{id}")
	public String updateItem(@PathVariable("id") long id, @Valid Item item, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			item.setId(id);
			return "update-item";
		}

		itemRepository.save(item);
		model.addAttribute("items", itemRepository.findAll());
		return "items";
	}

	@GetMapping("delete/{id}")
	public String deleteItem(@PathVariable("id") long id, Model model) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
		itemRepository.delete(item);
		model.addAttribute("items", itemRepository.findAll());
		return "items";
	}
}
