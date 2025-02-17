package com.y39.bindingofplanner.action.repository;

import com.y39.bindingofplanner.action.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}
