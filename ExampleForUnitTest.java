package com.example.onlinetestsservice.models;

import com.example.onlinetestsservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExampleForUnitTest {

    private exampleUI ourUI;
    private UserRepository ourUserRepository;

    public ExampleForUnitTest(exampleUI ui, UserRepository userRepository){
        ourUI = ui;
        ourUserRepository = userRepository;

    }

    public boolean update(String name, String newName){
        Optional<User> userOptional = ourUserRepository.findByName(name);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            List<String> errorList = validateUserName(newName);
            if(errorList.isEmpty()) {
                user.setName(newName);
            }
            else{
                ourUI.showErrors(errorList);
                // TODO: 22.11.21 move this to UI
            }
            return true;
        }
        return false;
    }

    private List<String> validateUserName(String user){
        List<String> validationErrors = new ArrayList<>();
        //symbols name 3 to 15
        if(user.length() < 3 && user.length() > 15){
            validationErrors.add("User name must be at least 3 symbols and max 15");
        }
        //must contain only letters
        //todo apply regexp pattern

        //must not be admin
        if(user.contains("admin")){
            validationErrors.add("user name must not contain admin");
        }

        return validationErrors;
    }
}
