package com.y39.bindingofplanner.action.entity;

import com.y39.bindingofplanner.action.dto.ActionResDto;
import com.y39.bindingofplanner.action.util.QuestType;
import com.y39.bindingofplanner.action.util.QuestTypeConverter;
import com.y39.bindingofplanner.common.entity.BaseEntity;
import com.y39.bindingofplanner.goal.entity.Goal;
import com.y39.bindingofplanner.goal.entity.GoalRelation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@Table(name = "action")
public class Action extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Comment("액션_ID")
    private Long id;

    @Column(name = "title", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Builder.Default
    @Comment("액션_제목")
    private String title = "Untitled";

    @Lob
    @Column(name = "content")
    @Comment("액션_내용")
    private String content;

    @Column(name = "plan_date")
    @Comment("액션_계획_날짜")
    private LocalDateTime planDate;

    @Column(name = "done_date")
    @Comment("액션_실행_날짜")
    private LocalDateTime doneDate;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    @Comment("목표_ID")
    private Goal goal;

    @OneToMany(mappedBy = "action", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("createDate")
    @Comment("액션_스택_내역")
    private List<ActionStackHistory> actionStackHistories = new ArrayList<>();

    @OneToMany(mappedBy = "action", orphanRemoval = true)
    @Comment("액션_태그")
    private List<ActionTag> actionTags = new ArrayList<>();

    public ActionResDto toResDto() {
        return ActionResDto.builder()
                .id(getId())
                .title(getTitle())
                .content(getContent())
                .doneDate(getDoneDate())
                .build();
    }
}