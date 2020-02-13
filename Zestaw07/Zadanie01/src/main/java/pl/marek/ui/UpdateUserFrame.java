package pl.marek.ui;

import pl.marek.model.Address;
import pl.marek.service.IAccountService;

import javax.swing.*;

public class UpdateUserFrame extends JFrame {

    private String id;
    private IAccountService accountService;
    private Address address;

    protected JTextField cityText;
    protected JTextField streetText;
    protected JTextField houseText;
    protected JTextField postCodeText;

    public UpdateUserFrame(String id, IAccountService accountService) {
        this.id = id;
        this.accountService = accountService;
        this.address = accountService.getAddressForUser(id);

        setVisible(true);
        setLayout(null);
        setResizable(false);
        setTitle("ZZPO");
        setSize(450, 350);

        createForm();
        setValues();
    }

    public void createForm() {
        JLabel titleCreator = new JLabel("UPDATE CREATOR");
        titleCreator.setBounds(50, 5, 200, 15);

        JLabel cityLabel = new JLabel("City: ");
        cityLabel.setBounds(10, 20, 200, 15);

        cityText = new JTextField("");
        cityText.setBounds(10, 45, 200, 20);

        JLabel streetLabel = new JLabel("Street: ");
        streetLabel.setBounds(10, 70, 200, 15);

        streetText = new JTextField("");
        streetText.setBounds(10, 85, 200, 20);

        JLabel houseLabel = new JLabel("House number: ");
        houseLabel.setBounds(10, 110, 200, 15);

        houseText = new JTextField("");
        houseText.setBounds(10, 135, 200, 20);

        JLabel postCodeLabel = new JLabel("Post Code: ");
        postCodeLabel.setBounds(10, 160, 200, 15);

        postCodeText = new JTextField("");
        postCodeText.setBounds(10, 185, 200, 20);

        JButton save = new JButton("SAVE");
        save.setBounds(10, 210, 200, 15);

        save.addActionListener(e -> {
            updateUser();
        });

        add(cityLabel);
        add(cityText);
        add(streetLabel);
        add(streetText);
        add(houseLabel);
        add(houseText);
        add(postCodeLabel);
        add(postCodeText);
        add(save);
    }

    public void setValues() {
        cityText.setText(address.getCity());
        streetText.setText(address.getStreet());
        houseText.setText(address.getHouseNumber());
        postCodeText.setText(address.getPostCode());
    }

    public void updateUser() {
        String city = cityText.getText();
        String street = streetText.getText();
        String house = houseText.getText();
        String postCode = postCodeText.getText();

        if (!city.equals("") && !street.equals("") && !house.equals("") && !postCode.equals("")) {
            Address addressUpdate = new Address(address.getId(), city, street, house, postCode, id);

            accountService.updateAddress(id, addressUpdate);
        }
    }
}
