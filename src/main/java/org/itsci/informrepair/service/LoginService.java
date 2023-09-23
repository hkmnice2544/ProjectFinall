package org.itsci.informrepair.service;

import org.itsci.informrepair.model.Equipment;
import org.itsci.informrepair.model.User;

import java.util.List;
import java.util.Map;

public interface LoginService {

    User loginUser(Map<String, String> map);

    Integer login(Map<String, String> map);

    User getLoginById(Integer userId);

    List<User> getAllUsers();
}
