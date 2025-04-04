package org.example.smallworld_backend.repo;

import org.example.smallworld_backend.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request , Long>
{
}
