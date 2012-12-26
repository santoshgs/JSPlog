package model;

/**
 *
 * @author Santosh
 */
public class Posts {
    String title;
    String category;
    String body;
    
    public Posts(String t,String cat,String body)
    {
     this.title=t;
     this.category=cat;
     this.body=body;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getBody() {
        return body;
    }
      
}
