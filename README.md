# Game Scraper
This is a Spring Boot app which can scrape content from gaming websites and store in a database

Set your database connection in # MainController.java

```java
  String url="jdbc:mysql://127.0.0.1:3306/movgam"; //url for Database connection
        String uname=""; //userName 
        String password=""; //Password 
        Class.forName(""); //Connection set up 
        
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement stmt = con.createStatement();
```

