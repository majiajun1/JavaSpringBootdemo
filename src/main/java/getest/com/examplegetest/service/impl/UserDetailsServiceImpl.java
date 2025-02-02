package com.examplegetest.service.impl;

import com.examplegetest.entity.UserDetails;
import com.examplegetest.mapper.UserDetailsMapper;
import com.examplegetest.service.IUserDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lbw
 * @since 2025-02-02
 */
@Service
public class UserDetailsServiceImpl extends ServiceImpl<UserDetailsMapper, UserDetails> implements IUserDetailsService {

}
