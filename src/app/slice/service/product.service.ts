import {Injectable} from '@angular/core';
import {Http, Jsonp} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Product} from "../model/product";

@Injectable()
export class ProductService {
  apiRoot: string = "http://localhost:8080/products";

  constructor(private http: Http,
              private jsonp: Jsonp) {
  }

  ping(): Observable<Product> {
    const url = this.apiRoot + "/ping" + "?callback=JSONP_CALLBACK";
    return this.jsonp.request(url);
    //return this.http.get(url);
  }

  findAll(): Observable<Product> {
    const url = this.apiRoot;
    return this.http.get(url);
  }

}
