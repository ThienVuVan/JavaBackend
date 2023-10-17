package fa.training.test;

import fa.training.dao.JobDao;
import fa.training.dao.JobDaolmpl;
import fa.training.entities.Jobs;

public class Test {

	public static void main(String[] args) {
		JobDao jobdao = new JobDaolmpl();
		Jobs job1 = new Jobs("J01", "Java Dev01", 1000, 2000);
		Jobs job2 = new Jobs("J02", "Java Dev02", 2000, 3000);
		jobdao.save(job1);
		jobdao.save(job2);
	}

}
