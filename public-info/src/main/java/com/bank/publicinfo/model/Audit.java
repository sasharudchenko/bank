package com.bank.publicinfo.model;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;


@Entity
@Table
@JsonSerialize
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()

public class Audit {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="entity_type" )
    private String entityType;
    @Column(name = "operation_type")
    private String operationType;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "new_entity_json")
    private String newEntityJson;
    @Column(name = "entity_json")
    private String entityJson;




}
