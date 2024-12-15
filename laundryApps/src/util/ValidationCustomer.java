package util;

import error.ValidationException;
import model.Customer;

public class ValidationCustomer {
    // Method untuk validasi langsung dengan objek Customer
    public static void validate(Customer customer) throws ValidationException {
        if (customer.getName() == null || customer.getName().trim().isEmpty()) 
            throw new ValidationException("Nama tidak boleh kosong");
        if (customer.getAddress() == null || customer.getAddress().trim().isEmpty()) 
            throw new ValidationException("Alamat tidak boleh kosong");
        if (customer.getPhone() == null || customer.getPhone().trim().isEmpty()) 
            throw new ValidationException("Telepon tidak boleh kosong");
        if (customer.getEmail() == null || customer.getEmail().trim().isEmpty()) 
            throw new ValidationException("Email tidak boleh kosong");
    }
}
