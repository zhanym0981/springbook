package com.yzhan.bookapp.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = 9067534668868356291L;

    private Long id;
    private int version;
    private String categoryName;
    private String isbn;
    private String title;
    private String publisher;
    private double price;

    public Book() { }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @NotEmpty(message = "{validation.categoryname.NotEmpty.message}")
    @Size(min = 3, max = 100, message = "{validation.categoryname.Size.message}")
    @Column(name = "CATEGORY_NAME")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @NotEmpty(message = "{validation.isbn.NotEmpty.message}")
    @Size(min = 10, max = 10, message = "{validation.isbn.Size.message}")
    @Column(name = "ISBN")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @NotEmpty(message = "{validation.title.NotEmpty.message}")
    @Size(min = 2, max = 200, message = "{validation.title.Size.message}")
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotEmpty(message = "{validation.publisher.NotEmpty.message}")
    @Size(min = 3, max = 100, message = "{validation.publisher.Size.message}")
    @Column(name = "PUBLISHER")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @NotNull(message = "{validation.price.NotNull.message}")
    @DecimalMin(value = "00.00", message = "{validation.price.Size.message}")
    @DecimalMax(value = "99.99", message = "{validation.price.Size.message}")
    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
}
