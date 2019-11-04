package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.ContactVendor;

public class ContactVendorDao implements IContactVendor {
	
	    //set Jdbc template
	
		JdbcTemplate template;
		public void setTemplate(JdbcTemplate template) {
		this.template = template;
		}
		
//insert vendor
		
		@Override
		public int insertContactVendorDetails(ContactVendor vencon)
		{
			
			//insert vendor details 
			
			String sql="insert into vendor(vname,vaddress,vlocation,vservice, "
					+ "pincode,isactive) values('"+
					vencon.getVname()+"','"+
					vencon.getVaddress()+"','"+
					vencon.getVlocation()+"','"+
					vencon.getVservice()+"',"+
					vencon.getPincode()+",'Y') ";
					template.update(sql);
			
			//getting max of vendor id from vendor details
			
			Integer maxvid=getMaxOfVendorId();
			System.out.println(maxvid);
			
			//insert into contact details 
			
			String sql2="insert into contact(cname,department,email,phone,vid) "
					+ "values('"+vencon.getCname()+"','"+
					vencon.getDepartment()+"','"+
					vencon.getEmail()+"','"+
					vencon.getPhone()+"',? )";
			return template.update(sql2,new Object[] {maxvid});		
		}
		
		//getting the max value of vendor id from vendor 
		
		private Integer getMaxOfVendorId() {
			
			String sql = "select MAX(vid)from vendor";
			Integer seq = template.queryForObject(sql, new Object[] {}, Integer.class);
			return seq;
		}

//get contact vendor details
		
	    @Override
		public List<ContactVendor> getAllDetails()
	    {
	    	return template.query("select v.vid,v.vname,v.vlocation,v.pincode,v.vservice,v.vaddress,c.cname,"
	    			+ "c.department,c.phone,c.email from Vendor v join Contact c"
	    			+ " on(v.vid=c.vid) where isactive='Y' order by v.vid desc",
							new RowMapper<ContactVendor>() {
								public ContactVendor mapRow(ResultSet rs, int row)
										throws SQLException {
									ContactVendor vencon = new ContactVendor();
									vencon.setVid(rs.getInt(1));
									vencon.setVname(rs.getString(2));
									vencon.setVlocation(rs.getString(3));
									vencon.setPincode(rs.getDouble(4));
									vencon.setVservice(rs.getString(5));
									vencon.setVaddress(rs.getString(6));
									vencon.setCname(rs.getString(7));
									
									vencon.setDepartment(rs.getString(8));
									vencon.setEmail(rs.getString(9));
									vencon.setPhone(rs.getString(10));
									
									return vencon;
								}
							});
	    }
	    
	    //get by id
	    
	    public ContactVendor getVendorById(int vid) {
			String sql = "select v.vid,v.vname,v.vlocation,v.vservice,v.vaddress,v.pincode,c.cName,"
	    			+ "c.department,c.phone,c.email from vendor v join contact c"
	    			+ " on(v.vid=c.vid) where isactive='Y' and v.vid=?";
			return template.queryForObject(sql, new Object[] {vid},
					new BeanPropertyRowMapper<ContactVendor>(ContactVendor.class));
		}
	    
//Disable Vendor
        @Override
		public int disableVendor(int vid) {
			
			String sql = "update vendor set isActive='N' where vid=?";
			return template.update(sql,new Object[] { vid });
		}

//update contact-vendor details
        
        @Override
		public int updateVendorDetails(ContactVendor vencon)
        {
        	//to update vendor 
        	
        	String sql="update vendor set vname='"+vencon.getVname()
        			      +"',vaddress='"+vencon.getVaddress()+"',vlocation='"
        			      +vencon.getVlocation()+"',vservice='"
        			      +vencon.getVservice()+"',pincode="+
        			      vencon.getPincode()+" where vid=?";
        	template.update(sql,new Object[] {vencon.getVid()});
        	
        	//to update contact details
        	
        	String sql2="update contact set cname='"+vencon.getCname()
        			      +"',department='"+vencon.getDepartment()
        			      +"',email='"+vencon.getEmail()+"',phone='"
        			      +vencon.getPhone()+"' where vid=?";
        	
        	return template.update(sql2,new Object[] {vencon.getVid()});

       }
        
 //searching vendor details
        
    	@Override
		public List<ContactVendor> searchVendorDetails(String searchString) {
			return template.query("select v.vid,v.vname,v.vlocation,v.vservice,c.cname,"
	    			+ "c.department,c.phone,v.vaddress,c.email,v.isactive,v.pincode from vendor v join contact c"
	    			+ " on(v.vid=c.vid) where v.isactive='Y' and v.vname LIKE '%"+searchString
	    			+"%' or v.vlocation LIKE '%"+searchString+"%' or v.vservice LIKE '%"+searchString+"%'",
							new RowMapper<ContactVendor>() {
								public ContactVendor mapRow(ResultSet rs, int row)
										throws SQLException {
									ContactVendor  vencon = new ContactVendor();
									 vencon.setVid(rs.getInt(1));
									 vencon.setVname(rs.getString(2));
									 vencon.setVlocation(rs.getString(3));
									 vencon.setVservice(rs.getString(4));
									 vencon.setCname(rs.getString(5));
									 vencon.setDepartment(rs.getString(6));
									 vencon.setPhone(rs.getString(7));
									 vencon.setVaddress(rs.getString(8));
									 vencon.setEmail(rs.getString(9));
									 vencon.setIsactive(rs.getString(10));
									 vencon.setPincode(rs.getDouble(11));
									return  vencon;
								}
							});
		}	
}
