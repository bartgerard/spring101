import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductComponent} from './component/product/product.component';
import {ProductService} from "./service/product.service";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    ProductComponent
  ],
  exports: [
    ProductComponent
  ],
  providers: [
    ProductService
  ]
})
export class SliceModule {
}
