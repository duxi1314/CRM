package com.itheima.crm.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.itheima.crm.domain.Customer;

/**
 * ClassName:CustomerService <br/>
 * Function: <br/>
 * Date: 2018年3月19日 下午3:41:17 <br/>
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CustomerService {

	@GET
	@Path("/findAll")
	List<Customer> findAll();

	@GET
	@Path("/findByUnAssociated")
	List<Customer> findByUnAssociated();

	@GET
	@Path("/findByAssociated")
	List<Customer> findByAssociated(
			@QueryParam("fixedAreaId") String fixedAreaId);

	@PUT
	@Path("/bindCustomer2FixedArea")
	void bindCustomer2FixedArea(@QueryParam("fixedAreaId") String fixedAreaId,
			@QueryParam("customerIds") Long[] customerIds);
}
