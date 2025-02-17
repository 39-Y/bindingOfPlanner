package com.y39.bindingofplanner.action.repository;

import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.entity.ActionTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionTagRepository extends JpaRepository<ActionTag, Long> {
}
