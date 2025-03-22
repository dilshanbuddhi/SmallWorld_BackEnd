package org.example.smallworld_backend.repo;

import org.example.smallworld_backend.entity.Guid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuidRepository extends JpaRepository<Guid, Long> {
}
