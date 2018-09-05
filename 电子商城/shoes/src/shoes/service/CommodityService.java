package shoes.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoes.bean.CommodityBean;

public interface CommodityService extends BaseService<CommodityBean>{
	void upload(HttpServletRequest req,HttpServletResponse res,CommodityBean t);
	void updateUploadImage(CommodityBean t);
}
