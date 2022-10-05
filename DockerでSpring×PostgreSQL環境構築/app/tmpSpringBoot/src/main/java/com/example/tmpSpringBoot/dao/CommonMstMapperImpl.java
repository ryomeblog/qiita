package com.example.tmpSpringBoot.dao;

import java.util.*;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.*;

import com.example.tmpSpringBoot.dao.generator.*;
import com.example.tmpSpringBoot.dto.generator.*;

/**
 * 「common_mst」テーブル用DAO
 */

@Repository
public interface CommonMstMapperImpl extends CommonMstMapper {

    /**
     * レコードを取得します。
     *
     * @param commonGroup グループ
     * @return レコード
     */
    List<CommonMst> selectByGroup(
            @Param("commonGroup") String commonGroup);

    /**
     * レコードを取得します。
     *
     * @param commonId ID
     * @param commonGroup グループ
     * @return レコード
     */
    List<CommonMst> selectByGroupAndId(
            @Param("commonId") String commonId,
            @Param("commonGroup") String commonGroup);
}
