package fa.training.test;

import java.time.LocalDate;

import fa.training.dao.Dao;
import fa.training.dao.JobDaoImpl;
import fa.training.entities.JobDetails;
import fa.training.entities.Jobs;

public class Test {

	public static void main(String[] args) {
		Dao jobDao = new JobDaoImpl();
		JobDetails jobDetail = new JobDetails("java dev level 1", LocalDate.of(2023, 6, 1));
		Jobs job = new Jobs("J01", "Java Dev1", 1000, 2000);
		job.setJobDetail(jobDetail);
		jobDao.save(job);
	}
}
