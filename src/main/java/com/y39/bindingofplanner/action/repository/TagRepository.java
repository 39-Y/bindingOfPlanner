package com.y39.bindingofplanner.action.repository;

import com.y39.bindingofplanner.action.entity.Action;
import com.y39.bindingofplanner.action.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
