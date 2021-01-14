package com.toyproject.vending_machine.config;

import com.toyproject.vending_machine.controller.VendingMachineController;
import com.toyproject.vending_machine.dao.ImplVendingMachineDAO;
import com.toyproject.vending_machine.dao.VendingMachineDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VendingMachineConfig {
    // @Component를 상속하는 어노테이션들은 자동으로 bean이 되는 것을 확인하기 위한 주석
    // 결과> 된다.
    /*@Bean
    public VendingMachineController vendingMachineController() {
        return new VendingMachineController();
    }

    @Bean
    public VendingMachineDAO vendingMachineDAO() {
        return new ImplVendingMachineDAO();
    }*/
}
