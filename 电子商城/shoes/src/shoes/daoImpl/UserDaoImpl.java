package shoes.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shoes.bean.UserBean;
import shoes.dao.UserDao;
import shoes.util.DButil;


public class UserDaoImpl implements UserDao{

	@Override
	public void add(UserBean t) {
		String sql = "insert into user(id,userName,password,email,phone,createDate)values(null,?,?,?,?,?)";
		PreparedStatement pstm=DButil.getPreparStatement(sql);	
		try {
			pstm.setString(1, t.getUserName());
			pstm.setString(2, t.getPassword());
			pstm.setString(3, t.getEmail());
			pstm.setString(4, t.getPhone());
			pstm.setTimestamp(5, t.getCreateDate());
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
	public void delete(UserBean t) {
		// TODO Auto-generated method stub
		String sql = "delete from user where userName = ?";
		if(queryByName(t)==null){
			System.out.println("信息不存在");
			return;
		}
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		try {
			pstm.setString(1, t.getUserName());
			if(pstm.executeUpdate()>0) System.out.println("删除成功");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
		}
		
	}

	@Override
	public void update(UserBean t) {
		String sql = "update user set userName=?,password=?,email=?,phone=? where id = ?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		try {
			pstm.setString(1, t.getUserName());
			pstm.setString(2, t.getPassword());
			pstm.setString(3, t.getEmail());
			pstm.setString(4, t.getPhone());
			pstm.setInt(5, t.getId());
			if(pstm.executeUpdate()>0)System.out.println("修改成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
		}
		
	}

	@Override
	public UserBean queryByName(UserBean t) {
		// TODO Auto-generated method stub
		UserBean userBean = null;
		String sql = "select * from user where userName=?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs = null;
		try {
			pstm.setString(1, t.getUserName());
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				userBean = new UserBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6),rs.getInt(7));
			}
			return userBean;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
			DButil.closeResultset(rs);
		}
		return userBean;
	}

	@Override
	public ArrayList<UserBean> queryAll() {
		// TODO Auto-generated method stub
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		String sql = "select * from user";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs = null;
		try {
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				UserBean userBean = new UserBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6),rs.getInt(7));
				list.add(userBean);
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
	public UserBean queryById(UserBean t) {
		// TODO Auto-generated method stub
		UserBean userBean = null;
		String sql = "select * from user where id=?";
		PreparedStatement pstm = DButil.getPreparStatement(sql);
		ResultSet rs = null;
		try {
			pstm.setInt(1, t.getId());
			rs = DButil.getResultset(pstm);
			while(rs.next()){
				userBean = new UserBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6),rs.getInt(7));
			}
			return userBean;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.closePreparStatement(pstm);
			DButil.closeResultset(rs);
		}
		return userBean;
	}

	@Override
	public void deleteById(UserBean t) {
		String sql = "delete from user where id = ?";
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
	public ArrayList<UserBean> queryAllOrderPage(int begin, int size) {
		// TODO Auto-generated method stub
				ArrayList<UserBean> list = new ArrayList<UserBean>();
				String sql = "select * from user limit "+begin+","+size;
				PreparedStatement pstm = DButil.getPreparStatement(sql);
				ResultSet rs = null;
				try {
					rs = DButil.getResultset(pstm);
					while(rs.next()){
						UserBean userBean = new UserBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6),rs.getInt(7));
						list.add(userBean);
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
		String sql = "select count(*) from user";
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


