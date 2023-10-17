package com.bookuser.controller;

import com.bookuser.dto.BookDTO;
import com.bookuser.dto.UserDTO;
import com.bookuser.entity.Book;
import com.bookuser.entity.User;
import com.bookuser.service.BookService;
import com.bookuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/{userId}/list-book")
    public String getBook(ModelMap model, @PathVariable("userId") int userId) {
        User user = userService.getUser(userId);
        if(user == null) {
            return "404";
        }
        model.addAttribute("user", user);
        model.addAttribute("books", user.getBooks());
        return "list-book";
    }

    @GetMapping("{userId}/addBook")
    public String addBook(ModelMap model, @PathVariable("userId") int userId) {
        User user = userService.getUser(userId);
        model.addAttribute("user", new UserDTO(user.getUserId(), user.getUserName(), user.getPassword()));
        model.addAttribute("book", new BookDTO());
        return "addBook";
    }

    @PostMapping("/{userId}/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, @PathVariable("userId") int userId, ModelMap model) {
        User user = userService.getUser(userId);
        book.setUser(user);
        bookService.saveBook(book);
        return "redirect:/book/" + userId + "/list-book";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int bookId, @RequestParam("userId") int userId) {
        bookService.deleteBook(bookId);
        return "redirect:/book/" + userId + "/list-book";
    }

    @GetMapping("{userId}/delete")
    public String deleteBook(@PathVariable("userId") int userId) {
        bookService.deleteBookUser(userId);
        userService.deleteUser(userId);
        return "redirect:/user/list-user";
    }
}
