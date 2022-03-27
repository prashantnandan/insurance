package com.cybage.genworth.insurance.serviceImpl;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.genworth.insurance.exception.PolicyTypeException;
import com.cybage.genworth.insurance.model.Policy;
import com.cybage.genworth.insurance.repository.PolicyRepository;
import com.cybage.genworth.insurance.service.PolicyService;

/**
*
* @author Jeevan
*/
@Service
public class PolicyServiceImpl implements PolicyService{

	private static final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);
	
	@Autowired
	private PolicyRepository repo;

	//@Override
	public Iterable<Policy> getAllPolicy() {
		logger.info("Policy Service Implementation : getAllPolicy() method");
		return repo.findAll();
	}

	//@Override
	public Policy savePolicy(Policy policy) {
		logger.info("Policy Service Implementation : savePolicy() method");
		return repo.save(policy);
	}
	
	public Policy savethePolicy(Policy policy) {
		LocalDate date = LocalDate.now();
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfWeek());
		System.out.println(date.getDayOfYear());
		return repo.save(policy);
	}

	//@Override
	public Policy getPolicyById(Integer Id) {
		logger.info("Policy Service Implementation : getPolicyById() method");
		Policy policy=repo.findById(Id);//6
		if(policy==null) {
			throw new PolicyTypeException("Policy id "+Id+" incorrect..");
		}
		return policy;
	}
	
	

//	@Override
	public void deletePolicy(Integer id) {
		logger.info("Policy Service Implementation : deletePolicy() method");
		repo.deleteById(id);
	}

}
