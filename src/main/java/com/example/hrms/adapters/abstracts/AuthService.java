package com.example.hrms.adapters.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
     DataResult<String> verify(String mail);
}
