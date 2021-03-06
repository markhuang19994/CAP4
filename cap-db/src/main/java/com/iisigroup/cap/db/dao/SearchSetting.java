/*
 * Search.java
 *
 * Copyright (c) 2009-2011 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.db.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.iisigroup.cap.db.constants.SearchMode;
import com.iisigroup.cap.db.model.SearchModeParameter;

/**
 * <pre>
 * ISearch for dao use
 * </pre>
 * 
 * @since 2011/3/28
 * @author iristu
 * @version
 *          <ul>
 *          <li>2011/3/28,iristu,new
 *          <li>2011/6/10,RodesChen, add method
 *          </ul>
 */
public interface SearchSetting extends Serializable {

    String getEntityName();

    SearchSetting setEntityName(String entityName);

    /**
     * <pre>
     * 是否distinct result
     * </pre>
     * 
     * @param isDistinct
     *            true/false
     */
    void setDistinct(boolean isDistinct);

    /**
     * <pre>
     * 是否distinct result
     * </pre>
     * 
     * @return boolean
     */
    boolean isDistinct();

    boolean hasOrderBy();

    /**
     * Specify that results must be ordered by the passed column Null by default. 預設為升羃排序
     * 
     * @param orderBy
     *            the order by
     * @return T extends ISearch
     */
    SearchSetting addOrderBy(String orderBy);

    /**
     * Specify that results must be ordered by the passed column Null by default.
     * 
     * @param orderBy
     *            orderBy
     * @param orderDesc
     *            是否要降羃排序
     * @return T extends ISearch
     */
    SearchSetting addOrderBy(String orderBy, boolean orderDesc);

    SearchSetting setOrderBy(Map<String, Boolean> orderBy);

    Map<String, Boolean> getOrderBy();

    /**
     * 設定查詢的筆數
     * 
     * @param maxResults
     *            查詢筆數
     * @return T extends ISearch
     */
    SearchSetting setMaxResults(int maxResults);

    int getMaxResults();

    /**
     * 設定查詢的頁碼
     * 
     * @param firstResult
     *            查詢的頁碼
     * @return T extends ISearch
     */
    SearchSetting setFirstResult(int firstResult);

    int getFirstResult();

    List<SearchModeParameter> getSearchModeParameters();

    SearchSetting addSearchModeParameters(SearchMode searchMode, Object key, Object value);

    SearchSetting addSearchModeParameters(SearchSetting search);

}
