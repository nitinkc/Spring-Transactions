package com.learn.transaction.myAdmissionServiceJDBC.dao;

import com.learn.transaction.myAdmissionService.entity.Hostel;
import com.learn.transaction.myAdmissionService.entity.Society;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by nitin on Sunday, February/02/2020 at 8:40 PM
 */
@Repository
public class SocietyDaoImpl extends JdbcDaoSupport implements SocietyDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void save(Society society) {
        String sql = "INSERT INTO SOCIETY " + "(STUDENT_ENROLLED, SOCIETY_NAME) VALUES (?, ?)";
        getJdbcTemplate().update(sql, new Object[] {
                society.getStudentEnrolled(), society.getSociety_name().name() }
        );
    }

    @Override
    public void delete(Society society) {
        String sql = "DELETE FROM SOCIETY WHERE STUDENT_ENROLLED = ?";
        getJdbcTemplate().update(sql, new Object[] { society.getStudentEnrolled() });

    }
}