package com.cael.vraptor.controllers;

import javax.inject.Inject;

import com.cael.vraptor.products.Product;
import com.cael.vraptor.products.ProductDAO;
import com.cael.vraptor.products.ProductStatus;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
@Path("/product/")
public class ProductController {

	@Inject
	private Result result;

	@Inject
	private ProductDAO productDAO;

	@Get("create")
	public void form() {
		result.include("status", ProductStatus.values());
	}

	@Post("save")
	public void save(Product product) {
		 HystrixTestCommand hystrixTest = new HystrixTestCommand(product, productDAO);
		 hystrixTest.execute();

//		productDAO.save(product);

		result.redirectTo(this).form();
	}

	@Get("list")
	public void list() {
		result.include("products", productDAO.getByStatus(ProductStatus.OUT_OF_STOCK));
	}

}
