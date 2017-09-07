import { Http, Response } from '@angular/http'; 
import 'rxjs/add/operator/map';
import { Injectable,Component } from "@angular/core";

@Injectable() 
export class AdvertisementService {
    url: string='http://localhost:1919/advertise/categories';
    url2: string='http://localhost:1919/advertise/posts/search';
    constructor(private _http: Http) { } 
    getAllCategories() { 
        return this._http.get(this.url). map((response: Response)=>response.json()); 
    } 
    getAllAdvertisements(){
        return this._http.get(this.url2). map((response: Response)=>response.json()); 
    }
    allproducts(){
        let urlap = "http://localhost:1919/advertise/posts/search";
        return this._http.get(urlap).map((response:Response)=>response.json());
    }

    productscategory(){
        let urlpc = "http://localhost:1919/advertise/posts/search";
        return this._http.get(urlpc).map((response:Response)=>response.json());
    }

}
