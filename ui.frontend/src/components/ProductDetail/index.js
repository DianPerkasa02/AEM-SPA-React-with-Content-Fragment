import { MapTo } from '@adobe/aem-react-editable-components';
import React, { Component } from 'react';

const ProductDetailEditConfig = {
    emptyLabel: 'Please configure Product Detail path',

    isEmpty(props) {
        return !props || !props.contentFragmentPath || props.contentFragmentPath.length < 1;
    },
};
class ProductDetail extends Component {
    render() {
        return <div>Product Detail Component</div>;
    }
}

export default MapTo('spa-react-with-content-fragment/components/contentfragments/productdetail')(
    ProductDetail,
    ProductDetailEditConfig
);