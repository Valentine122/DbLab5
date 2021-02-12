package ua.lviv.iot.service;

import ua.lviv.iot.DAO.VaccinationDAO;
import ua.lviv.iot.model.Vaccination;

public class VaccinationService extends BaseService<Vaccination, Integer, VaccinationDAO> {
    public VaccinationService() {
        super(VaccinationDAO.class);
    }
}
