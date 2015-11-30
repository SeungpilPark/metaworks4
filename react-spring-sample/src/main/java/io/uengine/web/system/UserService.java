/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.uengine.web.system;

import io.uengine.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author Seungpil PARK
 * @since 2.0
 */
public interface UserService {

    /**
     * 이메일 확인 후 사용자의 가입 신청을 처리한다.
     *
     * @param email 사용자메일
     * @return true or false
     */
    boolean acknowledge(String email);

    /**
     * 이메일 확인 전 사용자의 가입 신청을 처리한다.
     *
     * @param userMap User Map
     * @return true or false
     */
    boolean createUser(Map userMap);

    /**
     * 사용자의 비밀번호를 변경한다.
     *
     * @param userMap User Map
     * @return true or false
     */
    boolean updatePassword(Map userMap);

    /**
     * 사용자를 삭제한다.
     *
     * @param email 사용자메일
     * @return true or false
     */
    boolean deleteUser(String email);

    /**
     * 사용자 정보를 수정한다.
     *
     * @param userMap User Map
     * @return true or false
     */
    boolean updateUserInfo(Map userMap);

    /**
     * 사용자 정보를 가져온다.
     *
     * @param email 사용자메일
     * @return User Information
     */
    User getUser(String email);

    /**
     * 사용자 정보를 가져온다.
     *
     * @param id 사용자아이디
     * @return User Information
     */
    User getUser(Long id);

    /**
     * 등록된 모든 사용자 정보를 가져온다.
     *
     * @param conditionMap 조회 조건
     * @return User List
     */
    List<Map> getUserAll(Map conditionMap);

    /**
     * 사용자의 비밀번호를 가져온다.
     *
     * @param email 사용자메일
     * @return 비밀번호
     */
    String getUserPassword(String email);

    /**
     * 사용자가 이메일 확인 대기중일 경우 true
     *
     * @param email 사용자메일
     * @return true or false
     */
    boolean waitingConfirmation(String email);

    /**
     * 사용자가 이메일 확인 완료일 경우 true
     *
     * @param email 사용자메일
     * @return true or false
     */
    boolean completeAccount(String email);

    /**
     * 사용자가에게 패스워드 변경 이메일을 보낸다.
     *
     * @param email 사용자메일
     */
    void sendPasswdMail(String email);

    boolean reqPasswdExist(String user_id, String token);


}
