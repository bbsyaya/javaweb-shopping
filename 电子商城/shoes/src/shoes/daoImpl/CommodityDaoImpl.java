package shoes.daoImpl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import shoes.bean.CategoryBean;
import shoes.bean.CommodityBean;
import shoes.dao.CommodityDao;
import shoes.util.DButil;

public class CommodityDaoImpl implements CommodityDao{

	@Override
	public void add(CommodityBean t) {
		String sql = "insert into commodity(id,commodityName,categoryId,description,createDate,photo)values(null,?,?,?,?,?)";
		PreparedStatement pstm=DButil.getPreparStatement(sql);	
		try {
			pstm.setString(1, t.getCommodityName());
			pstm.setInt(2, t.getCategoryId());
			pstm.setString(3, t.getDescription());
			pstm.setTimestamp(4, t.getCreateDate());
			pstm.setString(5, t.getPhoto());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("添加失败");
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
		}
	}

	@Override
	public void delete(CommodityBean t) {
		String sql = "delete from commodity where commodityName = ?";
		if(queryByName(t)==null){
			System.out.println("信息不存在");
			return;
		}
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		try {
			pstm.setString(1, t.getCommodityName());
			if(pstm.executeUpdate()>0) System.out.println("删除成功");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
		}
		
	}

	@Override
	public void deleteById(CommodityBean t) {
		String sql = "delete from commodity where id = ?";
		if(queryById(t)==null){
			System.out.println("信息不存在");
			return;
		}
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		try {
			pstm.setInt(1, t.getId());
			if(pstm.executeUpdate()>0) System.out.println("删除成功");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
		}
		
	}

	@Override
	public void update(CommodityBean t) {
		String sql = "update commodity set commodityName=?,categoryId=?,description=? where id = ?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		try {
			pstm.setString(1, t.getCommodityName());
			pstm.setInt(2, t.getCategoryId());
			pstm.setString(3, t.getDescription());
			pstm.setInt(4, t.getId());
			if(pstm.executeUpdate()>0)System.out.println("修改成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
		}
		
	}

	@Override
	public CommodityBean queryByName(CommodityBean t) {
		CommodityBean bean =null;
		String sql = "select * from commodity where commodityName=?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs = null;
		try {
			pstm.setString(1,t.getCommodityName());
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				bean = new CommodityBean(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getTimestamp(5),rs.getString(6));
			}
			return bean;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
			DButil.closeResultset(rs);
		}
		return bean;
	}

	@Override
	public CommodityBean queryById(CommodityBean t) {
		CommodityBean bean =null;
		String sql = "select * from commodity where id=?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs = null;
		try {
			pstm.setInt(1, t.getId());;
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				bean = new CommodityBean(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getTimestamp(5),rs.getString(6));
			}
			return bean;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
			DButil.closeResultset(rs);
		}
		return bean;
	}

	@Override
	public ArrayList<CommodityBean> queryAll() {
		ArrayList<CommodityBean> list = new ArrayList<CommodityBean>();
		String sql = "select * from commodity order by sort ASC";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs =null;
		try {
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				CommodityBean bean = new CommodityBean(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getTimestamp(5),rs.getString(6));
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
			DButil.closeResultset(rs);
		}
		return list;
	}

	@Override
	public ArrayList<CommodityBean> queryAllOrderPage(int begin, int size) {
		ArrayList<CommodityBean> list = new ArrayList<CommodityBean>();
		String sql = "select * from commodity limit "+begin+","+size;
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs =null;
		try {
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				CommodityBean bean = new CommodityBean(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getTimestamp(5),rs.getString(6));
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
			DButil.closeResultset(rs);
		}
		return list;
	}

	@Override
	public int countOfRows() {
		int count=0;
		String sql = "select count(*) from commodity";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs = null;
		try {
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
			DButil.closeResultset(rs);
		}
		return count;
	}

	@Override
	public void upload(HttpServletRequest req, HttpServletResponse res, CommodityBean t) {
		try {
			
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			diskFileItemFactory.setSizeThreshold(10*1024);
			diskFileItemFactory.setRepository(new File(tempPath));
			
			ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
			upload.setHeaderEncoding("UTF-8");
			upload.setSizeMax(10*1024*1024);
			List<FileItem> fileItems = upload.parseRequest(req);
			for(FileItem item:fileItems){
				if (item.isFormField()) {
					processFormFiled(item, t);
				}else {
					processUploadFile(item, t);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void processFormFiled(FileItem item,CommodityBean t){
		String name = item.getFieldName();
		switch (name) {
		case "id":
			t.setId(Integer.parseInt(item.getString()));
			break;
		case "commodityName":
			t.setCommodityName(item.getString());
			break;
		case "categoryId":
			t.setCategoryId(Integer.parseInt(item.getString()));
			break;
		case "description":
			t.setDescription(item.getString());
			break;
		default:
			break;
		}
	}
	
	private void processUploadFile(FileItem item,CommodityBean t) throws Exception{
		String filename = item.getName();
		int index = filename.lastIndexOf("\\");
		filename = filename.substring(index+1, filename.length());
		long fileSize = item.getSize();
		if("".equals(filename)&&fileSize==0){
			System.out.println("文件名为空");
			return;
		}
		File uploadFile = new File(filePath+"/"+filename);
		item.write(uploadFile);
		t.setPhoto("/file"+"/"+filename);
	}

	@Override
	public void updateUploadImage(CommodityBean t) {
		String sql = "update commodity set photo=? where id = ?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		try {
			pstm.setString(1, t.getPhoto());
			pstm.setInt(2, t.getId());
			if(pstm.executeUpdate()>0)System.out.println("修改成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
		}
		
	}
}
