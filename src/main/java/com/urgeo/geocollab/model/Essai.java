package com.urgeo.geocollab.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="ESSAI")
public class Essai implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EssaiType essaiType;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Dossier dossier;

    @Column(name = "ALT_ID")
    @Size(max = 20)
    private String altId;

    @Column(name = "SITE_NAME")
    private String siteName;

    @Column(name = "GEOMETRY_POINT", nullable = false, columnDefinition = "geometry(Point,4326)")
    private Point  geometryPoint;

    @Column(name="ESSAI_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date essaiDateTime;

    @Column(name="FILE")
    @Size(max = 200)
    private String file;

    @Column(name = "IMAGE")
    private String image;

    //sismique
    @Column(name = "DEPTH")
    private double depth;

    @Column(name = "VELOCITY")
    private double velocity;

    //penetration
    @Column(name = "SECTION_POINT")
    private double sectionPointe;

    @Column(name = "NB_COUP")
    private long nbCoup;

    @Column(name = "RS_DYNAMIC_POINTE")
    private double rsDynamicPointe;

    @Column(name = "DEPTH_REFUS")
    private double depthRefus;

    //electric
    @Column(name = "RESISTANCE")
    private double resistance;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "NOTE")
    private String note;

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
