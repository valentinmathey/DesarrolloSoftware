package com.example.apirest.Entity.Audit;

import com.example.apirest.Config.CustomRevisionListener;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REVISION_INFO")
@RevisionEntity(CustomRevisionListener.class)
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    @SequenceGenerator(name = "revision_seq", sequenceName = "rbac.seq_revision_id")
    @RevisionNumber
    private int id;

    @Column(name = "REVISION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;

    // Nuevas columnas para guardar detalles del usuario o contexto
    @Column(name = "REV_USER")
    private String username;

    @Column(name = "REV_IP")
    private String ipAddress;
}
