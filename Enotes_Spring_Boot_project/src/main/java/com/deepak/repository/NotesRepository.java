package com.deepak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.entity.Notes;
import com.deepak.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

	public List<Notes> findByUser(User user);
}
