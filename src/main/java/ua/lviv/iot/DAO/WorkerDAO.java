package ua.lviv.iot.DAO;

import ua.lviv.iot.model.Worker;

public class WorkerDAO extends BaseDAO<Worker, Integer> {
    public WorkerDAO() {
        super(Worker.class);
    }
}
