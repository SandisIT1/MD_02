package lv.va.sludinajumuportals.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Advertisement")
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String city;
    String author;
    Long number;
    Double price;

    public Advertisement() {
    }

    public Advertisement(Long id, String title, String city, String author, Long number, Double price) 
    {
        this.id = id;
        this.title = title;
        this.city = city;
        this.author = author;
        this.number = number;
        this.price = price;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getMessage() 
    {
        return city;
    }

    public void setMessage(String city) 
    {
        this.city = city;
    }

    public String getAuthor() 
    {
        return author;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }
    
    public Long getNumber() 
    {
        return number;
    }

    public void setNumber(Long number) 
    {
        this.number = number;
    }
    
    public Double getPrice() 
    {
        return price;
    }

    public void setPrice(Double price) 
    {
        this.price = price;
    }
}
