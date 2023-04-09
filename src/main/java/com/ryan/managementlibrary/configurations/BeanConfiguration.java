package com.ryan.managementlibrary.configurations;


import com.ryan.managementlibrary.controllers.BookController;
import com.ryan.managementlibrary.controllers.BorrowBookController;
import com.ryan.managementlibrary.controllers.MainController;
import com.ryan.managementlibrary.controllers.UserController;
import com.ryan.managementlibrary.repositories.*;
import com.ryan.managementlibrary.services.*;
import com.ryan.managementlibrary.utils.ScannerUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BeanConfiguration {
    @Value("${driver}")
    private String dbDriver;
    @Value("${url}")
    private String dbUrl;
    @Value("${dbUser}")
    private String dbUser;
    @Value("${dbPassword}")
    private String dbPassword;

    @Bean
    ScannerUtil scannerUtil () {
        return new ScannerUtil();
    }

    @Bean
    public MainController getMainController() {
        return new MainController(getBookController(),
                getUserController(),
                getBorrowBookController());
    }

    @Bean
    public AdminService getAdminService() {
        return new AdminServiceImpl(getAdminRepository());
    }

    @Bean
    public AdminRepository getAdminRepository() {
        return new AdminRepositoryImpl(dataSource());
    }

    @Bean
    public BorrowBookController getBorrowBookController() {
        return new BorrowBookController(getBorrowBookService(), getUserService(), getBookService());
    }

    @Bean
    public BorrowBookService getBorrowBookService() {
        return new BorrowBookServiceImpl(getBorrowBookRepository());
    }

    @Bean
    public BorrowBookRepository getBorrowBookRepository() {
        return new BorrowBookRepositoryImpl(dataSource());
    }

    @Bean
    public UserController getUserController() {
        return new UserController(getUserService());
    }
    @Bean
    public UserService getUserService() {
        return new UserServiceImpl(getUserRepository());
    }

    @Bean
    public UserRepository getUserRepository() {
        return new UserRepositoryImpl(dataSource());
    }

    @Bean
    public BookController getBookController() {
        return new BookController(getBookService());
    }

    @Bean
    public BookService getBookService() {
        return new BookServiceImpl(getBookRepository());
    }

    @Bean
    public BookRepository getBookRepository() {
        return new BookRepositoryImpl(dataSource());
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        dataSource.setDriverClassName(dbDriver);

        return dataSource;
    }
}
