import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Product} from "../model/product";
import 'rxjs/add/operator/map';

@Injectable()
export class ProductService {
  apiRoot: string = "http://localhost:8080/products";

  constructor(private http: Http) {
  }

  ping(): Observable<string> {
    return this.http.get(this.apiRoot + "/ping").map(res => {
      return res.text();
    });
  }

  findAll(): Observable<Product> {
    const url = this.apiRoot;
    return this.http.get(url);
  }

}
