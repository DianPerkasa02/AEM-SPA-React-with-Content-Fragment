package spa.with.content.fragment.react.core.models.impl;

import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spa.with.content.fragment.react.core.models.ProductDetail;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { ProductDetail.class,
        ComponentExporter.class }, resourceType = ProductDetailImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ProductDetailImpl implements ProductDetail {
    private static final Logger LOG = LoggerFactory.getLogger(ProductDetailImpl.class);
    static final String RESOURCE_TYPE = "spa-react-with-content-fragment/components/contentfragments/productdetail";
    private static final String PRODUCT_NAME = "productName";
    private static final String SKU = "sku";
    private static final String DESCRIPTION = "description";
    private static final String URL = "url";
    private static final String OPEN_IN_NEW_TAB = "openInNewTab";
    @ValueMapValue
    private String productDetailCFPath;
    @Inject
    ResourceResolver resourceResolver;
    private ContentFragment contentFragment;

    @PostConstruct
    protected void init() {
        if (productDetailCFPath != null) {
            Resource fragmentResource = resourceResolver.getResource(productDetailCFPath);
            if (fragmentResource != null) {
                contentFragment = fragmentResource.adaptTo(ContentFragment.class);
            } else {
                LOG.debug("Fragment Resource is null");
            }
        }
    }

    @Override
    public String getProductDetailCFPath() {
        return productDetailCFPath;
    }

    @Override
    public String getExportedType() {
        return ProductDetailImpl.RESOURCE_TYPE;
    }

    public String getProductName() {
        return contentFragment.getElement(PRODUCT_NAME).getContent();
    }

    public String getSKU() {
        return contentFragment.getElement(SKU).getContent();
    }

    public String getDescription() {
        return contentFragment.getElement(DESCRIPTION).getContent();
    }

    public String getURL() {
        return contentFragment.getElement(URL).getContent();
    }

    public boolean getOpenInNewTab() {
        return Boolean.parseBoolean(contentFragment.getElement(OPEN_IN_NEW_TAB).getContent());
    }
}
