package spa.with.content.fragment.react.core.models.impl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class ProductDetailImplTest {

    private final AemContext ctx = new AemContext(ResourceResolverType.RESOURCERESOLVER_MOCK);
    ProductDetailImpl modelImpl;
    private final String CP_PATH = "/content/dam/spa-react-with-content-fragment/content-fragment/product-details/test-product";

    @BeforeEach
    void setUp() {
        ctx.load().json("/spa/with/content/fragment/react/page/home.json", "/content/sample/en");
        ctx.currentResource("/content/sample/en/jcr:content/root/responsivegrid/productdetail");
        ctx.load().json("/spa/with/content/fragment/react/core/models/impl/product-detail.json", CP_PATH);

        modelImpl = ctx.request().adaptTo(ProductDetailImpl.class);
    }

    @Test
    void test_getProductDetailCFPath() {
        String actual = modelImpl.getProductDetailCFPath();
        assertEquals(CP_PATH, actual);
    }

    @Test
    void test_getExportedType() {
        final String expected = "spa-react-with-content-fragment/components/contentfragments/productdetail";
        String actual = modelImpl.getExportedType();
        assertEquals(expected, actual);
    }

    @Test
    void test_getSKU() {
        final String expected = "SKU123";
        String actual = modelImpl.getSKU();
        assertEquals(expected, actual);
    }

    @Test
    void test_getDescription() {
        final String expected = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque congue nunc felis, vitae porta nibh rhoncus eget. Proin sodales id nulla vitae fermentum. Proin sem arcu, vulputate id dictum non, varius eget tellus. Donec ac turpis sit amet ligula pretium tempus. Aenean vel turpis sem. Curabitur lectus nibh, congue auctor porta id, congue eget turpis. Nullam a varius lacus. Phasellus ullamcorper risus ac felis sagittis, eu fringilla velit volutpat. Morbi congue placerat lobortis. Praesent non hendrerit sem, eget efficitur nisl. Aenean lobortis risus at justo varius fringilla. Vivamus commodo commodo lorem, consectetur malesuada turpis bibendum vel. Nunc finibus accumsan viverra. Maecenas sollicitudin lacinia turpis eget tempus. Sed lectus odio, porttitor at magna a, sodales rutrum urna. Curabitur pellentesque pulvinar ligula.</p>&#xa;<p>Phasellus pellentesque ante dignissim consequat egestas. Phasellus vitae fermentum tortor. Curabitur eu blandit sem, id convallis felis. Suspendisse dolor lacus, tincidunt eget ante eget, feugiat dapibus augue. Nunc tincidunt dignissim consectetur. Etiam turpis urna, interdum non mollis sit amet, fermentum et odio. Duis nulla tortor, tincidunt venenatis lacinia sit amet, sagittis sed tellus. Etiam porta nulla leo, vel fermentum lectus ultricies non. Praesent mollis metus ultricies placerat suscipit. Integer non facilisis nisi. Quisque convallis pellentesque metus nec rutrum. Sed quis urna imperdiet, vehicula tortor in, ultricies urna. Morbi condimentum metus a diam vulputate venenatis. Morbi dignissim nulla et mauris tristique feugiat. Proin accumsan pulvinar commodo. Morbi faucibus, orci a sodales vulputate, purus orci lacinia nulla, nec dapibus mi diam et tortor.</p>&#xa;";
        String actual = modelImpl.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void test_getURL() {
        final String expected = "https://google.com";
        String actual = modelImpl.getURL();
        assertEquals(expected, actual);
    }

    @Test
    void test_getOpenInNewTab() {
        boolean actual = modelImpl.getOpenInNewTab();
        assertTrue(actual);
    }

    @Test
    void test_getProductName() {
        final String expected = "Test Product Name";
        String actual = modelImpl.getProductName();
        assertEquals(expected, actual);
    }
}