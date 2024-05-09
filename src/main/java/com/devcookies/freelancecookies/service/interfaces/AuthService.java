package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.dto.LoginDTO;
import com.devcookies.freelancecookies.dto.UsuarioDTO;

public interface AuthService {
    UsuarioDTO realizarLogin(LoginDTO loginDTO);
}