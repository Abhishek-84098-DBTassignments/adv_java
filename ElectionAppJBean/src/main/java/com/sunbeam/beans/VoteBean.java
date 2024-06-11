package com.sunbeam.beans;

import com.sunbeam.daoInterfaces.CandidateDao;
import com.sunbeam.daoInterfaces.UserDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {
	private int id;
	private int ctn=0;
	private int voteStatus;
	private int userStatus;
	private int userId;
	public VoteBean() {
	}
	public VoteBean(int id, int ctn, int voteStatus, int userStatus, int userId) {
		this.id = id;
		this.ctn = ctn;
		this.voteStatus = voteStatus;
		this.userStatus = userStatus;
		this.userId = userId;
	}
	public VoteBean(int id, int ctn, int voteStatus, int userStatus) {
		this.id = id;
		this.ctn = ctn;
		this.voteStatus = voteStatus;
		this.userStatus = userStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCtn() {
		return ctn;
	}
	public void setCtn(int ctn) {
		this.ctn = ctn;
	}
	public int getVoteStatus() {
		return voteStatus;
	}
	public void setVoteStatus(int voteStatus) {
		this.voteStatus = voteStatus;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void vote() {
		try(CandidateDao candDao = new CandidateDaoImpl();) {
			this.ctn = candDao.incrementVote(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getStatusVote() {
		try(UserDao userDao = new UserDaoImpl();) {
			User user = userDao.findById(id);
			if (user.getStatus() == 0) {
				this.voteStatus = 1;
			} else {
				this.voteStatus = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setStatusUser() {
		try(UserDao userDao = new UserDaoImpl();) {
			userDao.updateStatus(userId, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
