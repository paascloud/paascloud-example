package com.paascloud.mapper;

import com.paascloud.domain.PcUacUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * The interface Pc uac user mapper.
 * @author liuzhaoming
 */
@Mapper
public interface PcUacUserMapper {
    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    int insert(PcUacUser record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(PcUacUser record);

    /**
     * Select by primary key pc uac user.
     *
     * @param id the id
     * @return the pc uac user
     */
    PcUacUser selectByPrimaryKey(Long id);

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(PcUacUser record);

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(PcUacUser record);

    /**
     * Insert batch int.
     *
     * @param recordList the record list
     * @return the int
     */
    int insertBatch(List recordList);

    /**
     * Select count int.
     *
     * @param map the map
     * @return the int
     */
    int selectCount(Map map);

    /**
     * Select beans list.
     *
     * @param map the map
     * @return the list
     */
    List selectBeans(Map map);
}