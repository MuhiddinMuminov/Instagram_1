package uz.pdp.Instagram.service.userservice;

import uz.pdp.Instagram.model.User;
import uz.pdp.Instagram.service.BaseService;

import java.util.UUID;

public interface UserService extends BaseService<User> {
    User getByuser(String username,String password);
    UUID getid(String username);


}
