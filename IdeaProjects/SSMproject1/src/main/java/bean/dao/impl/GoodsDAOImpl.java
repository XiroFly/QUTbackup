package bean.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DBBean;
import bean.dao.GoodsDAO;
import bean.vo.GoodsVo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class GoodsDAOImpl extends JdbcDaoSupport implements GoodsDAO {//父类里有template，spring用bean注入DataSource给父类
	public List<GoodsVo> getGoodsByPage(Object param[]){
		List<GoodsVo> goodsVoList = getJdbcTemplate().query("select * from goods limit ? offset ?", new BeanPropertyRowMapper<GoodsVo>(GoodsVo.class), param);//自己写的rowmapper则是调用GoodsVo里的set方法，再由spring调用rowmapper
		return goodsVoList;
	}


//		int numPerPage = 2;
//
//		ArrayList<GoodsVo> rst = new ArrayList();
//
//		String sql = "select * from goods";
//
//		DBBean db = new DBBean();
//		Connection con = db.getConnection();
//		ResultSet rs = null;
//
//		try {
//			 rs = db.executeQuery(sql, null);
//
//			 if(rs != null){
//				int index = 1;
//				int beginIndex = (pageNo - 1)*numPerPage+1;
//				int endIndex = pageNo * 2;
//
//				while(rs.next()){
//					if(index < beginIndex){
//						index ++;
//						continue;
//					}
//
//					if(index > endIndex){
//						index ++;
//						break;
//					}
//
//					String goodsId = rs.getString(1);
//					String goodsName = rs.getString(2);
//					Float price = rs.getFloat(3);
//
//					GoodsVo g = new GoodsVo();
//					g.setGoodsId(goodsId);
//					g.setGoodsName(goodsName);
//					g.setPrice(price);
//
//					rst.add(g);
//					index ++;
//				}
//			}
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rst;
//	}


	public GoodsVo getGoodsById(int goodsId){
		List<GoodsVo> goodsVo =  getJdbcTemplate().query("select * from goods where goodsid=?", new BeanPropertyRowMapper<GoodsVo>(GoodsVo.class), goodsId);
		return goodsVo.isEmpty()?null:goodsVo.get(0);
	}
//		GoodsVo g = null;
//
//		ArrayList rst = new ArrayList();
//
//		String sql = "select * from goods where goodsid=?";
//		ArrayList params = new ArrayList();
//		params.add(goodsId);
//
//		DBBean db = new DBBean();
//		Connection con = db.getConnection();
//		ResultSet rs = null;
//
//		try {
//			 rs = db.executeQuery(sql, params);
//
//			 if(rs != null){
//
//				rs.next();
//
//				String goodsId_ = rs.getString(1);
//				String goodsName = rs.getString(2);
//				Float price = rs.getFloat(3);
//
//				g = new GoodsVo();
//				g.setGoodsId(goodsId_);
//				g.setGoodsName(goodsName);
//				g.setPrice(price);
//
//		     }
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return g;
//	}

	public int getPageCount() {
		Integer amount =  getJdbcTemplate().queryForObject("select count(*) from goods", Integer.class);
		return (amount-1)/2+1;

	}

	@Override
	public void add(GoodsVo single) {
		getJdbcTemplate().update("insert into goods values (?,?,?)",single.getGoodsId(),single.getGoodsName(),single.getPrice());
	}

	@Override
	public void delete(int goodsId) {
		getJdbcTemplate().update("delete from goods where goodsid =?",goodsId);
	}

	@Override
	public void modify(GoodsVo single) {
       getJdbcTemplate().update("update goods set goodsname =? ,price =? where goodsid =?" ,single.getGoodsName(),single.getPrice(),single.getGoodsId() );
	}
//		int rst = 0;
//		DBBean db = new DBBean();
//		Connection con = db.getConnection();
//		String sql = "select count(*) from goods";
//		try {
//			ResultSet rs = db.executeQuery(sql,null);
//
//			String count = null;
//			if(rs.next())
//				 count = rs.getString(1);
//
//			rst = Integer.parseInt(count);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return (rst-1)/2+1;
//
//	}

}
