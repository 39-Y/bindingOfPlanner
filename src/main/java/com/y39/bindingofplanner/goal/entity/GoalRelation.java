package com.y39.bindingofplanner.goal.entity;

import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "goal_relation")
public class GoalRelation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_goal_id")
    private Goal parentGoal;

    @ManyToOne
    @JoinColumn(name = "child_goal_id")
    private Goal childGoal;

}