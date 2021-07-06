package ro.siit.service;

import ro.siit.model.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> findAll();
}
