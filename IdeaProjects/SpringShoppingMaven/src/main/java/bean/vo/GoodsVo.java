package bean.vo;

public class GoodsVo {
	Integer goodsId;
	String goodsName;
	Float price;
	public GoodsVo(){}
//	public GoodsVo(int goodsId,String goodsName,)
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
}
