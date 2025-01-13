    package mapper;

    import bean.vo.GoodsVo;
    import org.apache.ibatis.annotations.Mapper;
    import org.apache.ibatis.annotations.Param;

    import java.util.List;
    @Mapper
    public interface GoodsMapper {
        List<GoodsVo> getGoodsByPage(@Param("begin")int begin,@Param("size") int size );
        GoodsVo getGoodsById(Integer goodsId);
        int getPageCount();
        int saveGoods(GoodsVo newGoods);
        Integer modifyGoods(GoodsVo modifiedGoods);
        Integer deleteGoods(Integer goodsId);
    }
