package com.perapoch.controllers;

import com.perapoch.data.ReadingListRepository;
import com.perapoch.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by marcal.perapoch on 28/02/2017.
 */
@Controller
@RequestMapping("/readingList")
public class ReadingListController {

    private final ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    /**
     * Handles HTTP GET requests for /{reader} by retrieving a Book list from the repository for the reader
     * specified in the path. It puts the list of Book into the model under the keys "books" and returns
     * "readingList" as the logical name of the view to render the model.
     * @param reader
     * @param model
     * @return
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String reader, Model model) {
        final List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    /**
     * Handles HTTP POST requests for /{reader}, binding the data in the body of the request to a Book object.
     * It returns by specifying a redirect to the /{reader} (handled by the method above).
     * @param reader
     * @param book
     * @return
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
