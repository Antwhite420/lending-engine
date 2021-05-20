package com.peerlender.lendingengine.domain.service;

import com.peerlender.lendingengine.application.model.LoanRequest;
import com.peerlender.lendingengine.domain.exception.UserNotFoundException;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Optional;

@Component
public class LoanApplicationAdapter {

    private final UserRepository userRepository;

    @Autowired
    public LoanApplicationAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoanApplication transform(LoanRequest loanRequest) {
        Optional<User> userOptional = userRepository.findById(loanRequest.getBorrowerId());

        if (userOptional.isPresent()) {
            return new LoanApplication(loanRequest.getAmount(),
                    userOptional.get(),
                    Duration.ofDays(loanRequest.getDaysToRepay()),
                    loanRequest.getInterestRate());
        }else {
            throw new UserNotFoundException(loanRequest.getBorrowerId());
        }

    }
}
