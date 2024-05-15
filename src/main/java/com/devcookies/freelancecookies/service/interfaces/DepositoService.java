package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.dto.DepositoSaqueDTO;
import com.devcookies.freelancecookies.entitys.DepositoSaque;
import com.devcookies.freelancecookies.repository.DepositoSaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DepositoService {

    public DepositoSaqueDTO createDepositoSaque(DepositoSaqueDTO depositoSaque);

    List<DepositoSaqueDTO> findAllDepositoSaque();

    public List<DepositoSaqueDTO> getAllDepositoSaque();

    public DepositoSaqueDTO getDepositoSaqueById(int id);

    public List<DepositoSaqueDTO> getAllDepositsOfUsuario(int id);
}
