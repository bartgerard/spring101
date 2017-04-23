import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.ping();
  }

  ping(): void {
    this.productService.ping().subscribe((product: Product) => this.product = product);
  }

}
