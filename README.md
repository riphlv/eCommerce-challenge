## Classes and structure

### Main
|Class|Function|Desc|Uses|
|------|------|------|-----|
|Main.class|main()|run application|CartFacade, ProductFacade|
||generateTestData()|Adds products to database|ProductFacade|

### Facades
|Class|Function|Desc|Uses|
|------|------|------|-----|
|ProductFacadeImpl.java|getAllProducts()|Retrieve a list of all products from database|ProductService|
||addProduct(Product)|Add specified product to database|ProductService|
||getProduct(String)|Get product from database by provided id|ProductService|
|CartFacadeImpl.java|getAllProducts()|Retrieve a list of products that have been added to specified cart||
||addProduct(Cart, Product)|Add specified product to a provided cart|CartService|
||addProduct(Cart, Product, BigDecimal)|Add specified product to a provided cart with quantity|CartService|
### Services
|Class|Function|Desc|Uses|
|------|------|------|-----|
|ProductServiceImpl.java|addProduct(Product)|Add provided product to database|ProductDatabase|
||getProduct(String)|Get product from database by provided id|ProductDatabase|
||getAllProducts()|Retrieve a list of all products from database|ProductDatabase|
|CartServiceImpl.java|addItemToCart(Cart, CartItem)|Add provided item to cart|
### DB
|Class|Function|Desc|
|------|------|------|
|ProductDatabaseImpl.java|addProduct(Product)|Adds product to database|
||removeProduct(Product)|Removes product from database|
||getProduct(String)|Retrieves a product matching the provided id|
||getAllProducts()|Retrieves all available products|
