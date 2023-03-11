<?php

namespace AdobeCommerce\SonarQube\Block;

class EmptyCatchCheck
{
    /**
     * Delete product by sku - Correct Catch Block
     */
    public function deleteProductBySku($sku)
    {
        try {
            $product = $this->productRepository->get($sku);
            $this->productRepository->delete($product);
        } catch (NoSuchEntityException $exception) {
            // product doesn't exist;
        } catch (Exception $e) {
            // product doesn't exist;
        }
    }

    /**
     * Load Product by sku - Correct Catch Block
     */
    public function loadProductBySku($sku)
    {
        try {
            $product = $this->productRepository->get($sku);
        } catch (NoSuchEntityException $exception) {
            throw $e;
        }
    }
}