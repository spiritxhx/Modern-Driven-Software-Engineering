
package whsdu.se.DAL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;







import whsdu.se.DAO.*;


public class Dal {
	protected static String dbClassName = 
		"com.microsoft.sqlserver.jdbc.SQLServerDriver";//���ݿ�����������
	protected static String dbUrl = "jdbc:sqlserver://localhost:1433;"
		+ "DatabaseName=cardmange;";//���ݿ�����URL
	protected static String dbUser = "sa";				//���ݿ��û���
	protected static String dbPwd = "123456";			//���ݿ�����
	private static Connection conn = null;				//���ݿ����Ӷ���
	private Dal() {										//Ĭ�Ϲ��캯��
		try {
			if (conn == null) {							//������Ӷ���Ϊ��
				Class.forName(dbClassName);				//����������
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);//������Ӷ���
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}




	private static ResultSet executeQuery(String sql) {	//��ѯ����
		try {
			if(conn==null)  new Dal();  //������Ӷ���Ϊ�գ������µ��ù��췽��
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql);//ִ�в�ѯ
		} catch (SQLException e) {
			e.printStackTrace();
			return null;				//����nullֵ
		} finally {
		}
	}




	private static int executeUpdate(String sql) {		//���·���
		try {
			if(conn==null)  new Dal();	//������Ӷ���Ϊ�գ������µ��ù��췽��
			return conn.createStatement().executeUpdate(sql);//ִ�и���
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
		}
	}



	public static void close() {//�رշ���
		try {
			conn.close();//�ر����Ӷ���		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;	//�������Ӷ���Ϊnullֵ
		}
	}




	/*
	 * ��¼����
	 */
	public static users check(String name, String password) {
		users user=new users();//����Ա��Ϣ����
		String sql = "select * from users where name= '" + name
		+ "' and password='" + password+"'";//��ѯ�ַ���
		ResultSet rs = Dal.executeQuery(sql);//ִ�в�ѯ
		try {
			while(rs.next()) {//�����ѯ���˼�¼
				user.setCardid(rs.getInt("cardid"));
				user.setName(rs.getString("name")) ;
				user.setUserstype(rs.getString("userstype")) ;
				user.setPassword(rs.getString("password"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCarid(rs.getInt("carid"));
				user.setOverage(rs.getInt("overage"));
				user.setTel(rs.getInt("tel"));
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//�ر����Ӷ���
		return user;//���ز���Ա��Ϣ����
	}

	/*
	 *��ѯ�Ʒѱ�׼
	 * */
	public static charger  searchcharge(String sql){
		charger charger = new charger();//�Ʒѱ�׼����
		ResultSet rs = Dal.executeQuery(sql);//ִ�в�ѯ
		try {
			while(rs.next()) {//�����ѯ����
				charger.setCardtype(rs.getString("cardtype"));//���üƷѱ�׼��������
				charger.setCharge(rs.getInt("fee"));//���üƷѱ�׼����
				charger.setStationtype(rs.getString("stationtype"));//���üƷѱ�׼��λ����
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	
		return charger;
	}


	public static users searchcominfo(String sql){
		users user = new users();
		ResultSet rs = Dal.executeQuery(sql);
		try {
			while(rs.next()) {
				user.setCardid(rs.getInt("cardid"));
				user.setName(rs.getString("name")) ;
				user.setUserstype(rs.getString("userstype")) ;
				user.setPassword(rs.getString("password"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCarid(rs.getInt("carid"));
				user.setOverage(rs.getInt("overage"));
				user.setTel(rs.getInt("tel"));
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();
		return user;
	}

	/*
	 * ʵ�ֳ��볡��ѯ
	 * 
	 * */
	public static int count(String sql){
		int i = 0;
		ResultSet rs = Dal.executeQuery(sql);//ִ�в�ѯ
		try {
			while(rs.next()) {//�����ѯ����
				i = rs.getInt(1);//�õ�count
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//�ر����Ӷ���
		return i ; //����i
	}


	/*
	 * 
	 * ʵ����ͨ�û�ע��
	 * 
	 * */
	public static int comzhuce(int cardid,String name,String password,String cardtype,int overage,int tel,int carid){
		int i=0;
		try{
			String sql="insert users(cardid,name,password,cardtype,overage,tel,carid,userstype) values("+cardid+",'"+name+"','"+password+"','"+cardtype+"',"+overage+","+tel+","+carid+",'��ͨ�û�')";//���û���Ϣ�������ݿ���
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}


	/*
	 * 
	 * ʵ�ֹ���Աע��
	 * 
	 * */
	public static int manzhuce(int cardid,String name,String password){
		int i=0;
		try{
			String sql="insert users(cardid,name,password,userstype) values("+cardid+",'"+name+"','"+password+"',"+"'����Ա')";//������Ա��Ϣ���뵽���ݿ���
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

	/*
	 * �շѱ�׼�޸�
	 * 
	 * 
	 * */

	public static void gaicharge(String sql){
		try{
			Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ;
	}


	/*
	 * ��ֵ
	 * */
	public static void chongzhi(String sql){
		try{
			Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ;
	}

	/*
	 * ��λ��ѯ
	 * */

	public static sit_infor chewei(String sql){
		sit_infor sit = new sit_infor();//��λ��Ϣ����
		ResultSet rs = Dal.executeQuery(sql);//ִ�в�ѯ
		try {
			while(rs.next()) {//�����ѯ����
				sit.setStationid(rs.getInt("stationid"));
				sit.setStationtype(rs.getString("stationtype"));
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//�ر����Ӷ���
		return sit;
	}

	/*
	 * ��ǰ���ó�λ��Ϣ
	 * */
	public static List nowstation(){
		List list=new ArrayList();
		String sql= "select stationid,stationtype from sit_infor  where stationid not in (select distinct stationid  from park where endpark is  null)";//��ѯ��ǰ���ó�λ����Ϣ
		ResultSet rs=Dal.executeQuery(sql);
		try {
			while(rs.next()){
				sit_infor sit = new sit_infor();//��λ��Ϣ����
				sit.setStationid(rs.getInt("stationid"));//�趨��λ��Ϣ�ĳ�λ��
				sit.setStationtype(rs.getString("stationtype"));//�趨��λ��Ϣ�ĳ�λ����
				list.add(sit);//����ѯ�õ��ĳ�λ��Ϣ���뵽ArrayList()��
			}
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * �����볡
	 * 
	 */
	public static int parkin(int cardid,int stationid,String stationtype,String startpark){
		int i=0;
		try{
			String sql="insert park(cardid,stationid,stationtype,startpark) values("+cardid+","+stationid+",'"+stationtype+"','"+startpark+"')";//���볡������Ϣ���뵽���ݿ���
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
			System.out.print(1);
		}
		return i;
	}


	/*
	 * ��������
	 * */	
	public static int Updatepass(String password,String name){
		int i=0;
		try{
			String sql="update users set password='"+password+"' where  name='"+name+"'";//�������ݿ��е��û�����
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Dal.close();
		return i;
	}


	/*
	 * ����
	 * 
	 * */
	public static void Updatepark(String endpark,int fee,int sumpark,int cardid,String startpark){
		try{
			String sql = "update park set endpark = '"+endpark+"' ,sumpark = "+sumpark +",fee ="+ fee +"where cardid ="+ cardid+" and startpark ='" +startpark+"'";
			Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Dal.close();
	}



	//�ڳ���ʱ�����ڸ����û������
	public static void Updateoverage(int cardid,int overage){
		try{
			String sql = "update users set overage = "+overage +"where cardid = "+cardid;
			Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Dal.close();
	}



	/*
	 * �û�����
	 * */
	public static park parkout(String sql){
		park park = new park();
		ResultSet rs = Dal.executeQuery(sql);//ִ�в�ѯ
		try {
			while(rs.next()) {//�����ѯ����
				park.setStartpark(rs.getString("startpark"));
				park.setCardid(rs.getInt("cardid"));
				park.setEndpark(rs.getString("endpark"));
				park.setFee(rs.getInt("fee"));
				park.setStationid(rs.getInt("stationid"));
				park.setSumpark(rs.getInt("sumpark"));
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//�ر����Ӷ���
		return park;
	}



	public static List selectcardid(int cardid){
		List list=new ArrayList();
		String sql= "select * from park where cardid ="+ cardid+" and sumpark is not null";
		ResultSet rs=Dal.executeQuery(sql);
		try {
			while(rs.next()){
				park park = new park();
				park.setCardid(rs.getInt("cardid"));
				park.setStationid(rs.getInt("stationid"));
				park.setStartpark(rs.getString("startpark"));
				park.setEndpark(rs.getString("endpark"));
				park.setSumpark(rs.getInt("sumpark"));
				park.setFee(rs.getInt("fee"));
				list.add(park);
			}
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return list;
	}



	public static List now(){
		List list=new ArrayList();
		String sql= "select * from park where endpark is  null";
		ResultSet rs=Dal.executeQuery(sql);
		try {
			while(rs.next()){
				park park = new park();
				park.setCardid(rs.getInt("cardid"));
				park.setStationid(rs.getInt("stationid"));
				park.setStartpark(rs.getString("startpark"));
				list.add(park);
			}
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return list;
	}


	public static int updateuser(int cardid,String name,String password,String cardtype,int overage,int tel,int carid){
		int i=0;
		try{
			String sql= "update users set name = '"+name+"',password = '"+password +"',cardtype = '"+cardtype +"',overage = "+overage+",tel = "+tel+",carid = "+carid+" where cardid ="+ cardid;
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}



	public static List selectuser(){
		List list=new ArrayList();
		String sql= "select * from users where userstype = 'normal'";
		ResultSet rs=Dal.executeQuery(sql);
		try {
			while(rs.next()){
				users user  = new users();
				user.setCardid(rs.getInt("cardid"));
				user.setName(rs.getString("name")) ;//���ò���Ա�û���
				user.setUserstype(rs.getString("userstype")) ;
				user.setPassword(rs.getString("password"));//���ù���Ա��
				user.setCardtype(rs.getString("cardtype"));
				user.setCarid(rs.getInt("carid"));
				user.setOverage(rs.getInt("overage"));
				user.setTel(rs.getInt("tel"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return list;
	}


	/*
	 * ɾ���û�
	 * 
	 * */

	public static int Deluser(int cardid){
		int i=0;
		try{
			String sql = "delete from users where cardid ="+ cardid;
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Dal.close();
		return i;
	}

}
