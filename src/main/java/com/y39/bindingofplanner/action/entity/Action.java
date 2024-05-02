package com.y39.bindingofplanner.action.entity;

import com.y39.bindingofplanner.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "action")
public class Action extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Builder.Default
    private String title = "Untitled";

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "done_date")
    private LocalDateTime doneDate;

    @Column(name = "do_start_date")
    private LocalDateTime doStartDate;

    @Column(name = "do_end_date")
    private LocalDateTime doEndDate;

}