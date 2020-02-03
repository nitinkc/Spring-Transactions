package com.learn.transaction.myAdmissionServiceJDBC.dao;

import com.learn.transaction.myAdmissionService.entity.Hostel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by nitin on Sunday, February/02/2020 at 8:39 PM
 */
@Repository
public class HostelDaoImpl extends JdbcDaoSupport implements HostelDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void save(Hostel hostel) {

        String sql = "INSERT INTO HOSTEL " + "(STUDENT_ENROLLED, HOSTEL_NAME) VALUES (?, ?)";
        getJdbcTemplate().update(sql, new Object[] {
                hostel.getStudentEnrolled(), hostel.getHostel_name().name() }
        );
    }

    @Override
    public void delete(Hostel hostel) {
        String sql = "DELETE FROM HOSTEL WHERE STUDENT_ENROLLED = ?";
        getJdbcTemplate().update(sql, new Object[] { hostel.getStudentEnrolled() });

    }
}
