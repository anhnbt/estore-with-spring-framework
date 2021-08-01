package vn.aptech.estore.services;

import vn.aptech.estore.entities.Supplier;

public interface SupplierService {
    Iterable<Supplier> findAll();

    Supplier save(Supplier supplier);
}