package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CodecUtil;

@Component
public class CustomerValidator {
	@Autowired
	private CodecUtil codecUtil;
	
	private boolean checkCustTypeSeller(String custType){
		return "Seller".equals(custType);
	}
	private boolean checkReqAndDbForPwdTok(String reqPwd,String reqToken,Customer cust){
		//read db pwd,token
		String encPwd=cust.getPassword();
		String encTok=cust.getAccTock();
		//decode cust pwd and token
		String pwd=codecUtil.doDecode(encPwd);
		String tok=codecUtil.doDecode(encTok);
		//compare with req values
		return reqPwd.equals(pwd) && reqToken.equals(tok);
	}
	public boolean checkCustSellerDetailsValid(String reqPwd,String reqTok,Customer cust){
		return checkCustTypeSeller(cust.getCustType()) 
				&& checkReqAndDbForPwdTok(reqPwd, reqTok, cust);
	}
}






