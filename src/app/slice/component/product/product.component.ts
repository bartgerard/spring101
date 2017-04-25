import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  text: string = 'a';
  product: Product = null;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.productService.ping().subscribe((text) => this.text = text);
  }

  ping(): void {
    //this.productService.findAll().subscribe((products: Product[]) => this.product = products[0]);
  }

}
