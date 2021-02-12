package ua.lviv.iot.controller;

import ua.lviv.iot.model.ParentInfo;
import ua.lviv.iot.service.ParentInfoService;

public class ParentInfoController extends BaseController<ParentInfo, Integer, ParentInfoService>{
    public ParentInfoController() {
        super(ParentInfoService.class);
    }
}
