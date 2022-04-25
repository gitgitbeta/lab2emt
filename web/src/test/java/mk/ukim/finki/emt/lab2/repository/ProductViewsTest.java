//package mk.ukim.finki.emt.lab2.repository;
//
//import mk.ukim.finki.emt.lab2.repository.jpa.views.ProductsPerCategoryViewRepository;
//import mk.ukim.finki.emt.lab2.service.CategoryService;
//import mk.ukim.finki.emt.lab2.service.ManufacturerService;
//import mk.ukim.finki.emt.lab2.service.ProductService;
//import mk.ukim.finki.emt.lab2.model.views.ProductPerCategoryView;
//import mk.ukim.finki.emt.lab2.model.views.ProductsPerManufacturerView;
//import mk.ukim.finki.emt.lab2.repository.jpa.views.ProductsPerManufacturerRepository;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProductViewsTest {
//
//    @Autowired
//    private ProductsPerCategoryViewRepository productsPerCategoryViewRepository;
//
//    @Autowired
//    private ProductsPerManufacturerRepository productsPerManufacturerRepository;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    @Autowired
//    private ManufacturerService manufacturerService;
//
//    @Autowired
//    private ProductService productService;
//
//    @Test
//    public void testProductPerCategoryFindAll()
//    {
//        List<ProductPerCategoryView> list=
//                this.productsPerCategoryViewRepository.findAll();
//        Assert.assertEquals(0,list.size());
//    }
//
//    @Test
//    public void testCreateNewProduct()
//    {
//       List<ProductsPerManufacturerView> list1=
//               this.productsPerManufacturerRepository.findAll();
//
//        Product product = new Product();
//        product.setName("Ski Jacket 55%");
//        product.setManufacturer(this.manufacturerService.findAll().get(0));
//        product.setCategory(this.categoryService.listCategories().get(0));
//
//        this.productService.save(product.getName(),product.getPrice(),product.getQuantity(),product.getCategory().getId(),product.getManufacturer().getId());
//
//        List<ProductsPerManufacturerView> list2=
//                this.productsPerManufacturerRepository.findAll();
//
//
//    }
//}
