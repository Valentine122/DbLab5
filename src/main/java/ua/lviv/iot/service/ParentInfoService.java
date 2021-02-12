package ua.lviv.iot.service;

import ua.lviv.iot.DAO.ParentInfoDAO;
import ua.lviv.iot.model.ParentInfo;

public class ParentInfoService extends BaseService<ParentInfo, Integer, ParentInfoDAO>{
    public ParentInfoService() {
        super(ParentInfoDAO.class);
    }
}
