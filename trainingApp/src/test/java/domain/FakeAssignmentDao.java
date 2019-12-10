package domain;

import java.util.ArrayList;
import java.util.List;
import trainingapp.dao.AssignmentDao;
import trainingapp.domain.Assignment;

public class FakeAssignmentDao implements AssignmentDao {

    @Override
    public List<Assignment> findByPlayerId(int id) {
        return new ArrayList<>();
    }

    @Override
    public Assignment create(Assignment assignment) {
        return null;
    }
    
}
