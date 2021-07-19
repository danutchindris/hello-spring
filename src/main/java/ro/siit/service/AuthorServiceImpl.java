package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    public List<AuthorDto> findAll(final int offset, final int size) {
        return authorRepository.findAll(Pageable.ofSize(size).withPage(offset / size))
                .stream()
                .map(a -> new AuthorDto(a.getId(), a.getName()))
                .collect(Collectors.toList());
    }
}
