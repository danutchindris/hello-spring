package ro.siit.service;

import ro.siit.model.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findById(Long id);

    Optional<UserDto> findByEmail(String email);
}
