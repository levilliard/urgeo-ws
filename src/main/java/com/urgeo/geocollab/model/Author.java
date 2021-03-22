package com.urgeo.geocollab.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "AUTHOR")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "author")
    private List<Essai> essais = new ArrayList<Essai>();

    @Column(name = "FIRSTNAME")
    @Size(max = 40)
    @NotNull
    private String firtsname;

    @Column(name = "LASTNAME")
    @Size(max = 40)
    @NotNull
    private String lastname;

    @Column(name = "TELS")
    private String tels;

    @Column(name = "EMAIL")
    private String email;

    @Column(name="DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name="CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "DATE_MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
}
