package com.y39.bindingofplanner.goal.repository;

import com.y39.bindingofplanner.goal.entity.Goal;
import com.y39.bindingofplanner.goal.entity.GoalRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
