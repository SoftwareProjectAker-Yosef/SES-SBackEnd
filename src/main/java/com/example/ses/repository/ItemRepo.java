package com.example.ses.repository;

import com.example.ses.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Long> {
}
