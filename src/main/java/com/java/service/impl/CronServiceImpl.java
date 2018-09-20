package com.java.service.impl;

import com.java.model.Cron;
import com.java.dao.CronMapper;
import com.java.service.CronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CronServiceImpl implements CronService {

	private Logger log = LoggerFactory.getLogger(CronServiceImpl.class);
	@Autowired
	private CronMapper cronMapper;

	/**
	 * 插入
	 **/
	@Override
	public void insertCron(Cron cron) throws Exception {
		try {
			log.debug("insert {}",cron);
			cronMapper.insertCron(cron);
		} catch(Exception e) {
			log.error("insertCron异常 {}",cron,e);
			throw e;
		}
	}

	/**
	 * 查询
	 **/
	@Override
	public Cron selectCronById(Integer id) {
		log.debug("selectCronById  {}",id);
		return cronMapper.selectCronById(id);
	}

	/**
	 * 删除
	 **/
	@Override
	public void deleteCronById(Integer id)throws Exception {
		try {
			log.debug("deleteCronById  {}",id);
			int result = cronMapper.deleteCronById(id);
			if (result < 1) {
				throw new Exception("deleteCronById失败");
			}
		} catch(Exception e) {
			log.error("deleteCronById  {}",id,e);
			throw e;
		}
	}
	/**
	 * 更新
	 **/
	@Override
	public void updateCronById(Cron cron) throws Exception {
		try {
			log.debug("updateCronById  {}",cron);
			int result = cronMapper.updateCronById(cron);
			if (result < 1) {
				throw new Exception("updateCronById失败");
			}
		} catch(Exception e) {
			log.error("updateCronById  {}",cron,e);
			throw e;
		}
	}

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	@Cacheable(value = "findCronList",keyGenerator = "keyGenerator")
	@Override
	public List<Cron> findCronList(Cron cron) throws Exception {
		try {
			log.debug("findCronList  {}",cron);
			return cronMapper.findCronList(cron);
		} catch(Exception e) {
			log.error("findCronList  {}",cron,e);
			throw e;
		}
	}
}
