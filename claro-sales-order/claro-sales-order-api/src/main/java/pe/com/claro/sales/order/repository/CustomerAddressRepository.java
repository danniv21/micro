package pe.com.claro.sales.order.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.sales.order.model.CustomerAddress;

@Repository
@Transactional
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {
} 