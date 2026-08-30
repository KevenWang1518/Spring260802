package com.wyjun.ServiceImpl;

import com.wyjun.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //后续使用AOP添加事务。

    @Override
    public void saveUser() {
        System.out.println("正在保存用户信息......");
    }

    @Override
    public void searchUser() {
        System.out.println("正在查询用户信息......");
    }
}
