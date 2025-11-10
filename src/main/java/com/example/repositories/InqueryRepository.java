package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Inquery;

public interface InqueryRepository extends JpaRepository<Inquery, Long>
{
	List<Inquery> findByPhoneno(String phoneno);
}
