package pl.marek.repository;

import pl.marek.model.Address;
import pl.marek.model.User;

import java.util.List;

public interface IAccountRepository {

    List<User> selectAllUsers();

    Address selectAddress(String userId);

    int changePassword(String id, String newPassword);

    int changeAddress(String id, Address address);

    int deleteAddressForUser(String userId);

    int deleteUser(String id);

    int createAddress(Address address);

    int createUser(User user);
}
