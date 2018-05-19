package com.paascloud.service.impl;

import com.paascloud.domain.PcUacUser;
import com.paascloud.mapper.PcUacUserMapper;
import com.paascloud.service.PcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Pc user service.
 * @author liuzhaoming
 */
@Service
public class PcUserServiceImpl implements PcUserService {
    private final PcUacUserMapper pcUacUserMapper;

    @Autowired
    public PcUserServiceImpl(PcUacUserMapper pcUacUserMapper) {
        this.pcUacUserMapper = pcUacUserMapper;
    }

    @Override
    public PcUacUser getById(Long userId) {
        return pcUacUserMapper.selectByPrimaryKey(userId);
    }
}
