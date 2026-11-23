package com.skillpilots;
import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.BindingResult; import org.springframework.web.bind.annotation.*;
@Controller public class BookController {
private final BookRepo repo; public BookController(BookRepo repo){this.repo=repo;}
@GetMapping("/") public String root(){return "redirect:/books";}
@GetMapping("/books") public String list(Model m){m.addAttribute("books",repo.findAll());return "books";}
@GetMapping("/books/new") public String form(Model m){m.addAttribute("book",new Book());return "book-form";}
@PostMapping("/books") public String save(@Valid @ModelAttribute("book") Book book, BindingResult result){
if(result.hasErrors()) return "book-form"; repo.save(book); return "redirect:/books";}
@GetMapping("/books/{id}/edit") public String edit(@PathVariable Long id,Model m){m.addAttribute("book",repo.findById(id).orElseThrow());return "book-form";}
@PostMapping("/books/{id}") public String update(@PathVariable Long id,@Valid @ModelAttribute("book") Book book,BindingResult result){
if(result.hasErrors()){book.setId(id);return "book-form";} book.setId(id);repo.save(book);return "redirect:/books";}
@GetMapping("/books/{id}/delete") public String delete(@PathVariable Long id){repo.deleteById(id);return "redirect:/books";}
}