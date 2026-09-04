package com.wyjun.service;

import com.wyjun.entity.Account;
import com.wyjun.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class IsolationService2 {

    @Autowired
    private AccountMapper accountMapper;

    //配置超时时间，当前事务如果执行的时长超过了指定的时间，即使最后事务成功了，也会回滚。
    @Transactional(timeout = 10)

    //@Transactional(readOnly = true)//设置为只读事务，适用于主从架构，读写分离，优化性能。
    public void saveAccount(Account account) {
        accountMapper.insertAccount(account);

        //模拟网络延迟
        try {
            TimeUnit.SECONDS.sleep(20);

            // 注意：数据库操作会触发事务的超时检查，而纯Java代码导致的延迟不会触发超时检查。
            // 因此在事务结束之前需要执行一个数据库的操作，CRUD都行，只对SQL语句检查。

            //触发timeout检查，需要执行SQL语句。
            accountMapper.selectAccountByActNo("act-001");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*
        Spring中发生异常之后的回滚策略的配置:
         1.默认情况下:
            运行时异常和Error都会回滚。
            编译时异常不会回滚。
        2.如果希望某个编译时异常也回滚?
            添加 rollbackFor 属性。
        3.如果希望某个运行时异常不回滚?
            添加 noRollbackFor 属性。

         // 示例1：任何异常（包括所有运行时异常和受检异常）发生都回滚
         @Transactional(rollbackFor = Exception.class)
         // 示例2：发生IOException（受检异常）或任何运行时异常时，都触发回滚
         @Transactional(rollbackFor = IOException.class)
         // 示例3：发生NullPointerException（运行时异常）时不回滚，但发生其他运行时异常或已配置的受检异常时仍会回滚。
         @Transactional(noRollbackFor = NullPointerException.class)
        */
    }
}
