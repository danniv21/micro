package pe.com.claro.sales.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.claro.sales.order.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
} 