package com.wipro.tools.LogAnalysis.services;

import com.wipro.tools.LogAnalysis.util.FileSearch;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements  SearchService {

    @Override
    public String searchFile(String fileLoc, String lastToSearch, String firstToSearch, String keyword) {
        return FileSearch.readFile(fileLoc,lastToSearch,firstToSearch,keyword);
    }


}
