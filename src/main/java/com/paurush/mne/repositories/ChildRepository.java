/**
 * 
 */
package com.paurush.mne.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paurush.mne.models.Child;

/**
 * @author Paul
 *
 */
public interface ChildRepository extends JpaRepository<Child, Long>{
	
	public List<Child> findByYearEnrolledAndBarrack_Id(Integer yearEnrolled, Long barrackId);

}
