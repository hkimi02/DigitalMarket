package org.dsi.controller;

import org.dsi.entity.Category;
import org.dsi.entity.Product;
import org.dsi.repository.NodeSync;
import org.dsi.repository.ProductRepo;
import org.dsi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import Payload.ProducInfo;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/products")
public class ProductController {
 
	@Autowired
	ProductService ProductService;
	
	@Autowired
	ProductRepo ProductRepo;
	
	@Autowired
	private NodeSync nodesync;
	
	@PostMapping("/AddProduct")
	public ResponseEntity<?> AddProduct(@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name,@RequestParam("Quantite") int Quantite,
			@RequestParam("prix") double prix,@RequestParam(name="category",required = false) Category category){
		  			ProducInfo product=new ProducInfo(name,Quantite,prix,category);
		  			ProductService.AddProductService(product,file);
		  			JSONObject jsoUser=new JSONObject();
		  			jsoUser.appendField("title",name);
		  			String prod=nodesync.addProd(jsoUser);
		  			return new ResponseEntity<ProducInfo>(product,HttpStatus.OK);
	 }
	
	@GetMapping("/AllProduct")
	public ResponseEntity<?> AllProducts(){
		return ResponseEntity.ok(ProductRepo.findAll());
	}
	

}