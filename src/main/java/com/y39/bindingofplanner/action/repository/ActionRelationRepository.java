package com.y39.bindingofplanner.action.repository;

import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.entity.ActionRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRelationRepository extends JpaRepository<ActionRelation, Long> {
}
