package com.y39.bindingofplanner.action.repository;

import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.entity.ActionStackHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionStackHistoryRepository extends JpaRepository<ActionStackHistory, Long> {
}
