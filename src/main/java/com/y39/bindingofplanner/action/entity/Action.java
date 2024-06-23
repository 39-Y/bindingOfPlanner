package com.y39.bindingofplanner.action.entity;

import com.y39.bindingofplanner.action.dto.ActionReqDto;
import com.y39.bindingofplanner.action.dto.ActionResDto;
import com.y39.bindingofplanner.action.util.QuestType;
import com.y39.bindingofplanner.action.util.QuestTypeConverter;
import com.y39.bindingofplanner.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
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

    @OneToMany(mappedBy = "action", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("createDate")
    private List<ActionStackHistory> actionStackHistories = new ArrayList<>();

    @OneToMany(mappedBy = "parentAction", orphanRemoval = true)
    private List<ActionRelation> childActions = new ArrayList<>();

    @OneToMany(mappedBy = "childAction", orphanRemoval = true)
    private List<ActionRelation> parentActions = new ArrayList<>();

    @OneToMany(mappedBy = "action", orphanRemoval = true)
    private List<ActionTag> actionTags = new ArrayList<>();

    @Convert(converter = QuestTypeConverter.class)
    private QuestType questType;


    public ActionResDto toResDto() {
        return ActionResDto.builder()
                .id(getId())
                .title(getTitle())
                .content(getContent())
                .doStartDate(getDoStartDate())
                .doEndDate(getDoEndDate())
                .doneDate(getDoneDate())
                .build();
    }
}