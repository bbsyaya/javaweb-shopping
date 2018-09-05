package shoes.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoes.bean.CommodityBean;

public interface CommodityDao extends BaseDao<CommodityBean>{
		final String filePath = "E:/ClassHelpFile/file";
		final String tempPath = "E:/ClassHelpFile/temp";
		void upload(HttpServletRequest req,HttpServletResponse res,CommodityBean t);
		void updateUploadImage(CommodityBean t);
}
