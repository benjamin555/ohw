package cn.sp.ofs.excel.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sp.ofs.excel.utils.DBConnectionPool;

/**
* @author 陈嘉镇
* @version 创建时间：2014-7-4 下午5:09:07
* @email benjaminchen555@gmail.com
*/
public class InitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void init() throws ServletException {
		Connection c = DBConnectionPool.getConnection();
		Statement statement;
		try {
			statement = c.createStatement();
			String sql = "DROP ALL OBJECTS";
			statement.execute(sql);
			c.commit();
		} catch (SQLException e) {
			logger.error("error.",e);
		}
		super.init();
	}

}
