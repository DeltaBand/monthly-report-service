package com.deltaband.tools.monthlyreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.deltaband.tools.monthlyreport.entity.User;

@Repository
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Integer>,
		PagingAndSortingRepository<User, Integer> {
}
