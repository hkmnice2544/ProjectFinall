package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.User;

import java.util.Map;

public interface LoginService {

    User loginUser(Map<String, String> map);

}
