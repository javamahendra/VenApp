package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/itemPorcess")
public class ItemServiceProvider {
	@Autowired
	private ICustomerService custService;
	@Autowired
	private CustomerValidator custValidator;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemService itemService;




	@Path("/saveItem")
	@POST
	public String saveItem(
			@HeaderParam("user")String un,
			@HeaderParam("password")String pwd,
			@HeaderParam("accToken")String token,
			String json){
		/**basic validations*/
		if(un == null || "".equals(un.trim()))
			return "Empty User name is not accepted";
		if(pwd == null || "".equals(pwd.trim()))
			return "Empty Password is not accepted";
		if(token == null || "".equals(token.trim()))
			return "Empty Token is not accepted";
		if(json == null || "".equals(json.trim()))
			return "Empty Json String is not accepted";
		
		/**cust existency check*/
		Customer cust=custService.getCustByUn(un);
		if(cust==null)
			return "Invalid customer details found";
		
		/**is custromer details valid or not with type*/
		if(!(custValidator.checkCustSellerDetailsValid(pwd, token, cust)))
			return "Invalid pwd/token or customer not allowed for operation";
	
		/**convert Json String to Item class Object*/
		Object ob=jsonUtil.convertJsontoObject(json, Item.class);
		if(ob==null)
			return "Inavlid Json String";
		Item item=(Item)ob;
		item.setCustId(cust.getCustId());
		
		/**send it to service layer for save operation*/
		int itemId=itemService.saveItem(item);
		
		/**at last return success msg on save */
		if(itemId>0)
			return "Item saved with Id:"+itemId;
		else
			return "Item is not saved";
	}
}


