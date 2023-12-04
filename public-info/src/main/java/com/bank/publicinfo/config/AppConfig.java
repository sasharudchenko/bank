package com.bank.publicinfo.config;

import com.bank.publicinfo.mapstruct.*;
import com.bank.publicinfo.model.ATM;
import com.bank.publicinfo.model.Branch;
import liquibase.pro.packaged.A;
import org.hibernate.validator.HibernateValidator;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("com.bank.publicinfo")
public class AppConfig {
    @Bean
    public BankDetailsMapper bankDetailsMapper() {
        return Mappers.getMapper(BankDetailsMapper.class);
    }
    @Bean
    LicenseMapper licenseMapper() {
        return Mappers.getMapper(LicenseMapper.class);
    }
    @Bean
    CertificateMapper certificateMapper() {
        return Mappers.getMapper(CertificateMapper.class);
    }
    @Bean
    BranchMapper branchMapper() {
        return Mappers.getMapper(BranchMapper.class);
    }
    @Bean
    ATMMapper atmMapper() {
        return Mappers.getMapper(ATMMapper.class);
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setProviderClass(HibernateValidator.class);
        return bean;
    }
//    @Bean
//    public ValidationBankDetailsService validatorBankDetailsService(Validator validator) {
//        return new ValidationBankDetailsService(validator);
//    }

}
