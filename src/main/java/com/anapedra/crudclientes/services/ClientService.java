package com.anapedra.crudclientes.services;

import com.anapedra.crudclientes.dtos.ClientDTO;
import com.anapedra.crudclientes.entities.Client;
import com.anapedra.crudclientes.repositories.ClientRepository;
import com.anapedra.crudclientes.services.exceptions.DatabaseException;
import com.anapedra.crudclientes.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Service
public class ClientService {

    private final ClientRepository repository;
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients =repository.findAll(pageable);
        return clients.map(ClientDTO::new);

    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        var entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ClientDTO(entity);
    }


    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        // User user = authService.authenticated();
        try {
            var entity= new Client();
            copyDtoToEntity(dto, entity);
            repository.save(entity);
            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + dto.getId());
        }

    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {

            var entity= repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            repository.save(entity);
            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setIncome(dto.getIncome());
        entity.setChildren(dto.getChildren());

    }
}
