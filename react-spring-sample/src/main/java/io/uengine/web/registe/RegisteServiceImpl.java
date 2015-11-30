package io.uengine.web.registe;

import io.uengine.common.exception.ServiceException;
import io.uengine.mail.MailService;
import io.uengine.model.User;
import io.uengine.web.system.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class RegisteServiceImpl implements RegisteService {

    @Autowired
    @Qualifier("config")
    private Properties config;

    @Autowired
    private RegisteRepository registeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Override
    public void sendRegisteMail(String email) {

        User user = userRepository.selectByUserEmail(email);
        Registe registe = new Registe();
        registe.setUser_id(user.getId());

        String fromUser = config.getProperty("mail.contacts.address");
        String token = new String(Base64.encode(String.valueOf(System.currentTimeMillis()).getBytes()));
        registe.setToken(token);

        registeRepository.insert(registe);
        mailService.registe(registe.getUser_id(), token, "Confirm Registration", fromUser, "uengine", email, null);
    }

    @Override
    public void completeRegiste(String user_id, String token) {
        Registe registe = new Registe();
        registe.setUser_id(Long.parseLong(user_id));
        registe.setToken(token);
        Registe managedRegiste = registeRepository.selectByUserEmail(registe);
        if(managedRegiste == null) throw new ServiceException("가입 확인 처리할 대상이 없습니다.");

        User user = userRepository.selectByUserId(registe.getUser_id());
        userRepository.updateByAck(user.getEmail());

    }
}
