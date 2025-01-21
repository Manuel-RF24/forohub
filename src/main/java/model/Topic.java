package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

    @Id
    private Long id;
    private String title;
    private String description;

    // Getters y setters
}
