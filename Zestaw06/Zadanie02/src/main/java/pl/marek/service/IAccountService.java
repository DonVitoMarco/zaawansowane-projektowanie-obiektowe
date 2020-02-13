package pl.marek.service;

import pl.marek.model.Address;
import pl.marek.model.User;

import java.util.List;

public interface IAccountService {

    List<User> getUsers();

    Address getAddressForUser(String userId);

    int createUserWithAddress(User user, Address address);

    int deleteUser(String userId);

    int updatePassword(String userId, String newPassword);

    int updateAddress(String userId, Address addressToUpdate);
}
