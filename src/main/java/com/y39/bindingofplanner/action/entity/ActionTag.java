package com.y39.bindingofplanner.action.entity;

import com.y39.bindingofplanner.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "action_tag")
public class ActionTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;

    @Column(name = "name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Builder.Default
    private String name = "unNamed";

    @Column(name = "bg_color", length = 7)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String bgColor;

    @Column(name = "font_color", length = 7)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String fontColor;
}