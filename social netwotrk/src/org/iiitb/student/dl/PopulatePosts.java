package org.iiitb.student.dl;

import java.sql.ResultSet;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PopulatePosts {
 List<Post> postList=new ArrayList<>();
 public  PopulatePosts(Student s){
 try 
  {
	PreparedStatement ps=ConnectionPool.getConnection().prepareStatement("select * from posts,friends where posts.roll_no = friends.friendroll_no and friends.roll_no = ?");
	ps.setString(1, s.getRollNo());
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		Post post=new Post();
		String roll_no=rs.getString("roll_no");
		String content=rs.getString("content");
	    Date timestap=rs.getTimestamp("timestap");
	    System.out.println(roll_no+""+content+""+timestap);
		post.setRoll_no(roll_no);
		post.setContent(content);
		post.setTimestap(timestap);
		postList.add(post);
	}
	
  }catch(Exception e)
	{
		System.out.println("poulate exception"+e);
	}
  }
  public List<Post> getList()
  {
	  return this.postList;
  }
}
