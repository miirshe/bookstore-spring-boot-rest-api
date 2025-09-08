package com.bookstore.bookstore.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;







@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "categories")
public class Category {


    public enum CategoryType {
        FICTION,
        NON_FICTION,
        CHILDREN,
        ADULT
    }
    
    public enum CategoryStatus {
        ACTIVE,
        INACTIVE
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description", nullable=true, columnDefinition="TEXT")
    private String description;

    @Column(name="type", nullable=false)
    @Enumerated(EnumType.STRING)
    private CategoryType type;


    @Column(name="status", nullable=false)
    @Enumerated(EnumType.STRING)
    private CategoryStatus status;
}
