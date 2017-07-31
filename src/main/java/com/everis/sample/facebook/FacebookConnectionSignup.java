package com.everis.sample.facebook;

import com.everis.sample.persistence.AppUser;
import com.everis.sample.persistence.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        final AppUser appUser = new AppUser();
        appUser.setUsername(connection.getDisplayName());
        appUser.setPassword(randomAlphabetic(8));
        userRepository.save(appUser);
        return appUser.getUsername();
    }
}
