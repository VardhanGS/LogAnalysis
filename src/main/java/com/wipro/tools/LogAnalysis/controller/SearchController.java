package com.wipro.tools.LogAnalysis.controller;

import com.wipro.tools.LogAnalysis.entity.SearchStrings;
import com.wipro.tools.LogAnalysis.services.SearchService;
import com.wipro.tools.LogAnalysis.services.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    SearchStrings searchStr = null;
    @Autowired
    SearchService searchService;
    @GetMapping("/search")
    public String searchForm(Model model) {
        if (searchStr == null)
            searchStr = new SearchStrings();
        model.addAttribute("search", searchStr);

        return "search";
    }
    @PostMapping("/search")
    public String getResults(@ModelAttribute SearchStrings search) {
        System.out.println("File Loc: "+ search.getFileLoc());
        search.setResult(
                searchService.searchFile(search.getFileLoc(), search.getLastToSearch(), search.getFirstToSearch(), search.getKeyword()));
        System.out.println(search.toString());
        searchStr = new SearchStrings();
        searchStr.setResult(search.getResult());
        searchStr.setFileLoc(search.getFileLoc());
        searchStr.setFirstToSearch(search.getFirstToSearch());
        searchStr.setLastToSearch(search.getLastToSearch());
        searchStr.setKeyword(search.getKeyword());
        searchStr.setHidden(true);

        return "redirect:/search";
    }
}
