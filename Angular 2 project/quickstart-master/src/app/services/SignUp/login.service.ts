import { Http, Response, RequestOptions,Headers } from '@angular/http'; 
import 'rxjs/add/operator/map';
import { Injectable,Component } from "@angular/core";

@Injectable() 
export class LoginService {
    userDetails: any;
    userName: string;
    token: any;
    url: string = 'http://localhost:1919/advertise/login';

    constructor(private _http: Http) { } 
    
    login(credentials:any){

        let headers = new Headers({ 'Content-Type': 'application/json' }); 
        let options = new RequestOptions({ headers: headers }); 
        return this._http.post(this.url, JSON.stringify(credentials), options) .map((response: Response)=>response.json());

    }
    register(credentials:any){
        let urlr = 'http://localhost:1919/advertise/register';

        let headers = new Headers(); 
        headers.append('Content-Type', 'application/json' );
        let options = new RequestOptions({ headers: headers }); 
        return this._http.post(urlr, JSON.stringify(credentials), options).map((response: Response)=>response.json());

    }
    logoutUser(Token:any){
        let urll = 'http://localhost:1919/advertise/logout';
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
    displayMyAllAdv(authToken:any) {
        console.log('auth ',authToken);
        let url = "http://localhost:1919/advertise/posts";
        let headers = new Headers();
        headers.append('auth-token', authToken);
        headers.append('Content-Type', 'application/json');

        let options = new RequestOptions({ headers: headers });
        return this._http.get(url, options).map((response: Response) => response.json());


    }
    getActions(authToken:any){
        console.log('auth ',authToken);
        let url = "http://localhost:1919/advertise/actions";
        let headers = new Headers();
        headers.append('auth-token', authToken);
        headers.append('Content-Type', 'application/json');

        let options = new RequestOptions({ headers: headers });
        return this._http.get(url, options).map((response: Response) => response.json());
    }
    postAdvertisement(credentials:any,tkn:any){
          console.log("tkn ",tkn);
        this.url='http://localhost:1919/advertise/postAd';
        let headers = new Headers(); 
        let options = new RequestOptions({ headers: headers }); 

             headers.append('auth-token',tkn);
                headers.append('Content-Type', 'application/json');
  return this._http.post(this.url, JSON.stringify(credentials), options) .map((response: Response)=>response.json());
    }
    
    setUserName(userName: string) {
        this.userName = userName;
        console.log(userName);
    }

    getUserName() {
        return this.userName;
    }
    getUserProfile(authToken:any){

       console.log('auth ',authToken);
        let url = "http://localhost:1919/advertise/user";
        let headers = new Headers();
        headers.append('auth-token', authToken);
        headers.append('Content-Type', 'application/json');

        let options = new RequestOptions({ headers: headers });
        return this._http.get(url, options).map((response: Response) => response.json());
    }
    deleteAd(id: any,authToken:any) {
        console.log("tkn ",authToken);
        let url = "http://localhost:1919/advertise/post?postId="+id;
        let headers = new Headers();
        headers.append('auth-token', authToken);
        headers.append('Content-Type', 'application/json');
        let options = new RequestOptions({ headers: headers }); 
        return this._http.delete(url,options).map((response: Response) => response.json());
    }
    updateAd(obj:any,u_token:any){
        let url = "http://localhost:1919/advertise/postAd";
        let headers = new Headers();
        headers.append('auth-token', u_token);
        headers.append('Content-Type', 'application/json');

        let options = new RequestOptions({ headers: headers });

        let jsonReq = { "id": obj.id,"title": obj.title, "name": obj.name, "category": obj.category, "description": obj.description };
        console.log("id after", obj.id, "Json: ", jsonReq);
        return this._http.put(url, jsonReq, options)
            .map((response: Response) => response.json());
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
