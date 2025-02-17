package com.y39.bindingofplanner.goal.repository;

import com.y39.bindingofplanner.goal.entity.Goal;
import com.y39.bindingofplanner.goal.entity.GoalTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalTagRepository extends JpaRepository<GoalTag, Long> {
}
