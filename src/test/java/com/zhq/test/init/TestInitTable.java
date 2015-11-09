package com.zhq.test.init;

import com.zhq.util.ConfigurationUtil;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lenovo on 2015/11/5.
 * @author 张洪强
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = "classpath:applicationContext.xml")
public class TestInitTable {
	@Resource
	private EntityManager em;

	/**
	 * 建表
	 * @throws IOException
	 */
	@Test
	public void test01CreateTable() throws IOException {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
		Configuration cfg = ConfigurationUtil.init(em, in);
		SchemaExport schemaExport = new SchemaExport(cfg);
		schemaExport.drop(true,true);
		schemaExport.create(true, true);
	}
}
