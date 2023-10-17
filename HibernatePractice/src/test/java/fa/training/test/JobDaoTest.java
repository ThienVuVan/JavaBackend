package fa.training.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fa.training.daoimpl.JobDaoImpl;
import fa.training.daoimpl.JobDetailDaoImpl;
import fa.training.entities.Job;
import fa.training.entities.JobDetail;

public class JobDaoTest {
	public static JobDaoImpl jobdao;
	public static JobDetailDaoImpl jobdetaildao;

	@Before
	public void setUp() {
		jobdao = new JobDaoImpl();
		jobdetaildao = new JobDetailDaoImpl();
	}

	@Test
	public void Test() {
		//Job job = new Job("J06", "Dev6", 1000, 2000);
		Job job = jobdao.getById("J06");
		//JobDetail jobdetail = new JobDetail("develop 06", LocalDate.of(2023, 4, 1));
		JobDetail jobdetail = jobdetaildao.getById(5);
		jobdetail.setJob(job);
		assertTrue(jobdetaildao.saveorupdate(jobdetail));
	}

}
