package com.learn.transaction.myAdmissionService.dao;

import com.learn.transaction.myAdmissionService.entity.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:28 PM
 */
@Repository
public interface HostelRepository extends JpaRepository<Hostel,Long> {
}
