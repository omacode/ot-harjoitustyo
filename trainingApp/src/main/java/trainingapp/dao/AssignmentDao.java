package trainingapp.dao;

import java.util.List;
import trainingapp.domain.Assignment;

public interface AssignmentDao {

    public List<Assignment> findByPlayerId(int id);

    public Assignment create(Assignment assignment);
}
