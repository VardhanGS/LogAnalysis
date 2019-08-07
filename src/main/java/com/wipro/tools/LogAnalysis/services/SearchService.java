package com.wipro.tools.LogAnalysis.services;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


public interface SearchService {

    public String searchFile(String fileLoc, String lastToSearch, String firstToSearch, String keyword);
}
