package eb.egonb.products.controller;

import eb.egonb.products.model.Product;
import eb.egonb.products.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;
import java.math.BigDecimal;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductDAO dao;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity voegProductToe(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "price")BigDecimal price){
        Product nProd = new Product();
        nProd.setName(name);
        nProd.setPrice(price);
        dao.save(nProd);

        return new ResponseEntity(HttpStatus.OK);
    }
}
