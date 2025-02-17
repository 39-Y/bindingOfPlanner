package com.y39.bindingofplanner.goal.entity;

import com.y39.bindingofplanner.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "goal_tag")
public class GoalTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

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