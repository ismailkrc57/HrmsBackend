package com.example.hrms.googleAuth;

import org.springframework.stereotype.Service;

@Service
public class GoogleAuth {
    public String verify(String mail)
    {
        return mail + ": Verifyed";
    }
}
