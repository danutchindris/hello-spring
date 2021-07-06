package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.model.AuthorDto;
import ro.siit.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<AuthorDto> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(a -> new AuthorDto(a.getId(), a.getName()))
                .collect(Collectors.toList());
    }
}
