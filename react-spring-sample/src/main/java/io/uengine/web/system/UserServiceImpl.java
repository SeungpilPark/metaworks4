/**
 * Copyright (C) 2011 Flamingo Project (http://www.opencloudengine.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.uengine.web.system;

import io.uengine.common.exception.ServiceException;
import io.uengine.mail.MailService;
import io.uengine.model.User;
import io.uengine.web.configuration.ConfigurationHelper;
import io.uengine.web.registe.Registe;
import io.uengine.web.registe.RegisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Seungpil PARK
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("config")
    private Properties config;

    @Autowired
    private RegisteRepository registeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConfigurationHelper configurationHelper;

    @Autowired
    private MailService mailService;

    @Override
    public boolean acknowledge(String email) {
        return userRepository.updateByAck(email) > 0;
    }

    @Override
    public boolean createUser(Map userMap) {
        String email = (String) userMap.get("email");
        Long userId = null;

        if (userRepository.exist(email) > 0) {
            throw new ServiceException("이미 존재하는 사용자입니다.");
        }

        if (userRepository.insertByUser(userMap) > 0) {
            userId = userRepository.selectUserIdByUserEmail(email);
        }
        return userRepository.insertByAuth(userId) > 0;
    }

    @Override
    public boolean updatePassword(Map userMap) {
        return userRepository.updatePassword(userMap) > 0;
    }

    @Override
    public boolean deleteUser(String email) {
        return userRepository.deleteByEmail(email) > 0;
    }

    @Override
    public boolean updateUserInfo(Map userMap) {
        return userRepository.updateUserInfo(userMap) > 0;
    }

    @Override
    public User getUser(String email) {
        return userRepository.selectByUserEmail(email);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.selectByUserId(id);
    }

    @Override
    public List<Map> getUserAll(Map conditionMap) {
        return userRepository.selectAll(conditionMap);
    }

    @Override
    public String getUserPassword(String email) {
        return userRepository.selectPasswordByUserEmail(email);
    }

    @Override
    public boolean waitingConfirmation(String email) {
        User user = userRepository.selectByUserEmail(email);
        if (user != null) {
            if (!user.getEnabled())
                return true;
        }
        return false;
    }

    @Override
    public boolean completeAccount(String email) {
        User user = userRepository.selectByUserEmail(email);
        if (user != null) {
            if (user.getEnabled())
                return true;
        }
        return false;
    }

    @Override
    public void sendPasswdMail(String email) {
        User user = userRepository.selectByUserEmail(email);
        Registe registe = new Registe();
        registe.setUser_id(user.getId());

        String fromUser = config.getProperty("mail.contacts.address");
        String token = new String(Base64.encode(String.valueOf(System.currentTimeMillis()).getBytes()));
        registe.setToken(token);

        registeRepository.insert(registe);
        mailService.passwd(registe.getUser_id(), token, "Forgot Password", fromUser, "uengine", email, null);
    }

    @Override
    public boolean reqPasswdExist(String user_id, String token) {
        Registe registe = new Registe();
        registe.setUser_id(Long.parseLong(user_id));
        registe.setToken(token);
        Registe managedRegiste = registeRepository.selectByUserEmail(registe);
        if (managedRegiste == null)
            return false;
        return true;

    }

}
