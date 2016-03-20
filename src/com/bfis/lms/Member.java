/**
 * 
 */
package com.bfis.lms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan
 *
 */
public class Member {
	
	enum MemberType {student, staff}
	private int memberID;
	private String memberName;
	private MemberType memberType;
	private static int count;
	
	// constructor
	public Member(String memberName, MemberType type) {
		this.memberName = memberName;
		this.memberType = type;
		this.memberID = ++count;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	
	public boolean add(String amemberName, MemberType type) {
		Member newMember = new Member(amemberName, type); // should add to database
		int status = 0; // status should be updated from database
		return(status == 0 ? true : false); //returns true if status from database is 0 and false otherwise
		
	}
	
	public List<Member> search(int memberID) {
		return new ArrayList<Member>(); // should be fetched from database
	}
	
	public List<Member> search(String  memberName) {
		return new ArrayList<Member>(); // should be fetched from database
	}
	
public boolean update(String amemberName, MemberType type) {
		
	this.memberName = amemberName;
	this.memberType = type;		
		int status = 0; // status should be updated from database
		return(status == 0 ? true : false); //returns true if status from database is 0 and false otherwise
		
	}
	

}
