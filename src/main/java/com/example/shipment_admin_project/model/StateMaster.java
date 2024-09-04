package com.example.shipment_admin_project.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "states")
public class StateMaster {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "name")
    private String name;

    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "is_deleted")
    private Boolean isDeleted=false;

    @Column(name = "is_active")
    private  Boolean isActive=true;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
