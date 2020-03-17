package com.softeck.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
       private int id;

    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Size(max = 150)
    private String description;

    @NotNull
    @Lob
    private String content;


    @OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy ="Post")
    @JoinColumn(name="Pst_fk", referencedColumnName = "id")
    private Set<Comment> commentList=new HashSet<>();

    public Post(int id, String title, String description, String content) {
    }
}
