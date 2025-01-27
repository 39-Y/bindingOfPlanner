package com.y39.bindingofplanner.goal.entity;

import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.common.entity.BaseEntity;
import com.y39.bindingofplanner.goal.dto.GoalResDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "goal")
public class Goal extends BaseEntity {
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

    @OneToMany(mappedBy = "parentGoal", orphanRemoval = true)
    private List<GoalRelation> childGoals = new ArrayList<>();

    @OneToMany(mappedBy = "childGoal", orphanRemoval = true)
    private List<GoalRelation> parentGoals = new ArrayList<>();

    @OneToMany(mappedBy = "goal", orphanRemoval = true)
    private List<GoalTag> goalTags = new ArrayList<>();

    @OneToMany(mappedBy = "goal", orphanRemoval = true)
    private List<Action> actions = new ArrayList<>();

    public GoalResDto toResDto() {
        return GoalResDto.builder()
                .id(getId())
                .title(getTitle())
                .content(getContent())
                .doStartDate(getDoStartDate())
                .doEndDate(getDoEndDate())
                .doneDate(getDoneDate())
                .build();
    }
}
