package pl.marek.service;

import pl.marek.model.Address;
import pl.marek.model.Order;
import pl.marek.model.User;
import pl.marek.repository.IAccountRepository;
import pl.marek.repository.IOrderRepository;

import java.util.List;

public class AccountService implements IAccountService {

    private IAccountRepository accountRepository;
    private IOrderRepository orderRepository;

    public AccountService(IAccountRepository accountRepository, IOrderRepository orderRepository) {
        this.accountRepository = accountRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<User> getUsers() {
        return accountRepository.selectAllUsers();
    }

    @Override
    public Address getAddressForUser(String userId) {
        return accountRepository.selectAddress(userId);
    }

    @Override
    public int createUserWithAddress(User user, Address address) {
        int firstResult = accountRepository.createUser(user);
        int secondResult = accountRepository.createAddress(address);

        return firstResult + secondResult == 2 ? 1 : 0;
    }

    @Override
    public int deleteUser(String userId) {
        List<Order> orders = orderRepository.selectAllEntriesForUser(userId);
        orders.forEach(o -> orderRepository.deleteOrderEntriesForOrder(o.getId()));

        int firstResult = orderRepository.deleteOrdersForUser(userId);
        int secondResult = accountRepository.deleteAddressForUser(userId);
        int thirdResult = accountRepository.deleteUser(userId);

        return firstResult + secondResult + thirdResult >= 2 ? 1 : 0;
    }

    @Override
    public int updatePassword(String userId, String newPassword) {
        return accountRepository.changePassword(userId, newPassword);
    }

    @Override
    public int updateAddress(String userId, Address addressToUpdate) {
        Address address = accountRepository.selectAddress(userId);
        int result = 0;
        if (address != null) {
            result = accountRepository.changeAddress(address.getId(), addressToUpdate);
        }

        return result;
    }
}
