package com.example.hrms.adapters.concretes;

import com.example.hrms.adapters.abstracts.AuthService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.googleAuth.GoogleAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleAuthAdapter implements AuthService {
    private GoogleAuth googleAuth;

    @Autowired
    public GoogleAuthAdapter(GoogleAuth googleAuth) {
        this.googleAuth = googleAuth;
    }

    @Override
    public DataResult<String> verify(String mail) {
        return new SuccessDataResult<>(googleAuth.verify(mail));
    }
}
