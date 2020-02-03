package com.learn.transaction.myAdmissionServiceJDBC.dao;

import com.learn.transaction.myAdmissionService.entity.Society;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:29 PM
 */
public interface SocietyDao {
    void save(Society society);

    void delete(Society society);
}
