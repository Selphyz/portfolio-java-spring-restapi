package com.example.demoapirest.models.services;

import com.example.demoapirest.models.dao.IClienteDao;
import com.example.demoapirest.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

  @Autowired
  private IClienteDao clienteDao;

  @Override
  @Transactional(readOnly = true)
  public List<Cliente> findAll() {
    return (List<Cliente>) clienteDao.findAll();
  }

  @Override
  public Page<Cliente> findAll(Pageable pageable) {
    return null;
  }

  @Override
  @Transactional(readOnly = true)
  public Cliente findById(Long id) {
    return clienteDao.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public Cliente save(Cliente cliente) {
    return clienteDao.save(cliente);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    clienteDao.deleteById(id);
  }

}
