package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.Team;

public interface TeamDao extends JpaRepository<Team, Long> {

}
