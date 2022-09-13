package com.example.tmpSpringBoot.service;

import static com.example.tmpSpringBoot.common.CommonUtils.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import com.example.tmpSpringBoot.dao.generator.*;
import com.example.tmpSpringBoot.dto.generator.*;

@Service
@Component("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    /** ユーザテーブルMapperImpl */
    @Autowired
    private UserMstMapper userMstMapper;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // ユーザIDのNULLチェック
        if (username == null) { throw new UsernameNotFoundException("ユーザIDが不正です"); }

        // ユーザ情報取得
        UserMst user = userMstMapper.selectByPrimaryKey(username);

        // ユーザIDのNULLチェック
        if (user == null) { throw new UsernameNotFoundException("ユーザは存在しません"); }

        // 権限を取得
        String role = getRole(user.getAuthority());

        return new User(user.getUserId(), user.getPassword(), AuthorityUtils.createAuthorityList(role));
    }

}
