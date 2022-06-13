package com.ty.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.AdminDao;
import com.ty.food.dto.Admin;

@Component
public class AdminServices {

	@Autowired
	AdminDao adminDao;

	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);

	}

	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);

	}

	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();

	}

	public Admin updateAdmin(Admin admin, int id) {
		return adminDao.updateAdmin(admin, id);

	}

	public boolean deleteAdmin(int id) {
		return adminDao.deleteAdmin(id);

	}

	public Admin getAdmin(String email, String password) {
		return adminDao.getAdmin(email, password);

	}

	public Admin validateAdmin(String email, String password) {
		return adminDao.validateAdmin(email, password);

	}

}
