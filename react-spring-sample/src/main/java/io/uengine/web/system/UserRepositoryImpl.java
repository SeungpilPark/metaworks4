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

import io.uengine.common.repository.PersistentRepositoryImpl;
import io.uengine.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Seungpil PARK
 */
@Repository
public class UserRepositoryImpl extends PersistentRepositoryImpl<String, Object> implements UserRepository {

    @Override
    public String getNamespace() {
        return this.NAMESPACE;
    }

    @Autowired
    public UserRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public User selectByUserId(Long id) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByUserId", id);
    }

    @Override
    public User selectByUserEmail(String email) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByUserEmail", email);
    }

    @Override
    public Long selectUserIdByUserEmail(String email) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectUserIdByUserEmail", email);
    }

    @Override
    public int insertByUser(Map userMap) {
        return this.getSqlSessionTemplate().insert(this.getNamespace() + ".insertByUser", userMap);
    }

    @Override
    public int insertByManager(Map userMap) {
        return this.getSqlSessionTemplate().insert(this.getNamespace() + ".insertByManager", userMap);
    }

    @Override
    public int insertByAuth(Long userId) {
        return this.getSqlSessionTemplate().insert(this.getNamespace() + ".insertByAuth", userId);
    }

    @Override
    public int updateByAck(String email) {
        return this.getSqlSessionTemplate().update(this.getNamespace() + ".updateByAck", email);
    }

    @Override
    public List<Map> selectAll(Map conditionMap) {
        return this.getSqlSessionTemplate().selectList(this.getNamespace() + ".selectAll", conditionMap);
    }

    @Override
    public String selectPasswordByUserEmail(String email) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectPasswordByUserEmail", email);
    }

    @Override
    public int exist(String email) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".exist", email);
    }

    @Override
    public int updatePassword(Map userMap) {
        return this.getSqlSessionTemplate().update(this.getNamespace() + ".updatePassword", userMap);
    }

    @Override
    public int deleteByEmail(String email) {
        return this.getSqlSessionTemplate().delete(this.getNamespace() + ".deleteByUsername", email);
    }

    @Override
    public int updateUserInfo(Map userMap) {
        return this.getSqlSessionTemplate().update(this.getNamespace() + ".updateUserInfo", userMap);
    }

}