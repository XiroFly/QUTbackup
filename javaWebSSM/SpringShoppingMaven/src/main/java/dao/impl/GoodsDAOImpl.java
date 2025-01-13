package dao.impl;

import java.sql.Types;
import java.util.List;

import bean.vo.GoodsVo;
import dao.GoodsDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("goodsDao")
public class GoodsDAOImpl implements GoodsDAO {

	@Resource(name="jdbcTemplate")
	JdbcTemplate jdbcTemplate;

	public List<GoodsVo> getGoodsByPage(int pageNo){
		int numPerPage = 2;
		int beginIndex = (pageNo - 1)*numPerPage;

		String sql = "select * from goods limit " + beginIndex + "," + numPerPage;

		RowMapper<GoodsVo> rowMapper = new BeanPropertyRowMapper<GoodsVo>(GoodsVo.class);
		return jdbcTemplate.query(sql, rowMapper, null);

	}
	
	
	public GoodsVo getGoodsById(Integer goodsId){
		String sql = "select * from goods where goodsid=?";

		RowMapper<GoodsVo> rowMapper = new BeanPropertyRowMapper<GoodsVo>(GoodsVo.class);

		GoodsVo rst = jdbcTemplate.queryForObject(sql, new Object[]{goodsId}, rowMapper);

		return rst;
	}

	public int getPageCount(){
		String sql = "select count(*) from goods";

		Integer rst = jdbcTemplate.queryForObject(sql, null, Integer.class);

		return (rst-1)/2+1;
		
	}

	@Override
	public Integer saveGoods(GoodsVo newGoods){
		Integer rst = -1;

		String sql = "insert into goods values (null,?,?)";

		rst = jdbcTemplate.update(sql, new Object[]{newGoods.getGoodsName(),newGoods.getPrice()});

		return rst;
	}

	@Override
	public Integer modifyGoods(GoodsVo modifiedGoods){
		Integer rst = -1;

		String sql = "UPDATE goods SET goodsName='" + modifiedGoods.getGoodsName() +
				"', price = " +  modifiedGoods.getPrice() + " WHERE goodsid = " +
				modifiedGoods.getGoodsId();

		rst = jdbcTemplate.update(sql);

		return rst;
	}

	@Override
	public Integer deleteGoods(Integer goodsId) {
		Integer rst = -1;

		String sql = "DELETE FROM goods" + " WHERE goodsid = " + goodsId;

		rst = jdbcTemplate.update(sql);

		return rst;
	}


}
