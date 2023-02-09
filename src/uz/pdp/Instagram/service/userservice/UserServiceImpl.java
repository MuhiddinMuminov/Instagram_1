package uz.pdp.Instagram.service.userservice;

import uz.pdp.Instagram.model.User;
import uz.pdp.Instagram.repository.UserRepository;

import java.util.UUID;

public class UserServiceImpl implements UserService, UserRepository {
    @Override
    public int add(User model) {
        users.add(model);
        return 1;
    }

    @Override
    public User getById(UUID id) {
        for (User user:users) {
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public int edit(User update) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(update.getId())){
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int deleteById(UUID Id) {
        return 0;
    }

    @Override
    public User getByuser(String username, String password) {
        for (User user:users) {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public UUID getid(String username) {
        for (User user:users) {
            if(user.getUsername().equals(username)){
                return user.getId();
            }
        }
        return null;
    }
}
