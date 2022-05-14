package com.example.config;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@Import({
        DataSourceDevConfiguration.class
})
@ComponentScan(
        basePackages = {"com.example"}
)
@PropertySource("classpath:transfer.properties")
public class TransferServiceConfiguration {
//
//    @Bean
//    @Scope("singleton")
//    public AccountRepository accountRepository(DataSource dataSource) {
//        return new JdbcAccountRepository(dataSource);
//    }

//    @Bean
//    @Scope("singleton")
//    public TransferService transferService(AccountRepository accountRepository) {
//        return new TransferServiceImpl(accountRepository);
//    }


}
