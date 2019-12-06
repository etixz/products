package eb.egonb.products.controller;

import eb.egonb.products.model.Product;
import eb.egonb.products.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.math.BigDecimal;

@Controller
@RequestMapping(value = "/products")
public class IndexController {

    @Autowired
    ProductDAO dao;

    @ModelAttribute(value = "all")
    public Iterable<Product> findAll(){
        return dao.findAll();
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
    return "index";
    }
    /*public Iterable<Product> voegProductToe(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "price")BigDecimal price){
        Product nProd = new Product();
        nProd.setName(name);
        nProd.setPrice(price);
        dao.save(nProd);

        return new ResponseEntity(HttpStatus.OK);
        }*/

}
