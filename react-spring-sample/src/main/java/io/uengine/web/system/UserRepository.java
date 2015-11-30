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

import io.uengine.model.User;

import java.util.List;
import java.util.Map;

/**
 * 사용자 정보에 대한 CRUD 기능을 처리하는 User Repository
 *
 * @author Seungpil PARK
 */
public interface UserRepository {

    String NAMESPACE = UserRepository.class.getName();

    User selectByUserId(Long id);

    User selectByUserEmail(String email);

    List<Map> selectAll(Map conditionMap);

    Long selectUserIdByUserEmail(String email);

    String selectPasswordByUserEmail(String email);

    int exist(String email);

    int insertByUser(Map params);

    int insertByManager(Map params);

    int insertByAuth(Long userId);

    int updateUserInfo(Map userMap);

    int updateByAck(String email);

    int updatePassword(Map params);

    int deleteByEmail(String email);

}
