package am.gbr.common.service.impl;


import am.gbr.common.entity.Company;
import am.gbr.common.entity.User;
import am.gbr.common.exception.*;
import am.gbr.common.mapper.UserMapper;
import am.gbr.common.repository.CompanyRepository;
import am.gbr.common.repository.UserRepository;
import am.gbr.common.request.UserAuthRequest;
import am.gbr.common.request.UserRequest;
import am.gbr.common.response.UserAuthResponse;
import am.gbr.common.response.UserResponse;
import am.gbr.common.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;


    @Value("${file.htmlTemplate.name}")
    private String HTML_NAME;
    @Value("${file.htmlTemplate.path}")
    private String HTML_PATH;
    @Value("${file.htmlTemplate.message}")
    private String MESSAGE;

    @Override
    public UserResponse registration(UserRequest userRequest, String registerNumber) {
        if (!userRequest.isContractVerified()) {
            throw new UnVerifiedContractException();
        }
        Optional<Company> byRegisterNumber = companyRepository.findByRegisterNumber(registerNumber);
        if (byRegisterNumber.isEmpty()) {
            mailService.send(userRequest.getEmail(), "Ծանուցում", MESSAGE);
            throw new CompanyNotFoundException();
        }
        Optional<User> byEmail = userRepository.findByEmail(userRequest.getEmail());
        if (byEmail.isPresent()) {
            throw new EmailRepeatingException();
        }

        User user = userMapper.toEntity(userRequest);
        user.setCompany(byRegisterNumber.get());
        user.setActive(false);
        user.setCreatedDateTime(LocalDateTime.now());
        user.setMailVerifyToken(UUID.randomUUID());
        userRepository.save(user);
        try {
            mailService.sendHtmlEmail(user.getEmail(), "Welcome", user, HTML_PATH, HTML_NAME);
        } catch (MessagingException e) {
            log.error("email message to" + user.getEmail() + "didn't sent");
        }
        return userMapper.toResponse(user);
    }

    @Override
    public boolean verifyUser(String email, String token) {
        User user = userRepository.findByEmail(email).orElseThrow(EmailNotFoundException::new);
        if (user.getMailVerifyToken().equals(UUID.fromString(token))) {
            user.setMailVerified(true);
            user.setMailVerifyToken(null);
            userRepository.save(user);
            return true;
        }
        return false;
    }


    @Override
    public List<UserResponse> findAllByCompanyId(Long id) {
        List<User> users = userRepository.findALlByCompany_Id(id);
        return users.stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public void update(UserRequest userRequest, long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = userOptional.get();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        userRepository.save(user);
    }


    @Override
    public UserAuthResponse auth(UserAuthRequest userAuthRequest) throws UserNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(userAuthRequest.getEmail());
        if (byEmail.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = byEmail.get();
        if (passwordEncoder.matches(userAuthRequest.getPassword(), user.getPassword())) {
//            return new UserAuthResponse(jwtTokenUtil.generateToken(user.getEmail()),
//                    userMapper.toResponse(user));
            return new UserAuthResponse("new Token", userMapper.toResponse(user));
        }
        throw new UserNotFoundException();
    }

}
