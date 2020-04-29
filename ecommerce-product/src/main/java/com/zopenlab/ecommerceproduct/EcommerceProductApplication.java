package com.zopenlab.ecommerceproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.zopenlab.ecommerceproduct.dao.IProductDAO;
import com.zopenlab.ecommerceproduct.model.Product;

@SpringBootApplication
@EnableDiscoveryClient
public class EcommerceProductApplication implements CommandLineRunner{

	@Autowired
	IProductDAO productDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productDAO.save(new Product( "Bougie fonctionnant au feu", "bougie qui fonctionne comme une ampoule mais sans électricité !", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/bougies.jpg", 22.0));
		productDAO.save(new Product( "Chaise pour s''assoire", "Chaise rare avec non pas 1 ni 2 mais 3 pieds", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/chaise.jpg", 95.0));
		productDAO.save(new Product( "Cheval pour nains", "Ce cheval ne portera certainement pas blanche neige, mais sans problème les nains", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/cheval.jpg", 360.0));
		productDAO.save(new Product( "Coq of steel, le superman des volailles", "Ne passe pas au four", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/coq.jpg", 620.0));
		productDAO.save(new Product( "Flacon à frotter avec un génie dedans", "Vous donne droit à l''équivalent de 3/0 voeux", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/flacon.jpg", 1200.0));
		productDAO.save(new Product( "Horloge quantique", "Donne l''heure, les minutes et même les secondes. Ne fait pas de café", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/horloge.jpg", 180.0));
		productDAO.save(new Product( "Table d''opération pour Hamsters", "Pour réaliser vos opérations chirugicales sur votre Hamster!", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/table.jpg", 210.0));
		productDAO.save(new Product( "Vase ayant appartenu a Zeus", "Risque de choc électrique", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/vase.jpg", 730.0));
		productDAO.findAll().forEach(p -> {
			System.out.println(p);
		});
		

	}

}
