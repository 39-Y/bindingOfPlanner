package com.y39.bindingofplanner.action.entity;

import com.y39.bindingofplanner.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "action_relation")
public class ActionRelation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_action_id")
    private Action parentAction;

    @ManyToOne
    @JoinColumn(name = "child_action_id")
    private Action childAction;

}