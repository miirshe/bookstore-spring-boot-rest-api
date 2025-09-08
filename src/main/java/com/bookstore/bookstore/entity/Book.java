package com.bookstore.bookstore.entity;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "books")
public class Book {

    public enum BookStatus {
        ACTIVE,
        INACTIVE,
        OUT_OF_STOCK
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name="title", nullable=false)
    private String title;

    @Column(name="description", nullable=true, columnDefinition="TEXT")
    private String description;

    @Column(name="price", nullable=false)
    private BigDecimal price;

    @Column(name="status", nullable=false)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false, foreignKey = @ForeignKey(name="fk_book_category"))
    private Category category;
    
}
