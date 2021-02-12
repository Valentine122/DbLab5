package ua.lviv.iot.DAO;

import ua.lviv.iot.model.Vaccination;

public class VaccinationDAO extends BaseDAO<Vaccination, Integer> {
    public VaccinationDAO() {
        super(Vaccination.class);
    }
}
