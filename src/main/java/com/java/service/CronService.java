package com.java.service;

import com.java.model.Cron;
import java.util.List;
public interface CronService {

	/**
	 * 主键查询
	 **/
	Cron selectCronById(Integer id);

	/**
	 * 主键删除
	 **/
	void deleteCronById(Integer id) throws Exception;

	/**
	 * 主键更新
	 **/
	void updateCronById(Cron cron) throws Exception;

	/**
	 * 插入
	 **/
	void insertCron(Cron cron) throws Exception;

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	List<Cron> findCronList(Cron cron) throws Exception;

}
