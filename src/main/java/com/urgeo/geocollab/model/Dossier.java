package com.urgeo.geocollab.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "DOSSIER")
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Institution institution;

    @OneToMany(mappedBy = "dossier")
    private List<Essai> essais = new ArrayList<Essai>();

    @Column(name = "CODE")
    @Size(max = 10)
    private String code;

    @Column(name = "DESC")
    private String desc;

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
