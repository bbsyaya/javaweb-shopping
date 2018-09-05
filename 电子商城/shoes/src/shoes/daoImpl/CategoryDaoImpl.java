package shoes.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shoes.bean.CategoryBean;
import shoes.dao.CategoryDao;
import shoes.util.DButil;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public void add(CategoryBean t) {
		String sql = "insert into category(id,categoryName,description,sort)values(null,?,?,?)";
		PreparedStatement pstm=DButil.getPreparStatement(sql);	
		try {
			pstm.setString(1, t.getCategoryName());
			pstm.setString(2, t.getDescription());
			pstm.setInt(3, t.getSort());
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
	public void delete(CategoryBean t) {
		String sql = "delete from category where categoryName = ?";
		if(queryByName(t)==null){
			System.out.println("信息不存在");
			return;
		}
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		try {
			pstm.setString(1, t.getCategoryName());
			if(pstm.executeUpdate()>0) System.out.println("删除成功");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
		}
	}

	@Override
	public void deleteById(CategoryBean t) {
		String sql = "delete from category where id = ?";
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
	public void update(CategoryBean t) {
		String sql = "update category set categoryName=?,description=?,sort=? where id = ?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		try {
			pstm.setString(1, t.getCategoryName());
			pstm.setString(2, t.getDescription());
			pstm.setInt(3, t.getSort());
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
	public CategoryBean queryByName(CategoryBean t) {
		CategoryBean bean = null;
		String sql = "select * from category where categoryName=?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs = null;
		try {
			pstm.setString(1,t.getCategoryName());
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				bean = new CategoryBean(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
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
	public CategoryBean queryById(CategoryBean t) {
		// TODO Auto-generated method stub
				CategoryBean bean = null;
				String sql = "select * from category where id=?";
				PreparedStatement pstm = DButil.getPreparStatement(sql);
				ResultSet rs =null;
				try {
					pstm.setInt(1, t.getId());
					rs =DButil.getResultset(pstm);
					while(rs.next()){
						bean = new CategoryBean(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
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
	public ArrayList<CategoryBean> queryAll() {
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		String sql = "select * from category order by sort ASC";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs =null;
		try {
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				CategoryBean bean = new CategoryBean(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
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
	public ArrayList<CategoryBean> queryAllOrderPage(int begin, int size) {
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		String sql = "select * from category order by sort ASC limit "+begin+","+size;
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs =null;
		try {
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				CategoryBean bean = new CategoryBean(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
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
		String sql = "select count(*) from category";
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

}
