package test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import com.zhq.AppConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =AppConfig.class)
public class TestHibernate {
	@Autowired
	private LocalSessionFactoryBean lsfb;
	@Autowired
	private DataSource ds;
	@Test
	public void testHib(){
		Assert.notNull(lsfb);
	}
	//用来生成表结构
	@Test
	public void testDDL() {
		Configuration cfg=lsfb.getConfiguration();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
	//检测DataSource
		@Test
		public void test1() {
			Assert.notNull(ds);
			try {
				Connection conn = ds.getConnection();
				Assert.notNull(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
