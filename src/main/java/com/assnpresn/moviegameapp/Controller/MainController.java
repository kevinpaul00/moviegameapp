package com.assnpresn.moviegameapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assnpresn.moviegameapp.Scraper.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

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

        if(results.size()!=0){
            mav.addObject("isSuccessful", "Search Results");
        }
        else{
            mav.addObject("isSuccessful", "No content found regarding " + s.searchText);
        }

        mav.addObject("results", results);
        return mav;
    }

    @RequestMapping(value = { "/searchDB" }, method = RequestMethod.GET)
    public ModelAndView searchDB(SearchC s) throws ClassNotFoundException, SQLException {
        ModelAndView mav = new ModelAndView("addedDB.jsp");
        String url="jdbc:mysql://127.0.0.1:3306/movgam";
        String uname="root";
        String password="root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        List<Item> results = WebScraper.search(s.getSearchText());

        Connection con = DriverManager.getConnection(url,uname,password);
        Statement stmt = con.createStatement();

        if(results.size()!=0){
            mav.addObject("isSuccessful", "Search Results");
            for(Item result : results){
                String query = "INSERT INTO IGN(SEARCHQUERY, TITLE, URL) VALUES ('" + s.searchText + "','" + result.title.replace("'"," ") + "','" + result.url + "')";
                //System.out.println(query);
                stmt.executeUpdate(query);
            }
        }
        else{
            mav.addObject("isSuccessful", "No content found regarding " + s.searchText);
        }

        mav.addObject("results", results);
        return mav;
    }

    @RequestMapping(value = { "/dataStore" }, method = RequestMethod.GET)
    public ModelAndView dataStore() throws ClassNotFoundException, SQLException {
        ArrayList<Item> games = new ArrayList<Item>();

        ModelAndView mav = new ModelAndView("dataPage.jsp");
        String url="jdbc:mysql://127.0.0.1:3306/movgam";
        String uname="root";
        String password="root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,uname,password);
        Statement stmt = con.createStatement();

        String query="Select * from ign";
        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()) {
            games.add(new Item(rs.getString(1),rs.getString(2),rs.getString(3) ));
        }

        mav.addObject("results", games);
        return mav;
    }

    @RequestMapping(value = { "/deleteDB" }, method = RequestMethod.GET)
    public ModelAndView deleteDB(SearchC s) throws ClassNotFoundException, SQLException {
        ModelAndView mav = new ModelAndView("home.jsp");

        String url="jdbc:mysql://127.0.0.1:3306/movgam";
        String uname="root";
        String password="root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,uname,password);
        Statement stmt = con.createStatement();

        String query="Delete from ign where searchQuery='"+s.getSearchText()+"'";
        int n = stmt.executeUpdate(query);
        return mav;
    }

}
