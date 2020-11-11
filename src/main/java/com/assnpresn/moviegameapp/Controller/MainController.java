package com.assnpresn.moviegameapp.Controller;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assnpresn.moviegameapp.Scraper.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

    @RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public ModelAndView search(SearchC s){

        ModelAndView mav = new ModelAndView("found.jsp");
        List<Item> results = WebScraper.search(s.getSearchText());
        List<String> testList = new ArrayList<>();

        if(results.size()!=0){
            mav.addObject("isSuccessful", "Search Results");
        }
        else{
            mav.addObject("isSuccessful", "No content found regarding " + s.searchText);
        }
        mav.addObject("results", results);
        System.out.println(s.getSearchText());
        for(Item r : results){
            System.out.println(r.title);
            System.out.println(r.url);
        }
        return mav;
    }
}
