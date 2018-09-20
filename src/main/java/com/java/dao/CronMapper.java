package com.java.dao;

import com.java.model.Cron;

import java.util.List;

public interface CronMapper {

	Cron selectCronById(Integer cron);

	int deleteCronById(Integer cron);

	int updateCronById(Cron cron);

	int insertCron(Cron cron);

	List<Cron> findCronList(Cron cron);

}
