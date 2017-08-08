import { Http, Response, RequestOptions,Headers } from '@angular/http'; 
import 'rxjs/add/operator/map';
import { Injectable,Component } from "@angular/core";

@Injectable() 
export class LoginService {
    userDetails: any;
    userName: string;
    token: any;
    url: string = 'http://192.168.3.144:9000/login';

    constructor(private _http: Http) { } 
    
    login(credentials:any){

        let headers = new Headers({ 'Content-Type': 'application/json' }); 
        let options = new RequestOptions({ headers: headers }); 
        return this._http.post(this.url, JSON.stringify(credentials), options) .map((response: Response)=>response.json());

    }
    register(credentials:any){
        let urlr = 'http://192.168.3.144:9000/register';

        let headers = new Headers(); 
        headers.append('Content-Type', 'application/json' );
        let options = new RequestOptions({ headers: headers }); 
        return this._http.post(urlr, JSON.stringify(credentials), options).map((response: Response)=>response.json());

    }
    logoutUser(Token:any){
        let urll = 'http://192.168.3.144:9000/logout';
        let headers = new Headers(); 
        let options = new RequestOptions({ headers: headers }); 
        headers.append('auth-token',Token);
        return this._http.delete(urll, options).map((response: Response)=>response.json());

    }
    setToken(Token:any){
        this.token=Token;
        console.log("logout ",this.token);
    }
    
    getToken(){
        return this.token;
    }
    postAdvertisement(credentials:any,tkn:any){
          console.log("tkn ",tkn);
        this.url='http://192.168.3.144:9000/postAd';
        let headers = new Headers(); 
             headers.append('auth-token',tkn);
                headers.append('Content-Type', 'application/json');
        let options = new RequestOptions({ headers: headers }); 
  return this._http.post(this.url, JSON.stringify(credentials), options) .map((response: Response)=>response.json());
    }
    
    setUserName(userName: string) {
        this.userName = userName;
        console.log(userName);
    }

    getUserName() {
        return this.userName;
    }
    getUserProfile(){

        console.log("bla bla:", this.token);
        let urlup = "http://192.168.3.144:9000/user?userId="+this.userName;
        let headers = new Headers();
        headers.append('auth-token', this.token);
        //headers.append('Content-Type', 'application/json');

        let options = new RequestOptions({ headers: headers });
        return this._http.get(urlup,options).map((response: Response) => response.json());
    }

setUserData(userDetails: any)
{
    this.userDetails = userDetails;
}

getUserData()
{
    return this.userDetails;
}

 }
