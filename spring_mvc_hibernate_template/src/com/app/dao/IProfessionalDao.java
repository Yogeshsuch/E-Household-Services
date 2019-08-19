package com.app.dao;

import com.app.pojos.Professional;
import com.app.pojos.Skill;
import java.util.*;

public interface IProfessionalDao {

	String registerProfessional(Professional p);
	Professional loginProfessional(String email, String password);
	List<Skill> getSkill();
	Professional getDetails(int id);
	List<Professional> getProfessionalList();
	String verifyProfessional(int id);
}
