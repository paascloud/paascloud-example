package com.paascloud.service;

import com.paascloud.domain.PcUacUser;

/**
 * The interface Pc user service.
 *
 * @author liuzhaoming
 */
public interface PcUserService {

    /**
     * Instantiates a new Get by id.
     *
     * @param userId the user id
     */
    PcUacUser getById(Long userId);
}
